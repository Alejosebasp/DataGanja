package com.alejosebasp.dataganja.modelos;

import java.util.Date;

/**
 * Created by alejandrosebastian on 20/11/2016.
 */
public class Producto_Agricola extends Cultivo {

    private int Id_Producto;

    public Producto_Agricola(int id_Cultivo) {
        super(id_Cultivo);
    }

    public Producto_Agricola(int id_Cultivo, int id_Producto) {
        super(id_Cultivo);
        Id_Producto = id_Producto;
    }

    public int getId_Producto() {
        return Id_Producto;
    }

    public void setId_Producto(int id_Producto) {
        Id_Producto = id_Producto;
    }

    @Override
    public String toString() {
        return "Producto_Agricola{" +
                "Id_Producto=" + Id_Producto +
                '}';
    }
}
