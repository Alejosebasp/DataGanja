package com.alejosebasp.dataganja.modelos;

import java.util.Date;

/**
 * Created by alejandrosebastian on 20/11/2016.
 */
public class Egreso {

    private int Id_Egreso, Id_Finca;
    private String Asunto_Egreso;
    private Date Fecha_Egreso;
    private Double Valor_Ingreso;

    public Egreso(int id_Egreso, int id_Finca, String asunto_Egreso, Date fecha_Egreso, Double valor_Ingreso) {
        Id_Egreso = id_Egreso;
        Id_Finca = id_Finca;
        Asunto_Egreso = asunto_Egreso;
        Fecha_Egreso = fecha_Egreso;
        Valor_Ingreso = valor_Ingreso;
    }

    public int getId_Egreso() {
        return Id_Egreso;
    }

    public void setId_Egreso(int id_Egreso) {
        Id_Egreso = id_Egreso;
    }

    public int getId_Finca() {
        return Id_Finca;
    }

    public void setId_Finca(int id_Finca) {
        Id_Finca = id_Finca;
    }

    public String getAsunto_Egreso() {
        return Asunto_Egreso;
    }

    public void setAsunto_Egreso(String asunto_Egreso) {
        Asunto_Egreso = asunto_Egreso;
    }

    public Date getFecha_Egreso() {
        return Fecha_Egreso;
    }

    public void setFecha_Egreso(Date fecha_Egreso) {
        Fecha_Egreso = fecha_Egreso;
    }

    public Double getValor_Ingreso() {
        return Valor_Ingreso;
    }

    public void setValor_Ingreso(Double valor_Ingreso) {
        Valor_Ingreso = valor_Ingreso;
    }

    @Override
    public String toString() {
        return "Egreso{" +
                "Id_Egreso=" + Id_Egreso +
                ", Id_Finca=" + Id_Finca +
                ", Asunto_Egreso='" + Asunto_Egreso + '\'' +
                ", Fecha_Egreso=" + Fecha_Egreso +
                ", Valor_Ingreso=" + Valor_Ingreso +
                '}';
    }
}
