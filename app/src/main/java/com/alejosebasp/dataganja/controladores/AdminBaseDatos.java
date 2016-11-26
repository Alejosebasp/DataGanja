package com.alejosebasp.dataganja.controladores;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.alejosebasp.dataganja.modelos.Animal;
import com.alejosebasp.dataganja.modelos.Finca;
import com.alejosebasp.dataganja.modelos.Herramienta;
import com.alejosebasp.dataganja.modelos.Insumo;
import com.alejosebasp.dataganja.modelos.Otro;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by alejandrosebastian on 28/05/2016.
 */
public class AdminBaseDatos {

    private Finca finca;
    private Animal animal;
    private Otro otro;
    private DB_Finca db_finca;
    private Herramienta herramienta;
    private Insumo insumo;

    public AdminBaseDatos(Context context) {

        if (db_finca == null){
            db_finca = new DB_Finca(context, "DB_fincas", null, 1);
        }
    }

    public void guardarFinca(String nombre_propietario, String nombre_finca, double tamaño,
                             int numero_trabajadores, String ubicacion, String tipoProduccion){

        SQLiteDatabase database = db_finca.getWritableDatabase();
        database.execSQL("INSERT INTO DBfincas VALUES (null, '" +
                nombre_propietario + "', '" + nombre_finca + "', " +
                tamaño + ", " + numero_trabajadores + ", '" +
                ubicacion + "', '" + tipoProduccion + "' )");

        database.close();
    }

    public ArrayList<Finca> listarFincas(){

        ArrayList<Finca> fincas = new ArrayList<>();

        SQLiteDatabase database = db_finca.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT _id, NombrePropietario, NombreFinca, TamañoFinca, " +
                "NumeroTrabajadores, Ubicacion, TipoProduccion FROM DBfincas", null);

        while (cursor.moveToNext()){
            finca = new Finca(cursor.getInt(0),cursor.getString(1), cursor.getString(2), cursor.getDouble(3), cursor.getInt(4),
                    cursor.getString(5), cursor.getString(6));
            fincas.add(finca);
        }
        cursor.close();
        database.close();

        return fincas;
    }

    public void guardarAnimal(int _idFinca, double peso, double edad, int id, String sexo, String proposito,
                              String etapa_productiva, String dieta, String raza, String especie){

        SQLiteDatabase database = db_finca.getWritableDatabase();
        database.execSQL("INSERT INTO DBanimales VALUES (null, " +
                _idFinca + ", " + peso + ", " + edad + ", " +
                id + ", '" + sexo + "', '" +
                proposito + "', '" + etapa_productiva +
                "', '" + dieta + "', '"+ raza +
                "', '" + especie + "')");

        database.close();
    }

    public ArrayList<Animal> listarAnimales(){

        ArrayList<Animal> animales = new ArrayList<>();

        SQLiteDatabase database = db_finca.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM DBanimales", null);

        while (cursor.moveToNext()){
            animal = new Animal(cursor.getInt(1),cursor.getDouble(2), cursor.getDouble(3), cursor.getInt(4),
                    cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8),
                    cursor.getString(9), cursor.getString(10));
            animales.add(animal);
        }
        cursor.close();
        database.close();

        return animales;
    }

    public void guardarOtro(int _idFinca, String nombre, String descripcion, int id_otro){

        SQLiteDatabase database = db_finca.getWritableDatabase();
        database.execSQL("INSERT INTO DBotros VALUES (null, " +
                _idFinca + ", '" +
                nombre + "', '" +
                descripcion + "', " +
                id_otro + ")");

        database.close();
    }

    public ArrayList<Otro> listarOtros() {

        ArrayList<Otro> otros = new ArrayList<>();

        SQLiteDatabase database = db_finca.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM DBotros", null);

        while (cursor.moveToNext()){
            otro = new Otro(cursor.getInt(1), cursor.getString(2), cursor.getString(3), cursor.getInt(4));
            otros.add(otro);
        }
        cursor.close();
        database.close();

        return otros;
    }

    public void guardarHerramienta(int _idFinca, String nombre_herramienta, int id_herramienta){

        SQLiteDatabase database = db_finca.getWritableDatabase();

        database.execSQL("INSERT INTO DBherramientas VALUES (null, " +
                _idFinca + ", '" +
                nombre_herramienta + "', " +
                id_herramienta + ")");

        database.close();
    }

    public ArrayList<Herramienta> listarHerramientas(){

        ArrayList<Herramienta> herramientas = new ArrayList<>();

        SQLiteDatabase database = db_finca.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM DBherramientas", null);

        while (cursor.moveToNext()){
            herramienta = new Herramienta(cursor.getInt(1), cursor.getInt(2));
            herramientas.add(herramienta);
        }
        cursor.close();
        database.close();

        return herramientas;
    }

    public void guardarInsumo(int _idFinca, String tipoDeInsumo, String nombreInsumo, String cantidad, int id){

        SQLiteDatabase database = db_finca.getWritableDatabase();

        database.execSQL("INSERT INTO DBinsumos VALUES (null, " +
                _idFinca + ", '" +
                tipoDeInsumo + "', '" +
                nombreInsumo + "', '" +
                cantidad + "', " +
                id + ")");

        database.close();
    }

    public ArrayList<Insumo> listarInsumos(){

        ArrayList<Insumo> insumos = new ArrayList<>();

        SQLiteDatabase database = db_finca.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM DBinsumos", null);

        while (cursor.moveToNext()){
            insumo = new Insumo(cursor.getInt(1), cursor.getString(2), cursor.getString(3),
                    cursor.getString(4), cursor.getInt(5));
            insumos.add(insumo);
        }
        cursor.close();
        database.close();

        return insumos;
    }
}