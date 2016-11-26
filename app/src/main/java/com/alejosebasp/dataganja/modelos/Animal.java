package com.alejosebasp.dataganja.modelos;

/**
 * Created by alejandrosebastian on 04/05/2016.
 */
public class Animal {

    private double peso, edad;
    private int Id_Animal, Id_Finca;
    private String sexo, proposito, etapa_productiva, dieta, raza, especie;

    public Animal(int Id_Finca, double peso, double edad, int id, String sexo, String proposito,
                  String etapa_productiva, String dieta, String raza, String especie) {
        this.Id_Finca = Id_Finca;
        this.peso = peso;
        this.edad = edad;
        this.Id_Animal = id;
        this.sexo = sexo;
        this.proposito = proposito;
        this.etapa_productiva = etapa_productiva;
        this.dieta = dieta;
        this.raza = raza;
        this.especie = especie;
    }

    public Animal(int Id_Animal) {
        this.Id_Animal = Id_Animal;
    }

    public double getPeso() {
        return peso;
    }

    public double getEdad() {
        return edad;
    }

    public int getId() {
        return Id_Animal;
    }

    public int getId_Finca() {
        return Id_Finca;
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
        return "Numero de animal: " + Id_Animal +
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
