package com.mapadobrote.mapadobrote;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    public static final int REQUEST_CODE = 101;
    private GoogleMap mMap;
    private List<Location> locationList;
    private BitmapDescriptor pinImage;
    private ProgressBar progressBar;
    private FusedLocationProviderClient fusedLocationClient;
    private android.location.Location userLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);


        progressBar = findViewById(R.id.progress_bar); // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        final SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        int myVersion = Build.VERSION.SDK_INT;
        if (myVersion > Build.VERSION_CODES.LOLLIPOP_MR1) {
            if (!checkIfAlreadyhavePermission()) {
                requestForSpecificPermission();
            } else {
                getLastLocation();
            }
        }
        pinImage = vectorToBitmap(R.drawable.ic_placeholder_pin_svgrepo_com, ContextCompat.getColor(this, R.color.mdbg));
        getLocations();


    }

    @SuppressLint("MissingPermission")
    private void getLastLocation() {
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(new OnSuccessListener<android.location.Location>() {
                    @Override
                    public void onSuccess(android.location.Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            MapsActivity.this.userLocation = location;
                            if (mMap != null) {
                                mMap.setMyLocationEnabled(true);
                                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                                        new LatLng(location.getLatitude(), location.getLongitude()), 12));
                            }
                        }
                    }
                });
    }

    private void getLocations() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LocationAPIService service = retrofit.create(LocationAPIService.class);

        service.listLocations().enqueue(new Callback<List<Location>>() {
            @Override
            public void onResponse(Call<List<Location>> call, Response<List<Location>> response) {
                if (response.isSuccessful()) {
                    MapsActivity.this.locationList = response.body();
                    for (Location location : response.body()) {
                        LatLng locationFromAddress = getLocationFromAddress(location.address);

                        if (locationFromAddress != null) {
                            location.lat = locationFromAddress.latitude;
                            location.lng = locationFromAddress.longitude;
                            MarkerOptions markerOptions = new MarkerOptions();
                            markerOptions.title(location.name);
                            markerOptions.icon(pinImage);
                            markerOptions.position(locationFromAddress);
                            mMap.addMarker(markerOptions);
                        }
                    }
                    progressBar.setVisibility(View.GONE);
                } else {
                    // error response, no access to resource?
                }
            }

            @Override
            public void onFailure(Call<List<Location>> call, Throwable t) {
                // something went completely south (like no internet connection)
                Log.d("Error", t.getMessage());
            }
        });
    }


    public LatLng getLocationFromAddress(String address) {
        LatLng latLng = null;
        Geocoder geocoder = new Geocoder(this);
        try {
            List<Address> list = geocoder.getFromLocationName(address, 1);
            if (list.size() >= 1)
                latLng = new LatLng(list.get(0).getLatitude(), list.get(0).getLongitude());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return latLng;
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnInfoWindowClickListener(this);
        if (userLocation != null) {
            mMap.setMyLocationEnabled(true);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                    new LatLng(userLocation.getLatitude(), userLocation.getLongitude()), 12));

        }

    }


    private boolean checkIfAlreadyhavePermission() {
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        int result2 = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        if (result == PackageManager.PERMISSION_GRANTED && result2 == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestForSpecificPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    getLastLocation();
                } else {
                    Toast.makeText(this, "Da bismo vam prikazali lokacije u vašoj neposrednoj blizini, molimo vas da nam dozvolite pristup vašoj lokaciji.", Toast.LENGTH_LONG).show();
                    requestForSpecificPermission();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Intent intent = new Intent(this, LocationPageActivity.class);
        intent.putExtra("extra_location", findLocationByMarker(marker));
        startActivity(intent);
    }

    private Location findLocationByMarker(Marker marker) {
        for (Location location : locationList) {
            if (TextUtils.equals(marker.getTitle(), location.name)) {
                return location;
            }
        }
        return null;
    }

    /**
     * Demonstrates converting a {@link Drawable} to a {@link BitmapDescriptor},
     * for use as a marker icon.
     */
    private BitmapDescriptor vectorToBitmap(@DrawableRes int id, @ColorInt int color) {
        Drawable vectorDrawable = ResourcesCompat.getDrawable(getResources(), id, null);
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        DrawableCompat.setTint(vectorDrawable, color);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}