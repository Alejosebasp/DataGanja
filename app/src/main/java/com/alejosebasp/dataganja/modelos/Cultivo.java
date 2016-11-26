package com.alejosebasp.dataganja.modelos;

import java.util.Date;

/**
 * Created by alejandrosebastian on 20/11/2016.
 */
public class Cultivo {

    private int Id_Cultivo, Id_Finca;
    private Double TamañoCultivo;
    private String Especie_Cultivada;
    private Date Fecha_Sembrado, Fecha_Recoleccion;

    public Cultivo(int id_Cultivo, int id_Finca, Double tamañoCultivo, String especie_Cultivada, Date fecha_Sembrado, Date fecha_Recoleccion) {
        Id_Cultivo = id_Cultivo;
        Id_Finca = id_Finca;
        TamañoCultivo = tamañoCultivo;
        Especie_Cultivada = especie_Cultivada;
        Fecha_Sembrado = fecha_Sembrado;
        Fecha_Recoleccion = fecha_Recoleccion;
    }

    public Cultivo(int id_Cultivo) {
        Id_Cultivo = id_Cultivo;
    }

    public int getId_Cultivo() {
        return Id_Cultivo;
    }

    public void setId_Cultivo(int id_Cultivo) {
        Id_Cultivo = id_Cultivo;
    }

    public int getId_Finca() {
        return Id_Finca;
    }

    public void setId_Finca(int id_Finca) {
        Id_Finca = id_Finca;
    }

    public Double getTamañoCultivo() {
        return TamañoCultivo;
    }

    public void setTamañoCultivo(Double tamañoCultivo) {
        TamañoCultivo = tamañoCultivo;
    }

    public String getEspecie_Cultivada() {
        return Especie_Cultivada;
    }

    public void setEspecie_Cultivada(String especie_Cultivada) {
        Especie_Cultivada = especie_Cultivada;
    }

    public Date getFecha_Sembrado() {
        return Fecha_Sembrado;
    }

    public void setFecha_Sembrado(Date fecha_Sembrado) {
        Fecha_Sembrado = fecha_Sembrado;
    }

    public Date getFecha_Recoleccion() {
        return Fecha_Recoleccion;
    }

    public void setFecha_Recoleccion(Date fecha_Recoleccion) {
        Fecha_Recoleccion = fecha_Recoleccion;
    }

    @Override
    public String toString() {
        return "Cultivo{" +
                "Id_Cultivo=" + Id_Cultivo +
                ", Id_Finca=" + Id_Finca +
                ", TamañoCultivo=" + TamañoCultivo +
                ", Especie_Cultivada='" + Especie_Cultivada + '\'' +
                ", Fecha_Sembrado=" + Fecha_Sembrado +
                ", Fecha_Recoleccion=" + Fecha_Recoleccion +
                '}';
    }
}
