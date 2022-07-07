package com.example.engsafapc.health_data;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class splashScreen extends AppCompatActivity {
    private static int splash=5000;
    Animation top_anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_splash_screen );
        top_anim = AnimationUtils.loadAnimation ( splashScreen.this,R.anim.top );
        new Handler (  ).postDelayed ( new Runnable () {
            @Override
            public void run() {
                Intent intent=new Intent ( splashScreen.this , home.class);
                startActivity ( intent );
                finish ();
            }
        },splash );
    }
}
