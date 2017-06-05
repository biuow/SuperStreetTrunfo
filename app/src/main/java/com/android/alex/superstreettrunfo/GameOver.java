package com.android.alex.superstreettrunfo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class GameOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent ir = new Intent(getBaseContext(), SplashActivity.class);
                startActivity(ir);
                finish();
            }
        },5000);
    }
}
