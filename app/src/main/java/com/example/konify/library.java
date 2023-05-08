package com.example.konify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class library extends AppCompatActivity {

    ImageButton home , search, library ,back;
    CardView curr_song;

    int song_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        home = findViewById(R.id.home3);
        search = findViewById(R.id.search3);
        library = findViewById(R.id.library3);
        back = findViewById(R.id.back2);

        curr_song = findViewById(R.id.curr_song3);

        Intent intent = getIntent();
        song_no = intent.getIntExtra("song_no",0);

        home.setOnClickListener((v) ->{
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            i.putExtra("song_no",song_no);
            startActivity(i);
        });
        search.setOnClickListener((v) ->{
            Intent i = new Intent(getApplicationContext(),search.class);
            i.putExtra("song_no",song_no);
            startActivity(i);
        });
        back.setOnClickListener((v) ->{
            finish();
        });
        curr_song.setOnClickListener((v) ->{

            Intent i = new Intent(getApplicationContext(),current_song.class);
            i.putExtra("song_no",song_no);
            startActivity(i);
        });
    }
}