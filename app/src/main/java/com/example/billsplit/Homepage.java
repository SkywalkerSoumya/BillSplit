package com.example.billsplit;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.widget.EditText;


import com.google.android.material.navigation.NavigationView;

public class Homepage extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navView;
    Toolbar toolbar;

    //EditText editUserName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        // code for sideview navigation bar
        drawerLayout = findViewById(R.id.navbarlayout);
        navView = findViewById(R.id.navview);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_open,R.string.navigation_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // code for set User Name in navigation bar header
        //editUserName = (EditText) findViewById(R.id.editUserName);

    }

}