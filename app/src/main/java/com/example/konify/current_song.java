package com.example.konify;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
//import android.support.v4.widget.TintableImageSourceView;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class current_song extends AppCompatActivity {

    ImageView play, prev, next, imageView;
    //TextView songTitle;
    //SeekBar mSeekBarTime, mSeekBarVol;
    //static MediaPlayer mMediaPlayer;
    //private Runnable runnable;
    //private AudioManager mAudioManager;
    //ArrayList<String> arraylist;
    MediaPlayer playsong;

    int song_no ;

    ImageButton home , search, library , back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        play = findViewById(R.id.play);
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);


        home = findViewById(R.id.home5);
        search = findViewById(R.id.search5);
        library = findViewById(R.id.library5);

        back = findViewById(R.id.back5);

        Intent intent = getIntent();
        song_no = intent.getIntExtra("song_no",0);

        /*arraylist = new ArrayList<String>();
        Field[] fields = R.raw.class.getFields();

        for(int i = 0 ; i< fields.length;i++) {
            arraylist.add(fields[i].getName());
        }*/

        /*final ArrayList<Integer> songs = new ArrayList<>();

        songs.add(0, R.raw.chedva);
        songs.add(1, R.raw.dis_udelo);
        songs.add(2, R.raw.ek_ek_dis);
        songs.add(3, R.raw.kallzam_mogachim);
        songs.add(4, R.raw.noshaa);
        songs.add(5, R.raw.ranni_mhoji);
        songs.add(6, R.raw.soro);
        songs.add(7, R.raw.sorvbountim_uzvaad);

        playsong = MediaPlayer.create(getApplicationContext(), songs.get(song_no));*/

        int[] resId = { R.raw.chedva,R.raw.dis_udelo,R.raw.ek_ek_dis,R.raw.kallzam_mogachim,
                R.raw.noshaa,R.raw.ranni_mhoji,R.raw.soro,R.raw.sorvbountim_uzvaad};

        play.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if(playsong != null)
                       playsong.release();
                   else
                       song_no=0;

                   playsong = MediaPlayer.create(current_song.this,resId[song_no]);
                   //playsong = MediaPlayer.create(getApplicationContext(), songs.get(song_no));

                   playsong.start();
               }
        });

    }

    /*private void songNames() {
        if (song_no == 0) {
            songTitle.setText("Chedva");
        }
        if (song_no == 1) {
            songTitle.setText("Dis Udelo");
        }
        if (song_no == 2) {
            songTitle.setText("Ek Ek Dis");
        }
        if (song_no == 3) {
            songTitle.setText("Kallzam Mogachim");
        }
        if (song_no == 4) {
            songTitle.setText("Noshaa");
        }
        if (song_no == 5) {
            songTitle.setText("Ranni Mhoji");
        }
        if (song_no == 6) {
            songTitle.setText("Soro");
        }
        if (song_no == 7) {
            songTitle.setText("Sorvbountim Uzvadd");
        }

    }*/
}

       /* next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMediaPlayer != null) {
                    play.setImageResource(R.drawable.ic_baseline_pause_circle_outline_24);
                }

                if (currentIndex < songs.size() - 1) {
                    currentIndex++;
                } else {
                    currentIndex = 0;
                }

                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }

                mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));

                mMediaPlayer.start();
                songNames();

            }
        });


        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mMediaPlayer != null) {
                    play.setImageResource(R.drawable.ic_baseline_pause_circle_outline_24);
                }

                if (currentIndex > 0) {
                    currentIndex--;
                } else {
                    currentIndex = songs.size() - 1;
                }
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }

                mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));
                mMediaPlayer.start();
                songNames();

            }
        });*/


// seekbar duration
        /*mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mSeekBarTime.setMax(mMediaPlayer.getDuration());
                mMediaPlayer.start();
            }
        });

        mSeekBarTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mMediaPlayer.seekTo(progress);
                    mSeekBarTime.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mMediaPlayer != null) {
                    try {
                        if (mMediaPlayer.isPlaying()) {
                            Message message = new Message();
                            message.what = mMediaPlayer.getCurrentPosition();
                            handler.sendMessage(message);
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @SuppressLint("Handler Leak") Handler handler = new Handler () {
        @Override
        public void handleMessage  (Message msg) {
            mSeekBarTime.setProgress(msg.what);
        }
    };*/

        /*songs.add(0, R.raw.chedva);
        songs.add(1, R.raw.dis_udelo);
        songs.add(2, R.raw.ek_ek_dis);
        songs.add(3, R.raw.kallzam_mogachim);
        songs.add(4, R.raw.noshaa);
        songs.add(5, R.raw.ranni_mhoji);
        songs.add(6, R.raw.soro);
        songs.add(7, R.raw.sorvbountim_uzvaad);*/

        /*
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        home = findViewById(R.id.home5);
        search = findViewById(R.id.search5);
        library = findViewById(R.id.library5);

        back = findViewById(R.id.back5);

        // initializing views

        play = findViewById(R.id.play);
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);
        songTitle = findViewById(R.id.songTitle);
        imageView = findViewById(R.id.imageView);
        mSeekBarTime = findViewById(R.id.seekBarTime);
        mSeekBarVol = findViewById(R.id.seekBarVol);

        // creating an ArrayList to store our songs

        final ArrayList<Integer> songs = new ArrayList<>();

        songs.add(0, R.raw.chedva);
        songs.add(1, R.raw.dis_udelo);
        songs.add(2, R.raw.ek_ek_dis);
        songs.add(3, R.raw.kallzam_mogachim);
        songs.add(4, R.raw.noshaa);
        songs.add(5, R.raw.ranni_mhoji);
        songs.add(6, R.raw.soro);
        songs.add(7, R.raw.sorvbountim_uzvaad);


        // intializing mediaplayer

        mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));



        home.setOnClickListener((v) ->{
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        });
        search.setOnClickListener((v) ->{
            Intent i = new Intent(getApplicationContext(),search.class);
            startActivity(i);
        });
        library.setOnClickListener((v) ->{
            Intent i = new Intent(getApplicationContext(),library.class);
            startActivity(i);
        });
        back.setOnClickListener((v) ->{
            finish();
        });
        // seekbar volume

        int maxV = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curV = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        mSeekBarVol.setMax(maxV);
        mSeekBarVol.setProgress(curV);

        mSeekBarVol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        //above seekbar volume
        //

        /*play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSeekBarTime.setMax(mMediaPlayer.getDuration());
                if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
                    mMediaPlayer.pause();
                    play.setImageResource(R.drawable.ic_play_circle);
                } else {
                    mMediaPlayer.start();
                    play.setImageResource(R.drawable.ic_baseline_pause_circle_outline_24);
                }

                songNames();


        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMediaPlayer != null) {
                    play.setImageResource(R.drawable.ic_baseline_pause_circle_outline_24);
                }

                if (currentIndex < songs.size() - 1) {
                    currentIndex++;
                } else {
                    currentIndex = 0;
                }

                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }

                mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));

                mMediaPlayer.start();
                songNames();

            }
        });


        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mMediaPlayer != null) {
                    play.setImageResource(R.drawable.ic_baseline_pause_circle_outline_24);
                }

                if (currentIndex > 0) {
                    currentIndex--;
                } else {
                    currentIndex = songs.size() - 1;
                }
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }

                mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));
                mMediaPlayer.start();
                songNames();

            }
        });*/

