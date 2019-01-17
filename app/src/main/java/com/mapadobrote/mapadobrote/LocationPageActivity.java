package com.mapadobrote.mapadobrote;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class LocationPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_page);
        Location loc = new Location(1, "Zvecanska", "Srbija", "zvecanska 2", "10-20", "dom za decu bez roditelja", "zvecanska@gmail.com", "facebook/pages/zvecanska", "www.zvecanska.com");
        TextView nameOfLocationTxt = (TextView) findViewById(R.id.nameOfLocation_textView);
        nameOfLocationTxt.setText(loc.name);
        TextView stateOfLocationTxt = (TextView) findViewById(R.id.stateOfLocation_textView);
        stateOfLocationTxt.setText(loc.state);
        TextView addressOfLocationTxt = (TextView) findViewById(R.id.addressOfLocation_textView);
        addressOfLocationTxt.setText(loc.address);
        TextView workingHoursTxt = (TextView) findViewById(R.id.workingHours_textView);
        workingHoursTxt.setText(loc.workingHours);
        TextView descriptionOfLocationTxt = (TextView) findViewById(R.id.descriptionOfLocation_textView);
        descriptionOfLocationTxt.setText(loc.description);
        TextView emailOfLocationTxt = (TextView) findViewById(R.id.emailOfLocation_textView);
        emailOfLocationTxt.setText(loc.email);
        TextView facebookPageTxt = (TextView) findViewById(R.id.facebookPage_textView);
        facebookPageTxt.setText(loc.facebookPage);
        TextView webSiteTxt = (TextView) findViewById(R.id.webSite_textView);
        webSiteTxt.setText(loc.webSite);
    }
}
