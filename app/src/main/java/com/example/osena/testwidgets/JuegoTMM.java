package com.example.osena.testwidgets;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.example.osena.testwidgets.R.id.tbNivel;

public class JuegoTMM extends AppCompatActivity {
    ImageButton ima1;
    ImageButton ima2;
    ImageButton ima3;
    ImageButton ima4;
    ImageView Semaf;
    TextView tv1;

    MediaPlayer mp1;
    MediaPlayer mp2;
    MediaPlayer mp3;
    MediaPlayer mp4;
    Context context;
    List<String> colaJ;
    reglaJuego iniJ;
    Button btn;

    int positionT = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_tmm);

        colaJ = new ArrayList<String>();
        Random rand = new Random();
        int n = rand.nextInt(4) + 1;
        String s = String.valueOf(n);
        colaJ.add(s);
        iniJ = new reglaJuego();
        iniJ.setColaJuego(colaJ);



        tv1 = (TextView) findViewById(tbNivel);
        tv1.setText(String.valueOf(iniJ.getColaJuego().size()));

        ima1 = (ImageButton) findViewById(R.id.img_blue);
        ima2 = (ImageButton) findViewById(R.id.img_green);
        ima3 = (ImageButton) findViewById(R.id.img_red);
        ima4 = (ImageButton) findViewById(R.id.img_yellow);


        mp1 = MediaPlayer.create(this, R.raw.azulsound);
        mp2 = MediaPlayer.create(this, R.raw.greensound);
        mp3 = MediaPlayer.create(this, R.raw.redsound);
        mp4 = MediaPlayer.create(this, R.raw.yellowsound);

        try {
            iniciaJuego(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ima1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    ima1.setBackgroundResource(R.mipmap.img_blue_light);

                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    ima1.setBackgroundResource(R.mipmap.img_blue);
                    iniJ.playSound(mp1);
                    recorridoC(positionT, 1);

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
                    recorridoC(positionT, 2);
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
                    recorridoC(positionT, 3);
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
                    recorridoC(positionT, 4);
                }
                return true;
            }

        });
    }

    public void iniciaJuego(int p) throws InterruptedException {

        final int[] loops = {0};
        int TotalReg = iniJ.getColaJuego().size();
        int TotalSeg = TotalReg * 1000;

        Semaf = (ImageView) findViewById(R.id.img_Sem);

        mp1 = MediaPlayer.create(this, R.raw.azulsound);
        mp2 = MediaPlayer.create(this, R.raw.greensound);
        mp3 = MediaPlayer.create(this, R.raw.redsound);
        mp4 = MediaPlayer.create(this, R.raw.yellowsound);


        for (int i = 0; i < iniJ.getColaJuego().size(); i++) {

            Timer();
            ima1 = (ImageButton) findViewById(R.id.img_blue);
            ima2 = (ImageButton) findViewById(R.id.img_green);
            ima3 = (ImageButton) findViewById(R.id.img_red);
            ima4 = (ImageButton) findViewById(R.id.img_yellow);

            if (iniJ.getColaJuego().get(i) == "1") {
                mp1.start();

                //R.layout.activity_juego_tmm.
                ima1.setBackgroundResource(R.mipmap.img_blue_light);
                ima2.setBackgroundResource(R.mipmap.img_green);
                ima3.setBackgroundResource(R.mipmap.img_red);
                ima4.setBackgroundResource(R.mipmap.img_yellow);


            } else if (iniJ.getColaJuego().get(i) == "2") {

                mp2.start();
                ima1.setBackgroundResource(R.mipmap.img_blue);
                ima2.setBackgroundResource(R.mipmap.img_green_light);
                ima3.setBackgroundResource(R.mipmap.img_red);
                ima4.setBackgroundResource(R.mipmap.img_yellow);


            } else if (iniJ.getColaJuego().get(i) == "3") {
                mp3.start();
                ima1.setBackgroundResource(R.mipmap.img_blue);
                ima2.setBackgroundResource(R.mipmap.img_green);
                ima3.setBackgroundResource(R.mipmap.img_red_light);
                ima4.setBackgroundResource(R.mipmap.img_yellow);


            } else if (iniJ.getColaJuego().get(i) == "4") {

                mp4.start();
                ima1.setBackgroundResource(R.mipmap.img_blue);
                ima2.setBackgroundResource(R.mipmap.img_green);
                ima3.setBackgroundResource(R.mipmap.img_red);
                ima4.setBackgroundResource(R.mipmap.img_yellow_light);


            }
        }
        Semaf.setBackgroundResource(R.mipmap.semverde);
    }

    private void Timer() {

        try {

            TimeUnit.SECONDS.sleep(1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void recorridoC(int position, int btn) {

        Semaf = (ImageView) findViewById(R.id.img_Sem);

        String Niveles = String.valueOf(iniJ.getColaJuego().size());
        //verifica si la posicion corresponte al boton presionado.
        if (iniJ.getColaJuego().get(position) == String.valueOf(btn)) {

            Semaf.setBackgroundResource(R.mipmap.semverde);


            //verifica la ultima posicion del arreglo.
            if (position == iniJ.getColaJuego().size() - 1) {

                Semaf.setBackgroundResource(R.mipmap.semrojo);

                Random rand = new Random();
                int n = rand.nextInt(4) + 1;
                String s = String.valueOf(n);
                iniJ.addColaJuego(s);
                tv1.setText(String.valueOf(iniJ.getColaJuego().size()));

                if(reglaJuego.majorLevel < iniJ.getColaJuego().size()) {

                    reglaJuego.majorLevel = iniJ.getColaJuego().size();
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                //builder.setCancelable(true);
                builder.setTitle("Felicidades!!!! nivel " + Niveles + ".");
                builder.setMessage("Presione OK para continuar al siguiente nivel.");


                builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.dismiss();

                                try {
                                    iniciaJuego(1);
                                    positionT = 0;
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener()

                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(JuegoTMM.this, MainActivity.class);
                        startActivity(intent);
                    }

                });

                AlertDialog dialog = builder.create();
                dialog.show();


            } else {

                positionT = positionT + 1;
            }


        } else

        {

            Toast toast = Toast.makeText(this, "A Perdido la Secuencia del Juego.", Toast.LENGTH_SHORT);
            toast.show();

            Intent intent = new Intent(JuegoTMM.this, MainActivity.class);
            startActivity(intent);

        }
    }
}




