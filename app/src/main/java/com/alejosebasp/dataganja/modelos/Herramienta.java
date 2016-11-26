package com.alejosebasp.dataganja.modelos;

import java.util.Date;

/**
 * Created by alejandrosebastian on 22/05/2016.
 */
public class Herramienta {

    private String Nombre_Herramienta, Tipo_Herramienta;
    private Date Fecha_Adquisicion;
    private int Id_Herramienta, Id_Finca;

    public Herramienta(String Nombre_Herramienta, String tipo_Herramienta, Date fecha_Adquisicion, int id_Herramienta, int id_Finca) {
        this.Nombre_Herramienta = Nombre_Herramienta;
        Tipo_Herramienta = tipo_Herramienta;
        Fecha_Adquisicion = fecha_Adquisicion;
        Id_Herramienta = id_Herramienta;
        Id_Finca = id_Finca;
    }

    public Herramienta(int id_Herramienta, int id_Finca) {
        Id_Herramienta = id_Herramienta;
        Id_Finca = id_Finca;
    }

    public String getNombre_Herramienta() {
        return Nombre_Herramienta;
    }

    public void setNombre_Herramienta(String nombre_Herramienta) {
        this.Nombre_Herramienta = nombre_Herramienta;
    }

    public String getTipo_Herramienta() {
        return Tipo_Herramienta;
    }

    public void setTipo_Herramienta(String tipo_Herramienta) {
        Tipo_Herramienta = tipo_Herramienta;
    }

    public Date getFecha_Adquisicion() {
        return Fecha_Adquisicion;
    }

    public void setFecha_Adquisicion(Date fecha_Adquisicion) {
        Fecha_Adquisicion = fecha_Adquisicion;
    }

    public int getId_Herramienta() {
        return Id_Herramienta;
    }

    public void setId_Herramienta(int id_Herramienta) {
        Id_Herramienta = id_Herramienta;
    }

    public int getId_Finca() {
        return Id_Finca;
    }

    public void setId_Finca(int id_Finca) {
        Id_Finca = id_Finca;
    }

    @Override
    public String toString() {
        return "Herramienta{" +
                "Nombre_Herramienta='" + Nombre_Herramienta + '\'' +
                ", Tipo_Herramienta='" + Tipo_Herramienta + '\'' +
                ", Fecha_Adquisicion=" + Fecha_Adquisicion +
                ", Id_Herramienta=" + Id_Herramienta +
                ", Id_Finca=" + Id_Finca +
                '}';
    }
}
