package com.example.teluricapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import org.json.*;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static List<Sismo> Sismos;
    public static Context contextoMain;
    public static ListView ListaSismosView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.ListaSismosView = (ListView) findViewById(R.id.listSismos);
        contextoMain = this;
        new HttpGetRequest().execute();
    }
    public void Actualziar(View view) {
        new HttpGetRequest().execute();

    } //hola
}