package com.sompod44soft.rentgiant;

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
import android.widget.ImageButton;
import android.widget.Toast;

public class RentGiant_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private ImageButton imageButton1,imageButton2,imageButton3,imageButton4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_giant_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        imageButton1 = findViewById(R.id.ImageButtonID1);
        imageButton2 = findViewById(R.id.ImageButtonID2);
        imageButton3 = findViewById(R.id.ImageButtonID3);
        imageButton4 = findViewById(R.id.ImageButtonID4);



        imageButton1.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
        imageButton3.setOnClickListener(this);
        imageButton4.setOnClickListener(this);



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
        getMenuInflater().inflate(R.menu.rent_giant_, menu);
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

        if (id == R.id.nav_profile) {
            Toast.makeText(this, "Next Update!!!", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.nav_upload) {

        }
        else if (id == R.id.nav_favorite) {

        }
        else if (id == R.id.nav_share) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plane");
            String Subject = "Rent Giant";
            String body = "Your Best helper for finding vehicle/house/hostel of Rent. \n shahrearislam3@gmail.com";

            intent.putExtra(Intent.EXTRA_SUBJECT,Subject);
            intent.putExtra(Intent.EXTRA_TEXT,body);
            startActivity(Intent.createChooser(intent," Share With"));
        }
        else if (id == R.id.nav_send) {
            Intent intent = new Intent(this,Send_Feedback.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.ImageButtonID1){
            Intent intent = new Intent(RentGiant_Activity.this,Itemshow_Activity.class);
            intent.putExtra("checkvalue",1);
            startActivity(intent);
        }
        else if(v.getId() == R.id.ImageButtonID2){
            Intent intent = new Intent(this,Itemshow_Activity.class);
            intent.putExtra("checkvalue",2);
            startActivity(intent);
        }
        else if(v.getId() == R.id.ImageButtonID3){
            Intent intent = new Intent(this,Itemshow_Activity.class);
            intent.putExtra("checkvalue",3);
            startActivity(intent);
        }
        else if(v.getId() == R.id.ImageButtonID4){
            Intent intent = new Intent(this,Itemshow_Activity.class);
            intent.putExtra("checkvalue",4);
            startActivity(intent);
        }

    }
}
