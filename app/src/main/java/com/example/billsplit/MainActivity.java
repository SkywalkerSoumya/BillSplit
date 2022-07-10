package com.example.billsplit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN_TIME = 3000; // This contains how long splash screen will be visible.

    Animation topAnimation, bottomAnimation;
    ImageView logo;
    TextView appName;
    SharedPreferences sharedPreferences;   // This is used to store small amount of data in the device
    Boolean firstTimeUser;     // It will help to check if the app is opening for first time or not

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Removing the Status bar for the Splash Screen.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        // Defining animations
        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        // Defining the UI elements.
        logo = findViewById(R.id.logo);
        appName = findViewById(R.id.appName);

        // Adding animations to the UI elements.
        logo.setAnimation(topAnimation);
        appName.setAnimation(bottomAnimation);

        //initializing sharedPreferences and storing data in boolean for first time
        sharedPreferences = getSharedPreferences("OpeningPrefs", MODE_PRIVATE);
        firstTimeUser = sharedPreferences.getBoolean("firstTimeUser", true);

        // Adding a delay in loading the next screen.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences.Editor editor = sharedPreferences.edit();

                Intent intent;

//###############################################################################################################################
//                Commenting the portion to remove the chek for first time user. Needs to be uncommented later.
//###############################################################################################################################
//                if(firstTimeUser) {
//                    intent = new Intent(MainActivity.this, onboardingScreen_1.class);
//                    editor.putBoolean("firstTimeUser", false);
//                    editor.apply(); //updating boolean to false so that next time direct homepage will open
//                }else{
//                    intent = new Intent(MainActivity.this, CreateGroup.class);
//                }
//###############################################################################################################################

                intent = new Intent(MainActivity.this, Homepage.class);

                startActivity(intent);
                finish(); // Using the finish function so that user can't revert back` to this page pressing the back button.
            }
        }, SPLASH_SCREEN_TIME);
    }
}

