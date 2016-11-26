package com.alejosebasp.dataganja.modelos;

/**
 * Created by alejandrosebastian on 22/05/2016.
 */
public class Insumo {

    private String Nombre_Insumo, Tipo_Insumo;
    private String Magnitud_Insumo, Unidad_Medida_Insumo, Descripcion_Insumo;
    private int Id_Insumo, Id_Finca;

    public Insumo(String nombre_Insumo, String tipo_Insumo, String magnitud_Insumo,
                  String unidad_Medida_Insumo, String descripcion_Insumo, int id_Insumo, int id_Finca) {
        Nombre_Insumo = nombre_Insumo;
        Tipo_Insumo = tipo_Insumo;
        Magnitud_Insumo = magnitud_Insumo;
        Unidad_Medida_Insumo = unidad_Medida_Insumo;
        Descripcion_Insumo = descripcion_Insumo;
        Id_Insumo = id_Insumo;
        Id_Finca = id_Finca;
    }

    public String getNombre_Insumo() {
        return Nombre_Insumo;
    }

    public void setNombre_Insumo(String nombre_Insumo) {
        Nombre_Insumo = nombre_Insumo;
    }

    public String getTipo_Insumo() {
        return Tipo_Insumo;
    }

    public void setTipo_Insumo(String tipo_Insumo) {
        Tipo_Insumo = tipo_Insumo;
    }

    public String getMagnitud_Insumo() {
        return Magnitud_Insumo;
    }

    public void setMagnitud_Insumo(String magnitud_Insumo) {
        Magnitud_Insumo = magnitud_Insumo;
    }

    public String getUnidad_Medida_Insumo() {
        return Unidad_Medida_Insumo;
    }

    public void setUnidad_Medida_Insumo(String unidad_Medida_Insumo) {
        Unidad_Medida_Insumo = unidad_Medida_Insumo;
    }

    public String getDescripcion_Insumo() {
        return Descripcion_Insumo;
    }

    public void setDescripcion_Insumo(String descripcion_Insumo) {
        Descripcion_Insumo = descripcion_Insumo;
    }

    public int getId_Insumo() {
        return Id_Insumo;
    }

    public void setId_Insumo(int id_Insumo) {
        Id_Insumo = id_Insumo;
    }

    public int getId_Finca() {
        return Id_Finca;
    }

    public void setId_Finca(int id_Finca) {
        Id_Finca = id_Finca;
    }

    @Override
    public String toString() {
        return "Insumo{" +
                "Nombre_Insumo='" + Nombre_Insumo + '\'' +
                ", Tipo_Insumo='" + Tipo_Insumo + '\'' +
                ", Magnitud_Insumo='" + Magnitud_Insumo + '\'' +
                ", Unidad_Medida_Insumo='" + Unidad_Medida_Insumo + '\'' +
                ", Descripcion_Insumo='" + Descripcion_Insumo + '\'' +
                ", Id_Insumo=" + Id_Insumo +
                ", Id_Finca=" + Id_Finca +
                '}';
    }
}
