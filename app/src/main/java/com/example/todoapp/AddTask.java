package com.example.todoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class AddTask extends AppCompatActivity {

    DatePicker picker;
    TextView tvdataZadania;
    EditText etTytulZadania, etTrescZadania;
    Button dodajZadanie;

    //metoda pobierająca datę z DatePicker'a jako Date
    public static java.util.Date getDataZadania(DatePicker picker){
        int dzien = picker.getDayOfMonth();
        int miesiac = picker.getMonth()+1;
        int rok = picker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(rok, miesiac, dzien);

        return calendar.getTime();
    }

    //metoda pobierająca datę z DatePicker'a jako String
    public static String getDataZadaniaString(DatePicker picker){
        int dzien = picker.getDayOfMonth();
        int miesiac = picker.getMonth()+1;
        int rok = picker.getYear();

        String dataZadaniaString = (dzien+"."+miesiac+"."+rok);

        return dataZadaniaString;
    }

    //metoda zbierająca i zapisująca wszystkie dane wypełnione przy dodawaniu nowego zadania
    public void save(View view) throws ParseException {
        String tytulZadania = ((TextView) findViewById(R.id.tytulZadania)).getText().toString();
        String trescZadania = ((TextView) findViewById(R.id.trescZadania)).getText().toString().replace('<', ' ');
        if (tytulZadania.equals("") || trescZadania.equals(""))
            Toast.makeText(getApplicationContext(), "Tytuł i treść zadania nie mogą pyć puste!", Toast.LENGTH_SHORT).show();
        else {
            //przekazanie danych do MainActivity
            String d = getDataZadaniaString(picker);
                Intent returnIntent = new Intent();
                returnIntent.putExtra("tytulZadania", tytulZadania);
                returnIntent.putExtra("trescZadania", trescZadania);
                returnIntent.putExtra("dataZadania", d);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtask);

        etTytulZadania = (EditText) findViewById(R.id.tytulZadania);
        etTrescZadania = (EditText) findViewById(R.id.trescZadania);
        tvdataZadania = (TextView) findViewById(R.id.textView);
        picker = (DatePicker) findViewById(R.id.dataZadania);
        dodajZadanie = (Button) findViewById(R.id.dodajZadanie);
    }
}

