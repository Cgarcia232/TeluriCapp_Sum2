package com.example.teluricapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class Adaptador extends BaseAdapter {
    private static LayoutInflater inflater = null;
    Context contexto;
    List <Sismo> Sismos;


    public Adaptador(Context contexto, List<Sismo> sismos) {
        this.contexto = contexto;
        Sismos = sismos;

        inflater = (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return Sismos.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View view  = inflater.inflate(R.layout.listado,null);
        TextView magnitud = (TextView) view.findViewById(R.id.label_magnitud);
        TextView ref_geografica = (TextView) view.findViewById(R.id.label_ref_geografica);
        TextView f_actualizacion = (TextView) view.findViewById(R.id.label_update);

        magnitud.setText(""+ Sismos.get(position).getMagnitud());
        ref_geografica.setText("" +Sismos.get(position).getRefGeografica());
        f_actualizacion.setText(""+Sismos.get(position).getFechaUpdate());
        return view;
    }
}
