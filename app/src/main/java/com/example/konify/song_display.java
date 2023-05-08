package com.example.konify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class song_display extends AppCompatActivity {

    ImageButton home , search, library ,back;
    CardView chedva,ekek,disudelo,kallzam,noshaa,ranni,soro,uzvadd;

    TextView artist_genre;
    ImageView genreartist;

    CardView curr_song;

    int song_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_display);

        home = findViewById(R.id.home4);
        search = findViewById(R.id.search4);
        library = findViewById(R.id.library4);
        back = findViewById(R.id.back3);

        chedva = findViewById(R.id.chedva);
        ekek = findViewById(R.id.ekekdis);
        disudelo = findViewById(R.id.disudelo);
        kallzam = findViewById(R.id.kallza);
        noshaa = findViewById(R.id.noshaa);
        ranni = findViewById(R.id.ranni);
        soro = findViewById(R.id.soro);
        uzvadd = findViewById(R.id.uzvadd);

        artist_genre =  findViewById(R.id.artist_genre);
        genreartist =  findViewById(R.id.genre_artist);

        curr_song = findViewById(R.id.curr_song4);


        Intent intent = getIntent();
        song_no = intent.getIntExtra("song_no",0);
        int ic = intent.getIntExtra("hold",0);

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
        curr_song.setOnClickListener((v) ->{

            Intent i = new Intent(getApplicationContext(),current_song.class);
            i.putExtra("song_no",song_no);
            startActivity(i);
        });


        switch(ic)
        {
            case 1:
                artist_genre.setText("Mark Revlon");
                genreartist.setImageResource(R.drawable.mark);
                chedva.setVisibility(View.GONE);
                ekek.setVisibility(View.GONE);
                kallzam.setVisibility(View.GONE);
                soro.setVisibility(View.GONE);
                break;

            case 2:
                artist_genre.setText("Carey Fernandes");
                genreartist.setImageResource(R.drawable.carey);
                uzvadd.setVisibility(View.GONE);
                ekek.setVisibility(View.GONE);
                noshaa.setVisibility(View.GONE);
                disudelo.setVisibility(View.GONE);
                break;

            case 3:
                artist_genre.setText("Knight n Day");
                genreartist.setImageResource(R.drawable.knight);
                chedva.setVisibility(View.GONE);
                noshaa.setVisibility(View.GONE);
                ranni.setVisibility(View.GONE);
                ekek.setVisibility(View.GONE);
                break;

            case 4:
                artist_genre.setText("Rock");
                genreartist.setImageResource(R.drawable.rock);
                chedva.setVisibility(View.GONE);
                ekek.setVisibility(View.GONE);
                break;

            case 5:
                artist_genre.setText("Romance");
                genreartist.setImageResource(R.drawable.rom);
                chedva.setVisibility(View.GONE);
                ekek.setVisibility(View.GONE);
                kallzam.setVisibility(View.GONE);
                break;

            case 6:
                artist_genre.setText("Pop");
                genreartist.setImageResource(R.drawable.pop);
                chedva.setVisibility(View.GONE);
                ekek.setVisibility(View.GONE);
                kallzam.setVisibility(View.GONE);
                soro.setVisibility(View.GONE);
                break;

            case 7:
                artist_genre.setText("Devotional");
                genreartist.setImageResource(R.drawable.devo);
                uzvadd.setVisibility(View.GONE);
                ekek.setVisibility(View.GONE);
                noshaa.setVisibility(View.GONE);
                disudelo.setVisibility(View.GONE);
                break;
        }
    }
}