package com.example.teluricapp;
import android.os.Handler;
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
    public Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.ListaSismosView = (ListView) findViewById(R.id.listSismos);
        contextoMain = this;
        new HttpGetRequest().execute();
        handler.postDelayed(actualizacionAutomatica, 1 * 60 * 1000);
    }

    private Runnable actualizacionAutomatica = new Runnable() {
        @Override
        public void run() {
            new HttpGetRequest().execute();
            handler.postDelayed(this, 1 * 60 * 1000);
        }
    };
    public void Actualizar(View view) {
        new HttpGetRequest().execute();
    }

}