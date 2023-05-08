package com.example.konify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {


    ImageButton home , search, library;
    CardView mark,carey,knight,rock,rom,pop,devo;
    CardView curr_song;

    DbAdapter helper;

    int song_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home = findViewById(R.id.home1);
        search = findViewById(R.id.search1);
        library = findViewById(R.id.library1);

        mark = findViewById(R.id.mark_rev);
        carey = findViewById(R.id.carey_fen);
        knight = findViewById(R.id.kni_day);
        rock = findViewById(R.id.rock);
        rom = findViewById(R.id.romrom);
        pop = findViewById(R.id.pop);
        devo = findViewById(R.id.devo);

        curr_song = findViewById(R.id.curr_song);

        song_no=-1;

        //helper = new DbAdapter(this);
        //long a = helper.insertsong();
        //if(a<=0)
        //    Message.message(getApplicationContext(),"Insertion successfull");
        //else
        //    Message.message(getApplicationContext(),"Insertion unsuccessfull");

        search.setOnClickListener((v) ->{
            Intent i = new Intent(getApplicationContext(),search.class);
            i.putExtra("song_no",song_no);
            startActivity(i);
        });
        library.setOnClickListener((v) ->{
            Intent i = new Intent(getApplicationContext(),library.class);
            i.putExtra("song_no",song_no);
            startActivity(i);
        });

        mark.setOnClickListener((v) ->{
            Intent i = new Intent(getApplicationContext(),song_display.class);
            i.putExtra("song_no",song_no);
            i.putExtra("hold",1);
            startActivity(i);
        });
        carey.setOnClickListener((v) ->{

            Intent i = new Intent(getApplicationContext(),song_display.class);
            i.putExtra("song_no",song_no);
            i.putExtra("hold",2);
            startActivity(i);
        });
        knight.setOnClickListener((v) ->{

            Intent i = new Intent(getApplicationContext(),song_display.class);
            i.putExtra("song_no",song_no);
            i.putExtra("hold",3);
            startActivity(i);
        });
        rock.setOnClickListener((v) ->{
            Intent i = new Intent(getApplicationContext(),song_display.class);
            i.putExtra("song_no",song_no);
            i.putExtra("hold",4);
            startActivity(i);
        });
        rom.setOnClickListener((v) ->{

            Intent i = new Intent(getApplicationContext(),song_display.class);
            i.putExtra("song_no",song_no);
            i.putExtra("hold",5);
            startActivity(i);
        });
        pop.setOnClickListener((v) ->{

            Intent i = new Intent(getApplicationContext(),song_display.class);
            i.putExtra("song_no",song_no);
            i.putExtra("hold",6);
            startActivity(i);
        });
        devo.setOnClickListener((v) ->{

            Intent i = new Intent(getApplicationContext(),song_display.class);
            i.putExtra("song_no",song_no);
            i.putExtra("hold",7);
            startActivity(i);
        });

        curr_song.setOnClickListener((v) ->{

            Intent i = new Intent(getApplicationContext(),current_song.class);
            i.putExtra("song_no",song_no);
            startActivity(i);
        });

    }


}