package com.example.prototype2.music;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prototype2.R;

import java.io.IOException;

public class MusicActivity extends AppCompatActivity {


    private MediaPlayer mediaPlayer = null;
    private ImageButton playButton,pauseButton,stopButton,selectButton;
    private ImageView musicImg;
    private static final int SELECT_SONG_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        mediaPlayer = new MediaPlayer();
        playButton = (ImageButton) findViewById(R.id.play_button);
       pauseButton = (ImageButton) findViewById(R.id.pause_button);
       stopButton = (ImageButton) findViewById(R.id.stop_button);
        selectButton = (ImageButton) findViewById(R.id.select_button);
        musicImg = (ImageView) findViewById(R.id.img_music);

    pauseButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mediaPlayer.pause();
            musicImg.clearAnimation();

        }

    });
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                musicImg.clearAnimation();

            }
        });

        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectSong();
            }
        });
    }



    private void selectSong() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("audio/*");
        startActivityForResult(intent, SELECT_SONG_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        
        if (requestCode == SELECT_SONG_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Uri selectedSongUri = data.getData();
            

            if (selectedSongUri != null) {
                playButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                            mediaPlayer.start();
                            Animation rotate = AnimationUtils.loadAnimation(MusicActivity.this, R.anim.rotation);
                            musicImg.startAnimation(rotate);

                        }


                }
                );

                try {
                    mediaPlayer.reset();
                    mediaPlayer.setDataSource(this, selectedSongUri);
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    Toast.makeText(this, "Error playing song", Toast.LENGTH_SHORT).show();
                }
            }
            
        }
        

    }
    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }



}}