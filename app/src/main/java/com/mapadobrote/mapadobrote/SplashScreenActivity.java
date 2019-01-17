package com.mapadobrote.mapadobrote;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {
    private static final int SPLASH_SCREEN_DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        final SharedPreferences sharedPreferences = getSharedPreferences("mapaDobrote", MODE_PRIVATE);
        final boolean agree = sharedPreferences.getBoolean("allow", false);
        /*creating of Splash Screen*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (agree) {
                    Intent intent = new Intent(SplashScreenActivity.this, ChooseCategoryActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(SplashScreenActivity.this, TermsOfUseActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, SPLASH_SCREEN_DELAY);
    }


}
