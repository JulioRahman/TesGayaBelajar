package com.julio.tesgayabelajar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.julio.tesgayabelajar.gayabelajar.AudiotoriScrollingActivity;
import com.julio.tesgayabelajar.gayabelajar.KinestetikScrollingActivity;
import com.julio.tesgayabelajar.gayabelajar.VisualScrollingActivity;
import com.julio.tesgayabelajar.tes.TesAnakActivity;
import com.julio.tesgayabelajar.tes.TesSendiriActivity;

public class NavigationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Button mulai1 = findViewById(R.id.card1_mulai);
        Button mulai2 = findViewById(R.id.card2_mulai);

        mulai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iMulai1 = new Intent(NavigationDrawerActivity.this, TesSendiriActivity.class);
                NavigationDrawerActivity.this.startActivity(iMulai1);
            }
        });

        mulai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iMulai2 = new Intent(NavigationDrawerActivity.this, TesAnakActivity.class);
                NavigationDrawerActivity.this.startActivity(iMulai2);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_mulai) {

        } else if (id == R.id.nav_visual) {
            Intent iVisual = new Intent(this, VisualScrollingActivity.class);
            startActivity(iVisual);
        } else if (id == R.id.nav_auditori) {
            Intent iAudiotori = new Intent(this, AudiotoriScrollingActivity.class);
            startActivity(iAudiotori);
        } else if (id == R.id.nav_kinestetik) {
            Intent iKinestetik = new Intent(this, KinestetikScrollingActivity.class);
            startActivity(iKinestetik);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
