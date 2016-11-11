package com.alejosebasp.dataganja.modelos;

/**
 * Created by alejandrosebastian on 04/05/2016.
 */
public class Animal {

    private double peso, edad;
    private int id, _idFinca;
    private String sexo, proposito, etapa_productiva, dieta, raza, especie;

    public Animal(int _idFinca, double peso, double edad, int id, String sexo, String proposito,
                  String etapa_productiva, String dieta, String raza, String especie) {
        this._idFinca = _idFinca;
        this.peso = peso;
        this.edad = edad;
        this.id = id;
        this.sexo = sexo;
        this.proposito = proposito;
        this.etapa_productiva = etapa_productiva;
        this.dieta = dieta;
        this.raza = raza;
        this.especie = especie;
    }

    public double getPeso() {
        return peso;
    }

    public double getEdad() {
        return edad;
    }

    public int getId() {
        return id;
    }

    public int get_idFinca() {
        return _idFinca;
    }

    public String getSexo() {
        return sexo;
    }

    public String getProposito() {
        return proposito;
    }

    public String getEtapa_productiva() {
        return etapa_productiva;
    }

    public String getDieta() {
        return dieta;
    }

    public String getRaza() {
        return raza;
    }

    public String getEspecie() {
        return especie;
    }

    @Override
    public String toString() {
        return "Numero de animal: " + id +
                ", peso: " + peso +
                ", edad: " + edad +
                ", sexo: " + sexo +
                ", proposito: " + proposito +
                ", etapa productiva: " + etapa_productiva +
                ", dieta: " + dieta +
                ", raza: " + raza +
                ", especie: " + especie;
    }
}
