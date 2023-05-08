package com.example.konify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class search extends AppCompatActivity {

    ImageButton home , search, library ,back;
    TextView found ;
    EditText searchbar;
    CardView chedva,ekek,disudelo,kallzam,noshaa,ranni,soro,uzvadd;
    CardView curr_song;

    int song_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        home = findViewById(R.id.home2);
        search = findViewById(R.id.search2);
        library = findViewById(R.id.library2);
        back = findViewById(R.id.back);

        found = findViewById(R.id.empty);
        searchbar = findViewById(R.id.searchbar);

        chedva = findViewById(R.id.chedva);
        ekek = findViewById(R.id.ekekdis);
        disudelo = findViewById(R.id.disudelo);
        kallzam = findViewById(R.id.kallza);
        noshaa = findViewById(R.id.noshaa);
        ranni = findViewById(R.id.ranni);
        soro = findViewById(R.id.soro);
        uzvadd = findViewById(R.id.uzvadd);

        curr_song = findViewById(R.id.curr_song2);

        Intent intent = getIntent();
        song_no = intent.getIntExtra("song_no",0);

        home.setOnClickListener((v) ->{
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
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

        searchbar.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String s = searchbar.getText().toString();
                int count = 0;
                String str = "Chedva";
                if(str.toLowerCase().contains(s.toLowerCase()))
                {
                    chedva.setVisibility(View.VISIBLE);
                    count++;
                }
                else{
                    chedva.setVisibility(View.GONE);
                }
                str = "Ek Ek Dis";
                if(str.toLowerCase().contains(s.toLowerCase()))
                {
                    ekek.setVisibility(View.VISIBLE);
                    count++;
                }
                else{
                    ekek.setVisibility(View.GONE);
                }
                str = "Dis Udelo";
                if(str.toLowerCase().contains(s.toLowerCase()))
                {
                    disudelo.setVisibility(View.VISIBLE);
                    count++;
                }
                else{
                    disudelo.setVisibility(View.GONE);
                }
                str = "Kallzam Mogachim";
                if(str.toLowerCase().contains(s.toLowerCase()))
                {
                    kallzam.setVisibility(View.VISIBLE);
                    count++;
                }
                else{
                    kallzam.setVisibility(View.GONE);
                }
                str = "Noshaa";
                if(str.toLowerCase().contains(s.toLowerCase()))
                {
                    noshaa.setVisibility(View.VISIBLE);
                    count++;
                }
                else{
                    noshaa.setVisibility(View.GONE);
                }
                str = "Ranni Mhoji";
                if(str.toLowerCase().contains(s.toLowerCase()))
                {
                    ranni.setVisibility(View.VISIBLE);
                    count++;
                }
                else{
                    ranni.setVisibility(View.GONE);
                }
                str = "Soro";
                if(str.toLowerCase().contains(s.toLowerCase()))
                {
                    soro.setVisibility(View.VISIBLE);
                    count++;
                }
                else{
                    soro.setVisibility(View.GONE);
                }
                str = "Sorvbountim Uzvadd";
                if(str.toLowerCase().contains(s.toLowerCase()))
                {
                    uzvadd.setVisibility(View.VISIBLE);
                    count++;
                }
                else{
                    uzvadd.setVisibility(View.GONE);
                }
                if(count!=0)
                {
                    found.setVisibility(View.GONE);
                }
                else{
                    found.setVisibility(View.VISIBLE);
                }


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });
    }
}