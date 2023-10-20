package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    ImageView logo;
    TextView text;
    Animation topAnim,bottonAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logo =findViewById(R.id.logo);
        text =findViewById(R.id.appname);
        topAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
        bottonAnim= AnimationUtils.loadAnimation(this,R.anim.top_anim);

        topAnim.setDuration(2000);
        bottonAnim.setDuration(2000);
        logo.setAnimation(topAnim);
        text.setAnimation(bottonAnim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}