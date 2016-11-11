package com.alejosebasp.dataganja.modelos;

/**
 * Created by alejandrosebastian on 22/05/2016.
 */
public class Herramienta {

    private String nombre_herramienta;
    private int id_herramienta, _idFinca;

    public Herramienta(int _idFinca, String nombre_herramienta, int id_herramienta) {
        this.nombre_herramienta = nombre_herramienta;
        this.id_herramienta = id_herramienta;
        this._idFinca = _idFinca;
    }

    public String getNombre_herramienta() {
        return nombre_herramienta;
    }

    public int getId_herramienta() {
        return id_herramienta;
    }

    public int getIdFinca(){
        return _idFinca;
    }
}
