package com.example.teluricapp;

import java.util.ArrayList;
import java.util.List;

import kotlin.contracts.Returns;

public class Sismo {
          private String Fecha;
          private double Profundidad;
          private double Magnitud;
          private String RefGeografica;
          private String FechaUpdate;

      public Sismo (String _Fecha, double _Profundidad, double _Magnitud, String _RefGeografica, String _FechaUpdate) {
            this.Fecha = _Fecha;
            this.Profundidad = _Profundidad;
            this.Magnitud = _Magnitud;
            this.RefGeografica = _RefGeografica;
            this.FechaUpdate = _FechaUpdate;
      }

    public String getFecha() {
        return Fecha;
    }

    public double getProfundidad() {
        return Profundidad;
    }

    public double getMagnitud() {
        return Magnitud;
    }

    public String getRefGeografica() {
        return RefGeografica;
    }

    public String getFechaUpdate() {
        return FechaUpdate;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public void setProfundidad(double profundidad) {
        Profundidad = profundidad;
    }

    public void setMagnitud(double magnitud) {
        Magnitud = magnitud;
    }

    public void setRefGeografica(String refGeografica) {
        RefGeografica = refGeografica;
    }

    public void setFechaUpdate(String fechaUpdate) {
        FechaUpdate = fechaUpdate;
    }

}
