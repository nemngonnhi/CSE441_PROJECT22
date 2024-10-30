package com.example.myapplication;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.Timer;
import java.util.TimerTask;



public class MainActivity extends AppCompatActivity {


    //doan nay la de lay 2 tgian current voi duration
    public String msToTimer(long ms){
        String timerString = "";
        String secondString;

        int hour = (int)(ms / (1000*60*60));
        int minute = (int)(ms % (1000*60*60)) / (1000*60);
        int second = (int)(ms % (1000*60*60)) % (1000*60) / 1000;

        if (hour >0){
            timerString = hour + ":";
        }
        if(second<10){
            secondString = "0" + second;
        }
        else {
            secondString = "" + second;
        }
        timerString = timerString + minute + ":" + secondString;
        return timerString;

    };
    //seekbar chay chay
    public class RunningSeekBar implements Runnable{
        @Override
        public void run() {
            seekBar.setProgress(music.getCurrentPosition());

            handler.postDelayed(this, 1000);

            long currentDuration = music.getCurrentPosition();
            currentTime.setText(msToTimer(currentDuration));
            long fullDuration = music.getDuration();
            duration.setText(msToTimer(fullDuration));
        }
    }

    MediaPlayer music;
    ImageButton btnpnp;
    ImageButton btnloop;
    TextView tvsongname;

    ShapeableImageView img;
    //seekbar
    SeekBar seekBar;
    TextView currentTime;
    TextView duration;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        music = MediaPlayer.create(this, R.raw.sound);
        btnpnp = findViewById(R.id.btn_pnp);
        btnloop = findViewById(R.id.btn_loop);
        tvsongname = findViewById(R.id.tv_songname);
        img = findViewById(R.id.songimg);

        currentTime = findViewById(R.id.tv_currentTime);
        duration = findViewById(R.id.tv_duration);

        seekBar = findViewById(R.id.seekBar);
        seekBar.setProgress(0);
        seekBar.setMax(music.getDuration());

        ObjectAnimator animator = ObjectAnimator.ofFloat(img, "rotation", 0f, 360f);
        animator.setDuration(8000);
        animator.setRepeatCount(ObjectAnimator.INFINITE);

        //play and pause
        btnpnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RunningSeekBar runningSeekBar = new RunningSeekBar();
                handler.post(runningSeekBar);

                animator.setInterpolator(new LinearInterpolator());

                if (music.isPlaying()) {
                    music.pause();
                    btnpnp.setImageResource(R.drawable.baseline_play_arrow_24);
                    animator.cancel();
                    //clickStartService();
                } else {
                    music.start();
                    btnpnp.setImageResource(R.drawable.baseline_pause_24);
                    animator.start();
                    //clickStopService();
                }
            }


        });

        //seekbar change

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int pos, boolean changed) {
                if (changed) {
                    music.seekTo(pos);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void clickStartService(){

        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("data_intent", tvsongname.getText().toString().trim());
        startService(intent);
    }
    private void clickStopService(){
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }
}