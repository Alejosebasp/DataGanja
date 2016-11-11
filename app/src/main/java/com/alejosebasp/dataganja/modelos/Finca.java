package com.alejosebasp.dataganja.modelos;

/**
 * Created by alejandrosebastian on 04/05/2016.
 */
public class Finca {

    private String nombre_propietario,nombre_finca;
    private double tamaño;
    private int numero_trabajadores, _id;
    private String ubicacion, tipoProduccion;

    public Finca(int _id ,String nombre_propietario, String nombre_finca, double tamaño,
                 int numero_trabajadores, String ubicacion, String tipoProduccion) {
        this._id = _id;
        this.nombre_propietario = nombre_propietario;
        this.nombre_finca = nombre_finca;
        this.tamaño = tamaño;
        this.numero_trabajadores = numero_trabajadores;
        this.ubicacion = ubicacion;
        this.tipoProduccion = tipoProduccion;
    }

    public String getTipoProduccion() {
        return tipoProduccion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getNumero_trabajadores() {
        return numero_trabajadores;
    }

    public double getTamaño() {
        return tamaño;
    }

    public String getNombre_finca() {
        return nombre_finca;
    }

    public String getNombre_propietario() {
        return nombre_propietario;
    }

    public int getId() {
        return _id;
    }
}
