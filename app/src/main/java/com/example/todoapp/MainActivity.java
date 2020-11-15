package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class MainActivity extends AppCompatActivity {

    public static List<Task> zadania = new ArrayList<>();
    private final int [] ids = {R.id.task0,R.id.task1,R.id.task2,R.id.task3,R.id.task4,R.id.task5,R.id.task6,R.id.task7,R.id.task8,R.id.task9,R.id.task10};


    public void addTask(View view){
        Intent intent = new Intent(this, AddTask.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Tutaj jest wyświetlana lista utworzonych zadań - o ile takie są
        for(int i = 0; i < zadania.size(); i++) {
            TextView textView = (TextView) findViewById(ids[i]);
            textView.setText(zadania.get(i).getTytulZadania());
            textView.setTextSize(15);
        }
    }

    @SuppressLint("ResourceType")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //Po utworzeniu zadania pozyskiwane są dane z AddTask activity
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String tytulZadania = data.getStringExtra("tytulZadania");
                String trescZadania = data.getStringExtra("trescZadania");
                String dataZadania = data.getStringExtra("dataZadania");


                    //utworzenie nowego obiektu Task i dodanie go do listy z zadaniami
                    Task newTask = new Task(tytulZadania, dataZadania, trescZadania);
                    try {
                        addToList(newTask);

                        for(int i = 0; i < zadania.size(); i++){
                            //Dodanie do głownego ekranu elementów listy
                            TextView textView = (TextView) findViewById(ids[i]);
                            textView.setText(zadania.get(i).getTytulZadania());
                            textView.setTextSize(15);
                            int finalI = i;
                            //Dodanie możliwości otworzenia zadania i zobaczenia szczegółów
                            textView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    showTask(zadania.get(finalI));
                                }
                            });

                        }

                    } catch (ParseException e) {
                        e.printStackTrace();}
            }
            if (resultCode == Activity.RESULT_CANCELED) {
            }
        }
    }

    //utworzenie funckji dodawania zadan do listy
    public void addToList(Task task) throws ParseException {
        zadania.add(task);

    }

    //funkcja przekazująca dane do wyświetlenia szczegółów zadania
    public void showTask(Task task){
        Intent intent = new Intent(this, ShowTask.class);
        intent.putExtra("tytulZadania", task.getTytulZadania());
        intent.putExtra("dataZadania", task.getDataZadania());
        intent.putExtra("trescZadania", task.getTrescZadania());
        startActivity(intent);
    }




}
