package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_task);

        //pobieranie danych przekazanych z MainActivity
        Intent intent = getIntent();
        String tytulZadania = intent.getStringExtra("tytulZadania");
        String trescZadania = intent.getStringExtra("trescZadania");
        String dataZadania = intent.getStringExtra("dataZadania");

        //pobranie elementów layout'u i przypisanie ich do zmiennych
        TextView showTytulZadania = (TextView) findViewById(R.id.showTytulZadania);
        TextView showDataZadania = (TextView) findViewById(R.id.showDataZadania);
        TextView showTrescZadania = (TextView) findViewById(R.id.showTrescZadania);

        //wyświetlenie danych
        showTytulZadania.setText("Zadanie: "+tytulZadania);
        showDataZadania.setText("Data zadania: "+dataZadania);
        showTrescZadania.setText("Treść zadania: "+trescZadania);


    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // do something on back.
        finish();
    }
}