package com.alejosebasp.dataganja.modelos;

import java.util.Date;

/**
 * Created by alejandrosebastian on 20/11/2016.
 */
public class Maquinaria {

    private int Serial_Maquina, Id_Finca;
    private String Tipo_Maquinaria;
    private Date Fech_Adqui_Maquina;

    public Maquinaria(int serial_Maquina, int id_Finca, String tipo_Maquinaria, Date fech_Adqui_Maquina) {
        Serial_Maquina = serial_Maquina;
        Id_Finca = id_Finca;
        Tipo_Maquinaria = tipo_Maquinaria;
        Fech_Adqui_Maquina = fech_Adqui_Maquina;
    }

    public int getSerial_Maquina() {
        return Serial_Maquina;
    }

    public void setSerial_Maquina(int serial_Maquina) {
        Serial_Maquina = serial_Maquina;
    }

    public int getId_Finca() {
        return Id_Finca;
    }

    public void setId_Finca(int id_Finca) {
        Id_Finca = id_Finca;
    }

    public String getTipo_Maquinaria() {
        return Tipo_Maquinaria;
    }

    public void setTipo_Maquinaria(String tipo_Maquinaria) {
        Tipo_Maquinaria = tipo_Maquinaria;
    }

    public Date getFech_Adqui_Maquina() {
        return Fech_Adqui_Maquina;
    }

    public void setFech_Adqui_Maquina(Date fech_Adqui_Maquina) {
        Fech_Adqui_Maquina = fech_Adqui_Maquina;
    }

    @Override
    public String toString() {
        return "Maquinaria{" +
                "Serial_Maquina=" + Serial_Maquina +
                ", Id_Finca=" + Id_Finca +
                ", Tipo_Maquinaria='" + Tipo_Maquinaria + '\'' +
                ", Fech_Adqui_Maquina=" + Fech_Adqui_Maquina +
                '}';
    }
}
