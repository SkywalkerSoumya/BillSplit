package com.example.billsplit;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;


import com.google.android.gms.cast.framework.media.ImagePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class Homepage extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navView;
    Toolbar toolbar;
    //ImageView profilePic;
    //ImageButton changeProPicButton;

    
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

        //settle up button function
        Button settleup_btn = (Button) findViewById(R.id.settleUpBtn);

        settleup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Homepage.this,SettleUpPage.class);
                startActivity(intent1);
            }
        });

        // Expenses button function
        Button expenses_btn = (Button) findViewById(R.id.expensesBtn);

        expenses_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Homepage.this,Expenses_Details.class);
                startActivity(intent2);
            }
        });



        // code for changing profile picture  ---> CHANGES NEEDED!

       /* profilePic = findViewById(R.id.profileImageView);
        changeProPicButton = findViewById(R.id.editProfilePicImageButton);

        changeProPicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.Companion.with(Homepage.this)
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .cropOval()	    		//Allow dimmed layer to have a circle inside
                        .cropFreeStyle()	    //Let the user to resize crop bounds
                        .galleryOnly()          //We have to define what image provider we want to use
                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .createIntent();
            }
        });*/

    }

}