package com.alejosebasp.dataganja.modelos;

/**
 * Created by alejandrosebastian on 22/05/2016.
 */
public class Insumo {

    private String tipoDeInsumo;
    private String nombreInsumo;
    private String cantidad;
    private int id, _idFinca;

    public Insumo(int _idFinca, String tipoDeInsumo, String nombreInsumo, String cantidad, int id) {
        this.tipoDeInsumo = tipoDeInsumo;
        this.nombreInsumo = nombreInsumo;
        this.cantidad = cantidad;
        this.id = id;
        this._idFinca = _idFinca;
    }

    public String getTipoDeInsumo() {
        return tipoDeInsumo;
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public String getCantidad() {
        return cantidad;
    }

    /**
     * @return retorna el ID del insumo.
     */
    public int getId() {
        return id;
    }

    /**
     * @return retorna el ID de la finca a la que pertenece.
     */
    public int getIdFinca() {
        return _idFinca;
    }
}
