package com.mapadobrote.mapadobrote;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {
    private static final int SPLASH_SCREEN_DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        openNextPageAfter2Seconds();
        animateLogo();
        animateBuildings();
    }

    private void animateBuildings() {
        ImageView illustration = findViewById(R.id.illustration);
        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
                0,                 // toXDelta
                300 ,  // fromYDelta
                0);                // toYDelta
        animate.setDuration(1000);
        animate.setFillAfter(true);
        illustration.startAnimation(animate);

    }

    private void animateLogo() {
        ImageView logo = findViewById(R.id.mapa_dobrote_logo);
        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(
                logo,
                PropertyValuesHolder.ofFloat("scaleX", 1.1f),
                PropertyValuesHolder.ofFloat("scaleY", 1.1f));
        scaleDown.setDuration(450);

        scaleDown.setRepeatCount(1);
        scaleDown.setRepeatMode(ObjectAnimator.REVERSE);

        scaleDown.start();
    }


    private void openNextPageAfter2Seconds() {
        final SharedPreferences sharedPreferences = getSharedPreferences("mapaDobrote", MODE_PRIVATE);
        final boolean agree = sharedPreferences.getBoolean("agree", false);
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
