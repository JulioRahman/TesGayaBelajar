package com.julio.tesgayabelajar.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.julio.tesgayabelajar.NavigationDrawerActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = new Intent(this, NavigationDrawerActivity.class);
        startActivity(i);
        finish();
    }
}
