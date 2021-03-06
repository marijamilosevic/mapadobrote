package com.mapadobrote.mapadobrote;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TermsOfUseActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_of_use);
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SharedPreferences sharedPreferences = getSharedPreferences("mapaDobrote", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("agree", true);
        editor.commit();
        if (editor.commit() == true) {
            Intent intent = new Intent(this, ChooseCategoryActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
