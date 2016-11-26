package com.alejosebasp.dataganja.modelos;

import java.util.Date;

/**
 * Created by alejandrosebastian on 20/11/2016.
 */
public class Producto {

    private int Id_Producto, Id_Finca;
    private String Tipo_Producto, Descripcion_Producto;
    private Date Fecha_Produccion;

    public Producto(int id_Producto, int id_Finca, String tipo_Producto, String descripcion_Producto, Date fecha_Produccion) {
        Id_Producto = id_Producto;
        Id_Finca = id_Finca;
        Tipo_Producto = tipo_Producto;
        Descripcion_Producto = descripcion_Producto;
        Fecha_Produccion = fecha_Produccion;
    }

    public Producto(int id_Producto) {
        Id_Producto = id_Producto;
    }

    public int getId_Producto() {
        return Id_Producto;
    }

    public void setId_Producto(int id_Producto) {
        Id_Producto = id_Producto;
    }

    public int getId_Finca() {
        return Id_Finca;
    }

    public void setId_Finca(int id_Finca) {
        Id_Finca = id_Finca;
    }

    public String getTipo_Producto() {
        return Tipo_Producto;
    }

    public void setTipo_Producto(String tipo_Producto) {
        Tipo_Producto = tipo_Producto;
    }

    public String getDescripcion_Producto() {
        return Descripcion_Producto;
    }

    public void setDescripcion_Producto(String descripcion_Producto) {
        Descripcion_Producto = descripcion_Producto;
    }

    public Date getFecha_Produccion() {
        return Fecha_Produccion;
    }

    public void setFecha_Produccion(Date fecha_Produccion) {
        Fecha_Produccion = fecha_Produccion;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "Id_Producto=" + Id_Producto +
                ", Id_Finca=" + Id_Finca +
                ", Tipo_Producto='" + Tipo_Producto + '\'' +
                ", Descripcion_Producto='" + Descripcion_Producto + '\'' +
                ", Fecha_Produccion=" + Fecha_Produccion +
                '}';
    }
}
