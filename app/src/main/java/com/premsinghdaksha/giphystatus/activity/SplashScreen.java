package com.premsinghdaksha.giphystatus.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.premsinghdaksha.giphystatus.R;

public class SplashScreen extends AppCompatActivity {
    public static final long Handler_DelayedL2 = 5000L;
    private ImageView spashImg_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        spashImg_ = findViewById(R.id.spashImg_);
        Glide.with(SplashScreen.this).load(R.drawable.giphy3).into(spashImg_);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SplashScreen.this.startActivity(new Intent(SplashScreen.this, MainActivity.class));
                SplashScreen.this.finish();
            }
        }, Handler_DelayedL2);
    }
}