package com.example.abc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splash extends AppCompatActivity {

    ImageView iv;
    Animation anm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent( getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        },4000);

        iv = findViewById(R.id.imageView2);
        anm = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        iv.startAnimation(anm);
    }
}