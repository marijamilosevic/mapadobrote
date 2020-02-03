package com.mapadobrote.mapadobrote;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LocationPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_page);

        final Location loc = (Location) getIntent().getSerializableExtra("extra_location");

        TextView nameOfLocationTxt = findViewById(R.id.nameOfLocation_textView);
        TextView descriptionOfLocationTxt = findViewById(R.id.descriptionOfLocation_textView);
        TextView descriptionOfLocationTitleTxt = findViewById(R.id.descriptionOfLocationtitle_textView);
        TextView addressOfLocationTxt = findViewById(R.id.addressOfLocation_textView);
        TextView workingHoursTxt = findViewById(R.id.workingHours_textView);
        TextView phoneOfLocationTxt = findViewById(R.id.phoneOfLocation_textView);
        TextView emailOfLocationTxt = findViewById(R.id.emailOfLocation_textView);
        TextView emailTitleOfLocationTxt = findViewById(R.id.emailOfLocationTitle_textView);
        TextView facebookPageTxt = findViewById(R.id.facebookPage_textView);
        TextView facebookPageTitleTxt = findViewById(R.id.facebookPageTitle_textView);
        TextView webSiteTxt = findViewById(R.id.webSite_textView);
        TextView webSiteTitleTxt = findViewById(R.id.webSiteTitle_textView);
        TextView categoriesTxt = findViewById(R.id.categoriesOfLocation_textView);


        nameOfLocationTxt.setText(loc.name);
        addressOfLocationTxt.setText(loc.address);
        phoneOfLocationTxt.setText(loc.phone);

        if (TextUtils.isEmpty(loc.workingHours)) {
            workingHoursTxt.setText("Nije dostupno. Nazovite da proverite.");
        } else {
            workingHoursTxt.setText(loc.workingHours);
        }

        if (TextUtils.isEmpty(loc.description)) {
            descriptionOfLocationTxt.setVisibility(View.GONE);
            descriptionOfLocationTitleTxt.setVisibility(View.GONE);
        } else {
            descriptionOfLocationTxt.setText(loc.description);
        }

        if (TextUtils.isEmpty(loc.email)) {
            emailOfLocationTxt.setVisibility(View.GONE);
            emailTitleOfLocationTxt.setVisibility(View.GONE);
        } else {
            emailOfLocationTxt.setText(loc.email);
        }

        if (TextUtils.isEmpty(loc.facebookPage)) {
            facebookPageTxt.setVisibility(View.GONE);
            facebookPageTitleTxt.setVisibility(View.GONE);
        } else {
            facebookPageTxt.setText(loc.facebookPage);
        }
        if (TextUtils.isEmpty(loc.webSite)) {
            webSiteTxt.setVisibility(View.GONE);
            webSiteTitleTxt.setVisibility(View.GONE);
        } else {
            webSiteTxt.setText(loc.webSite);
        }

        if (!TextUtils.isEmpty(loc.categories)) {
            categoriesTxt.setText(loc.categories);
        }

        Button navigateButton = findViewById(R.id.button_navigate);
        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("google.navigation:q=" + loc.lat + "," + loc.lng);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }

}
