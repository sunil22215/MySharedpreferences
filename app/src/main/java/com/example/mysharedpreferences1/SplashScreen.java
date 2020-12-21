package com.example.mysharedpreferences1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        setTimer();
    }

    private void setTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();

              /*  if (new User(SplashActivity.this).getName()!="") {
                    startActivity(new Intent(getApplicationContext(), WelcomeAcitvity.class));
                    finish();
                }else {

                }*/


            }
        },4000);
    }
}