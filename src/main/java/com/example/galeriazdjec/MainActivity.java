package com.example.galeriazdjec;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayout glownyLayout;
    int wybraneIdZdjecia = 0;
    int idZdjecia = 0;
    Button poprzedniBut, nastepnyBut;
    EditText ktoryObrazEditText;
    Switch czyNiebieskieTlo;
    ImageView wyswietloneZdjecie;
    ArrayList<Galeria> zdjecia = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        poprzedniBut = findViewById(R.id.przyciskPoprzedni);
        nastepnyBut = findViewById(R.id.przyciskNastepny);
        ktoryObrazEditText = findViewById(R.id.editTextKtoryWyswietlic);
        czyNiebieskieTlo = findViewById(R.id.switchCzyNiebTlo);
        wyswietloneZdjecie = findViewById(R.id.imageView);
        glownyLayout = findViewById(R.id.mainLayout);

        zdjecia.add(new Galeria(R.drawable.piesek));
        zdjecia.add(new Galeria(R.drawable.piesek2));
        zdjecia.add(new Galeria(R.drawable.piesek3));
        zdjecia.add(new Galeria(R.drawable.piesek4));
        zdjecia.add(new Galeria(R.drawable.piesek5));

        // karuzela
        poprzedniBut.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        idZdjecia--;
                        if(idZdjecia < 0){
                            idZdjecia = zdjecia.size()-1;
                        }
                        wyswietloneZdjecie.setImageResource(zdjecia.get(idZdjecia).zwrocId());
                    }
                }
        );

        // karuzela
        nastepnyBut.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        idZdjecia++;
                        if(idZdjecia >= zdjecia.size()){
                            idZdjecia = 0;
                        }
                        wyswietloneZdjecie.setImageResource(zdjecia.get(idZdjecia).zwrocId());
                    }
                }
        );

        // zmiana zdjęcia na wybrany numer w editText
        ktoryObrazEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus){
                    String liczbaString = ktoryObrazEditText.getText().toString();

                    if(liczbaString.matches("\\d+")){
                        int wpisanaWartosc = Integer.parseInt(liczbaString);

                        if(wpisanaWartosc >= 1 && wpisanaWartosc <= zdjecia.size()){
                            wyswietloneZdjecie.setImageResource(zdjecia.get(wpisanaWartosc-1).zwrocId());
                            idZdjecia = wpisanaWartosc - 1;
                        }
                    }
                }
            }
        });

        czyNiebieskieTlo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(czyNiebieskieTlo.isChecked()){
                            glownyLayout.setBackgroundColor(Color.rgb(0,0,200));
                        }
                        else{
                            glownyLayout.setBackgroundColor(Color.rgb(0,121,107));
                        }
                    }
                }
        );
    }
}