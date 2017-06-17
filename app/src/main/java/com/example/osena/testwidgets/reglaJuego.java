package com.example.osena.testwidgets; /**
 * Created by osena on 6/2/2017.
 */


import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;


public class reglaJuego extends JuegoTMM{



    private static MediaPlayer mpMusic;
    private static ImageButton imageB;
    private static List<String> colaJuego;
    private ImageButton ima1;
    private ImageButton ima2;
    private ImageButton ima3;
    private ImageButton ima4;
    private MediaPlayer mp1;
    private MediaPlayer mp2;
    private  MediaPlayer mp3;
    private MediaPlayer mp4;
    private static final int majorLevel = 0;

    public final int getMajorLevel()
    {
        return majorLevel;

    }
    public final void getMajorLevel(int majorLevel)
    {

        this.majorLevel = majorLevel;

    }


    public List<String> getColaJuego()
    {
        return colaJuego;
    }
    public void setColaJuego(List<String> plist){

        this.colaJuego = plist;
    }

    public void addColaJuego(String a){

        this.colaJuego.add(a);
    }
    public MediaPlayer getMpMusic (){
        return mpMusic;
    }

    public void setMpMusic (MediaPlayer pMV){

        this.mpMusic = pMV;

    }

    public ImageButton getimageB(){
        return imageB;
    }

    public void setImageB (ImageButton pIm){

        this.imageB = pIm;
    }

    public reglaJuego(){


    }

    public reglaJuego(ArrayList<String> p){

            setColaJuego(p);
    }

    public reglaJuego(MediaPlayer name, ImageButton age){

        this.mpMusic = name;
        this.imageB = age;
    }


    public void playSound(MediaPlayer name)
    {
        name.start();
    }

}
