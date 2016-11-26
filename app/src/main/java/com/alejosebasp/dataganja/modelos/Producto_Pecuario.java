package com.alejosebasp.dataganja.modelos;

/**
 * Created by alejandrosebastian on 20/11/2016.
 */
public class Producto_Pecuario extends Animal {

    private int Id_Producto;

    public Producto_Pecuario(int Id_Animal) {
        super(Id_Animal);
    }

    public Producto_Pecuario(int Id_Animal, int id_Producto) {
        super(Id_Animal);
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
        return "Producto_Pecuario{" +
                "Id_Producto=" + Id_Producto +
                '}';
    }
}
