package com.mapadobrote.mapadobrote;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {
    private final int splashscreendelay = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        final Drawable drawable = getResources().getDrawable(R.drawable.bg);
        final Drawable drawable1 = getResources().getDrawable(R.drawable.logo);
        final Drawable drawable2 = getResources().getDrawable(R.drawable.illustration);
        /*creating of Splash Screen*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), SplashScreenActivity.class);
                startActivity(intent);
                finish();
            }
        }, splashscreendelay);
    }
}
