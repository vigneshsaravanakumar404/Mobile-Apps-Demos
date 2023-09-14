package com.example.audiotask;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Message;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button play_pause, stop, restart;
    MediaPlayer mediaPlayer;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play_pause = findViewById(R.id.play_pause);
        restart = findViewById(R.id.restart);
        seekBar = findViewById(R.id.seekBar);
        mediaPlayer = MediaPlayer.create(this, R.raw.heeheehaw);
        stop = findViewById(R.id.stop);

        mediaPlayer.setOnCompletionListener(mp -> {
            seekBar.setProgress(0);
            mediaPlayer.start();
            mediaPlayer.pause();
        });

        play_pause.setOnClickListener(v -> {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            } else {
                mediaPlayer.start();
            }
        });
        stop.setOnClickListener(v -> {
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.heeheehaw);
        });
        stop.setBackgroundColor(Color.RED);
        restart.setOnClickListener(v -> {
            mediaPlayer.seekTo(0);
            mediaPlayer.start();
        });

        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                mediaPlayer.pause();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.start();
            }
        });
        new Thread(() -> {
            while (mediaPlayer != null) {
                try {
                    Message msg = new Message();
                    msg.what = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((msg.what));
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}