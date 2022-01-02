package com.example.billsplit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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

        // Adding a delay in loading the next screen.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, onboardingScreen_1.class);
                startActivity(intent);
                finish(); // Using the finish function so that user can't revert back to this page pressing the back button.
            }
        }, SPLASH_SCREEN_TIME);
    }
}

