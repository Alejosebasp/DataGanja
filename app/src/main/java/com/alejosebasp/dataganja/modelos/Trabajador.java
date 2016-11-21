package com.alejosebasp.dataganja.modelos;

import java.util.Date;

/**
 * Created by alejandrosebastian on 20/11/2016.
 */
public class Trabajador {

    private int Id_Trabajador, Id_Finca, TRA_ID_Trabajador;
    private String Nombre_Trabajador, Apellido_Trabajador, Cargo_Trabajador, Nacionalidad;
    private Date Fecha_Nacimiento;

    public Trabajador(int id_Trabajador, int id_Finca, int TRA_ID_Trabajador,
                      String nombre_Trabajador, String apellido_Trabajador, String cargo_Trabajador,
                      String nacionalidad, Date fecha_Nacimiento) {
        Id_Trabajador = id_Trabajador;
        Id_Finca = id_Finca;
        this.TRA_ID_Trabajador = TRA_ID_Trabajador;
        Nombre_Trabajador = nombre_Trabajador;
        Apellido_Trabajador = apellido_Trabajador;
        Cargo_Trabajador = cargo_Trabajador;
        Nacionalidad = nacionalidad;
        Fecha_Nacimiento = fecha_Nacimiento;
    }

    public int getId_Trabajador() {
        return Id_Trabajador;
    }

    public void setId_Trabajador(int id_Trabajador) {
        Id_Trabajador = id_Trabajador;
    }

    public int getId_Finca() {
        return Id_Finca;
    }

    public void setId_Finca(int id_Finca) {
        Id_Finca = id_Finca;
    }

    public int getTRA_ID_Trabajador() {
        return TRA_ID_Trabajador;
    }

    public void setTRA_ID_Trabajador(int TRA_ID_Trabajador) {
        this.TRA_ID_Trabajador = TRA_ID_Trabajador;
    }

    public String getNombre_Trabajador() {
        return Nombre_Trabajador;
    }

    public void setNombre_Trabajador(String nombre_Trabajador) {
        Nombre_Trabajador = nombre_Trabajador;
    }

    public String getApellido_Trabajador() {
        return Apellido_Trabajador;
    }

    public void setApellido_Trabajador(String apellido_Trabajador) {
        Apellido_Trabajador = apellido_Trabajador;
    }

    public String getCargo_Trabajador() {
        return Cargo_Trabajador;
    }

    public void setCargo_Trabajador(String cargo_Trabajador) {
        Cargo_Trabajador = cargo_Trabajador;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        Nacionalidad = nacionalidad;
    }

    public Date getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(Date fecha_Nacimiento) {
        Fecha_Nacimiento = fecha_Nacimiento;
    }

    @Override
    public String toString() {
        return "Trabajador{" +
                "Id_Trabajador=" + Id_Trabajador +
                ", Id_Finca=" + Id_Finca +
                ", TRA_ID_Trabajador=" + TRA_ID_Trabajador +
                ", Nombre_Trabajador='" + Nombre_Trabajador + '\'' +
                ", Apellido_Trabajador='" + Apellido_Trabajador + '\'' +
                ", Cargo_Trabajador='" + Cargo_Trabajador + '\'' +
                ", Nacionalidad='" + Nacionalidad + '\'' +
                ", Fecha_Nacimiento=" + Fecha_Nacimiento +
                '}';
    }
}
