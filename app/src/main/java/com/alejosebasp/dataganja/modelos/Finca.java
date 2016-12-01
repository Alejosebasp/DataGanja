package com.alejosebasp.dataganja.modelos;

/**
 * Created by alejandrosebastian on 04/05/2016.
 */
public class Finca {

    private Double saldo;
    private String nombre_finca;
    private double tamaño;
    private int _id;
    private String ubicacion, tipoProduccion;

    public Finca(int _id, double tamaño, String nombre_finca,
                  String ubicacion, String tipoProduccion, Double SaldoFinca) {
        this._id = _id;
        this.nombre_finca = nombre_finca;
        this.tamaño = tamaño;
        this.saldo = SaldoFinca;
        this.ubicacion = ubicacion;
        this.tipoProduccion = tipoProduccion;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getNombre_finca() {
        return nombre_finca;
    }

    public void setNombre_finca(String nombre_finca) {
        this.nombre_finca = nombre_finca;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipoProduccion() {
        return tipoProduccion;
    }

    public void setTipoProduccion(String tipoProduccion) {
        this.tipoProduccion = tipoProduccion;
    }

    @Override
    public String toString() {
        return "Finca{" +
                "saldo=" + saldo +
                ", nombre_finca='" + nombre_finca + '\'' +
                ", tamaño=" + tamaño +
                ", _id=" + _id +
                ", ubicacion='" + ubicacion + '\'' +
                ", tipoProduccion='" + tipoProduccion + '\'' +
                '}';
    }
}
