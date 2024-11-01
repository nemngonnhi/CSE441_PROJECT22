package com.example.launchscreen.HomeScreen.Activities;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.launchscreen.R;
import com.google.android.material.imageview.ShapeableImageView;

public class MusicPlayerActivity extends AppCompatActivity {

    //lay 2 tgian current voi duration
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
        }
    }

    MediaPlayer music;
    ImageButton btnpnp;
    ImageButton btnloop;
    TextView tvsongname;
    TextView tvartist;

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
        setContentView(R.layout.activity_music_player);
        if (music!= null){
            if (music.isPlaying()){
                music.stop();
            }
            music.release();
            music = null;
        }
        //lay ttin bai hat, ca si
        Intent intent = getIntent();
        String songName = intent.getStringExtra("songName");
        String artistName = intent.getStringExtra("songArtist");
        int songimage = intent.getIntExtra("songImage", -1);

        switch (songName.toString()) {
            case "Nụ cười":
                music = MediaPlayer.create(this, R.raw.nucuoi_rhymastic);
                break;
            case "Nến và hoa":
                music = MediaPlayer.create(this, R.raw.nenvahoa_rhymastic);
                break;
            case "Lạc trôi":
                music = MediaPlayer.create(this, R.raw.lactroi_sontung);
                break;
            case "Hoa ban trắng":
                music = MediaPlayer.create(this, R.raw.hoabantrang_buctuong);
                break;
            case "Đại lộ mặt trời":
                music = MediaPlayer.create(this, R.raw.dailomatroi_chillies);
                break;
            case "Vùng ký ức":
                music = MediaPlayer.create(this, R.raw.vungkyuc_chillies);
                break;
            case "Blank space":
                music = MediaPlayer.create(this, R.raw.blankspace_taylor);
                break;
            case "Look what you make me do":
                music = MediaPlayer.create(this, R.raw.lwymmd_taylor);
                break;
            case "Có chắc yêu là đây":
                music = MediaPlayer.create(this, R.raw.ccyld_sontung);
                break;

        }


        btnpnp = findViewById(R.id.btn_pnp);
        btnloop = findViewById(R.id.btn_loop);
        tvsongname = findViewById(R.id.tv_songname);
        tvartist = findViewById(R.id.tv_artist);
        img = findViewById(R.id.songimg);

        //settext cho ten bai hat va ca si

        tvsongname.setText(songName);
        tvartist.setText(artistName);
        if (songimage != -1) {
            img.setImageResource(songimage);
        }

        //lay thoi gian bai hat
        currentTime = findViewById(R.id.tv_currentTime);
        duration = findViewById(R.id.tv_duration);
        long fullDuration = music.getDuration();
        duration.setText(msToTimer(fullDuration));

        seekBar = findViewById(R.id.seekBar);
        seekBar.setProgress(0);
        seekBar.setMax(music.getDuration());

//dia hat quay quay
        ObjectAnimator animator = ObjectAnimator.ofFloat(img, "rotation", 0f, 360f);
        animator.setDuration(8000);
        animator.setRepeatCount(ObjectAnimator.INFINITE);


//ngay khi an vao activity
        music.start();
        RunningSeekBar runningSeekBar = new RunningSeekBar();
        handler.post(runningSeekBar);
        animator.setInterpolator(new LinearInterpolator());
        btnpnp.setImageResource(R.drawable.baseline_pause_24);
        animator.start();
//play and pause
        btnpnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (music.isPlaying()) {
                    music.pause();
                    btnpnp.setImageResource(R.drawable.baseline_play_arrow_24);
                    animator.pause();
                    //clickStartService();

                    //stopService(new Intent(MainActivity.this, MyService.class));
                } else {
                    music.start();
                    btnpnp.setImageResource(R.drawable.baseline_pause_24);
                    animator.resume();
                    //clickStopService();

                    //startService(new Intent(MainActivity.this, MyService.class));
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
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (music != null) {
            music.release();
            music = null;
        }
    }
// dinh lam forgegroundservice
//    private void clickStartService(){
//
//        Intent intent = new Intent(this, MyService.class);
//        intent.putExtra("data_intent", tvsongname.getText().toString().trim());
//        startService(intent);
//    }
//    private void clickStopService(){
//        Intent intent = new Intent(this, MyService.class);
//        stopService(intent);
//    }

}