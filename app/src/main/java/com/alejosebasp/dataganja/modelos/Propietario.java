package com.alejosebasp.dataganja.modelos;

/**
 * Created by alejandrosebastian on 20/11/2016.
 */
public class Propietario {

    private int Cedula, Id_Finca;
    private String Nombre_Propietario, Apellido_Propietario;

    public Propietario(int cedula, int id_Finca, String nombre_Propietario, String apellido_Propietario) {
        Cedula = cedula;
        Id_Finca = id_Finca;
        Nombre_Propietario = nombre_Propietario;
        Apellido_Propietario = apellido_Propietario;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int cedula) {
        Cedula = cedula;
    }

    public int getId_Finca() {
        return Id_Finca;
    }

    public void setId_Finca(int id_Finca) {
        Id_Finca = id_Finca;
    }

    public String getNombre_Propietario() {
        return Nombre_Propietario;
    }

    public void setNombre_Propietario(String nombre_Propietario) {
        Nombre_Propietario = nombre_Propietario;
    }

    public String getApellido_Propietario() {
        return Apellido_Propietario;
    }

    public void setApellido_Propietario(String apellido_Propietario) {
        Apellido_Propietario = apellido_Propietario;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "Cedula=" + Cedula +
                ", Id_Finca=" + Id_Finca +
                ", Nombre_Propietario='" + Nombre_Propietario + '\'' +
                ", Apellido_Propietario='" + Apellido_Propietario + '\'' +
                '}';
    }
}
