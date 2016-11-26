package com.alejosebasp.dataganja.modelos;

/**
 * Created by alejandrosebastian on 21/11/2016.
 */
public class Agricultor extends Cultivo {

    private int Id_Trabajador;

    public Agricultor(int id_Cultivo) {
        super(id_Cultivo);
    }

    public Agricultor(int id_Cultivo, int id_Trabajador) {
        super(id_Cultivo);
        Id_Trabajador = id_Trabajador;
    }

    public int getId_Trabajador() {
        return Id_Trabajador;
    }

    public void setId_Trabajador(int id_Trabajador) {
        Id_Trabajador = id_Trabajador;
    }

    @Override
    public String toString() {
        return "Agricultor{" +
                "Id_Trabajador=" + Id_Trabajador +
                '}';
    }
}
