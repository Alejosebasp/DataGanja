package com.alejosebasp.dataganja.modelos;

import java.util.Date;

/**
 * Created by alejandrosebastian on 20/11/2016.
 */
public class Ingresos {

    private int Id_Ingreso, Id_Finca;
    private String Asunto_Ingreso;
    private Date Fecha_Ingreso;
    private Double Valor_Ingreso;

    public Ingresos(int id_Ingreso, int id_Finca, String asunto_Ingreso, Date fecha_Ingreso, Double valor_Ingreso) {
        Id_Ingreso = id_Ingreso;
        Id_Finca = id_Finca;
        Asunto_Ingreso = asunto_Ingreso;
        Fecha_Ingreso = fecha_Ingreso;
        Valor_Ingreso = valor_Ingreso;
    }

    public int getId_Ingreso() {
        return Id_Ingreso;
    }

    public void setId_Ingreso(int id_Ingreso) {
        Id_Ingreso = id_Ingreso;
    }

    public int getId_Finca() {
        return Id_Finca;
    }

    public void setId_Finca(int id_Finca) {
        Id_Finca = id_Finca;
    }

    public String getAsunto_Ingreso() {
        return Asunto_Ingreso;
    }

    public void setAsunto_Ingreso(String asunto_Ingreso) {
        Asunto_Ingreso = asunto_Ingreso;
    }

    public Date getFecha_Ingreso() {
        return Fecha_Ingreso;
    }

    public void setFecha_Ingreso(Date fecha_Ingreso) {
        Fecha_Ingreso = fecha_Ingreso;
    }

    public Double getValor_Ingreso() {
        return Valor_Ingreso;
    }

    public void setValor_Ingreso(Double valor_Ingreso) {
        Valor_Ingreso = valor_Ingreso;
    }

    @Override
    public String toString() {
        return "Ingresos{" +
                "Id_Ingreso=" + Id_Ingreso +
                ", Id_Finca=" + Id_Finca +
                ", Asunto_Ingreso='" + Asunto_Ingreso + '\'' +
                ", Fecha_Ingreso=" + Fecha_Ingreso +
                ", Valor_Ingreso=" + Valor_Ingreso +
                '}';
    }
}
