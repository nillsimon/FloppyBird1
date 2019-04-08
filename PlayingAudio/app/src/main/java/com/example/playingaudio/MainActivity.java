package com.example.playingaudio;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    ImageView playPauseIcon;
    SeekBar seekBar;
    Button button;
    SeekBar volumeSeekBar;
    AudioManager audioManager;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playPauseIcon = findViewById(R.id.playIconImageView);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.stuff);

        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(mediaPlayer.getDuration());

        new Timer().scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0,1000);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaPlayer.seekTo(progress);
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
        public void previous(View view) {
            seekBar.setProgress(0);
            mediaPlayer.seekTo(0);
            mediaPlayer.pause();
            playPauseIcon.setImageResource(R.drawable.ic_play_arrow_orang_24dp);
        }

        public void next(View view) {
            seekBar.setProgress(mediaPlayer.getDuration());
            mediaPlayer.seekTo(mediaPlayer.getDuration());
            mediaPlayer.pause();
            playPauseIcon.setImageResource(R.drawable.ic_play_arrow_orang_24dp);

        }

        public void play(View view) {
        if(mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            playPauseIcon.setImageResource(R.drawable.ic_play_arrow_orang_24dp);
        }else {
            mediaPlayer.start();
            playPauseIcon.setImageResource(R.drawable.ic_pause_orang_24dp);
        }
        }
    }

   /*     audioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        volumeSeekBar = findViewById(R.id.seekBar);
        volumeSeekBar.setMax(maxVolume);
        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("Progress change", "" + progress);
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });/*
       // button = findViewById(R.id.playButton);
      //  button.setOnClickListener(new View.OnClickListener() {
           // @Override
      //      public void onClick(View view) {
      //          if(mediaPlayer.isPlaying()){
            //        pause();
         //       }else {
        //            play();
       //         }
            }
      //  });
       //  mediaPlayer = MediaPlayer.create(this, R.raw.stuff);
//}
public void play(){
    mediaPlayer.start();
    button.setText("Pause");

}
public void pause(){
        mediaPlayer.pause();
        button.setText("Start");
}

    public void previous(View view) {
    }

    public void next(View view) {
    }

    public void play(View view) {
    */

