package com.example.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Animation spider1, spider2;
    ImageView imgspider1, imgspider2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        spider1 = AnimationUtils.loadAnimation(this,R.anim.spider1_anim);
        spider2 = AnimationUtils.loadAnimation(this,R.anim.spider2_anim);

        imgspider1 = findViewById(R.id.p1);
        imgspider2 = findViewById(R.id.p2);

        imgspider1.startAnimation(spider1);
        imgspider2.startAnimation(spider2);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this,MainActivity2.class));
                finish();
            }
        },3000);

    }
}