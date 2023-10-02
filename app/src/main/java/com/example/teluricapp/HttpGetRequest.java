package com.example.teluricapp;
import static com.example.teluricapp.MainActivity.*;
import android.os.AsyncTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HttpGetRequest extends AsyncTask<Void, Void, String> {
    @Override
    protected String doInBackground(Void... Voids) {
        String apiURL = "https://api.gael.cloud/general/public/sismos";
        try {
            //conexion
            URL url = new URL(apiURL);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            //leer respuesta del servidor
            InputStream inputstream = conexion.getInputStream();
            BufferedReader reader = new BufferedReader((new InputStreamReader(inputstream)));
            StringBuilder result = new StringBuilder();
            String linea;
            while ((linea = reader.readLine()) != null){
                result.append(linea);
            }

            //cerrar conexiones
            reader.close();
            inputstream.close();
            conexion.disconnect();

            return result.toString();
        }catch (IOException e) {
            e.printStackTrace();
            return "Error de solicitud " + e.getMessage();
        }
    }

    @Override
    protected  void onPostExecute (String result) {
        super.onPostExecute(result);

        List<Sismo> resultado = new ArrayList<>();
        new HttpGetRequest().execute();

        try {
            JSONArray jsonArray = new JSONArray(result);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject objetoSismo = jsonArray.getJSONObject(i);
                Sismo sismo = new Sismo(
                        objetoSismo.getString("Fecha"),
                        objetoSismo.getDouble("Profundidad"),
                        objetoSismo.getDouble("Magnitud"),
                        objetoSismo.getString("RefGeografica"),
                        objetoSismo.getString("FechaUpdate")
                );
                resultado.add(sismo);
            }
            ListaSismosView.setAdapter(new Adaptador(contextoMain, resultado));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
