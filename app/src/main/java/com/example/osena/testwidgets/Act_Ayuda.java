package com.example.osena.testwidgets;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;


public class Act_Ayuda extends AppCompatActivity {

    MediaPlayer mp1;
    MediaPlayer mp2;
    MediaPlayer mp3;
    MediaPlayer mp4;
    ImageButton ima1;
    ImageButton ima2;
    ImageButton ima3;
    ImageButton ima4;
    reglaJuego iniJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__ayuda);

        ima1 = (ImageButton) findViewById(R.id.img_blue);
        ima2 = (ImageButton) findViewById(R.id.img_green);
        ima3 = (ImageButton) findViewById(R.id.img_red);
        ima4 = (ImageButton) findViewById(R.id.img_yellow);


        mp1 = MediaPlayer.create(this, R.raw.azulsound);
        mp2 = MediaPlayer.create(this, R.raw.greensound);
        mp3 = MediaPlayer.create(this, R.raw.redsound);
        mp4 = MediaPlayer.create(this, R.raw.yellowsound);

        iniJ = new reglaJuego();


        ima1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    ima1.setBackgroundResource(R.mipmap.img_blue_light);

                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    ima1.setBackgroundResource(R.mipmap.img_blue);
                    iniJ.playSound(mp1);

                }
                return true;
            }
        });

        ima2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    ima2.setBackgroundResource(R.mipmap.img_green_light);

                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    ima2.setBackgroundResource(R.mipmap.img_green);
                    iniJ.playSound(mp2);
                }
                return true;
            }

        });
        ima3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    ima3.setBackgroundResource(R.mipmap.img_red_light);

                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    ima3.setBackgroundResource(R.mipmap.img_red);
                    iniJ.playSound(mp3);
                }
                return true;
            }

        });
        ima4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    ima4.setBackgroundResource(R.mipmap.img_yellow_light);


                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    ima4.setBackgroundResource(R.mipmap.img_yellow);
                    iniJ.playSound(mp4);
                }
                return true;
            }

        });
    }
}
