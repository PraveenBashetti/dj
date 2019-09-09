package com.example.dj;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener {
    MediaPlayer mediaPlayer,mediaPlayer1;
    Random random=new Random();
    SoundPool soundPool;
    int dhamaka=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        View view=new View(this);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        view.setOnTouchListener(this);
        setContentView(view);
        soundPool=new SoundPool(5,AudioManager.STREAM_MUSIC,0);
        dhamaka = soundPool.load(this,R.raw.explosion,1);
        mediaPlayer=MediaPlayer.create(this,R.raw.kaam);
        mediaPlayer1=MediaPlayer.create(this,R.raw.soundtrack);
        view.setBackgroundColor(Color.rgb(random.nextInt(268),random.nextInt(265),random.nextInt(666)));

    }

    @Override
    public void onClick(View v) {


        mediaPlayer.start();

    }

    @Override
    public boolean onLongClick(View v) {
        mediaPlayer1.start();
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(dhamaka!=0) {
            soundPool.play(dhamaka, 1, 1, 0, 0, 1);

        }
        return false;
    }

    @Override
    protected void onPause() {
        mediaPlayer.release();
        mediaPlayer1.release();
        super.onPause();
    }
}
