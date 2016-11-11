package com.alejosebasp.dataganja.modelos;

/**
 * Created by alejandrosebastian on 22/05/2016.
 */
public class Otro {

    private String nombre;
    private String descripcion;
    private int id_otro, idFinca;

    public Otro(int idFinca, String nombre, String descripcion, int id_otro) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id_otro = id_otro;
        this.idFinca = idFinca;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getId_otro() {
        return id_otro;
    }

    public int getIdFinca() {
        return idFinca;
    }
}
