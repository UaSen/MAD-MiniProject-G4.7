package com.base.bawbaw.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.base.bawbaw.R;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.io.IOException;

public class SplashScreen extends AppCompatActivity {

    private TextView bawBawText;
    MediaPlayer barkPlay;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        bawBawText = findViewById(R.id.logo);

        handler = new Handler();

        //splash screen timer
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);

        //splash screen word shake
        YoYo.with(Techniques.Shake)
                .duration(2000)
                .repeat(1)
                .playOn(bawBawText);

        //splash screen sound
        barkPlay = MediaPlayer.create(this, R.raw.dogbark2);
        if (barkPlay != null) {
            barkPlay.start();
        } else {
            barkPlay.reset();
            try {
                barkPlay.prepare();
            } catch (IllegalStateException e) {

                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }

            barkPlay.start();
        }

    }

}
