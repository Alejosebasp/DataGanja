package com.alejosebasp.dataganja.controladores;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.alejosebasp.dataganja.modelos.Finca;

import java.util.ArrayList;

/**
 * Created by alejandrosebastian on 25/05/2016.
 */
public class DB_Finca extends SQLiteOpenHelper {

    private final String TABLA_FINCA = "CREATE TABLE DBfincas (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "NombrePropietario TEXT," +
            "NombreFinca TEXT," +
            "TamañoFinca REAL," +
            "NumeroTrabajadores INTEGER," +
            "Ubicacion TEXT," +
            "TipoProduccion TEXT)";

    private final String TABLA_ANIMAL = "CREATE TABLE DBanimales (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "_idFinca INTEGER," +
            "Peso REAL," +
            "Edad REAL," +
            "id INTEGER," +
            "Sexo TEXT," +
            "Proposito TEXT," +
            "Etapa_productiva TEXT," +
            "Dieta TEXT," +
            "Raza TEXT," +
            "Especie TEXT)";

    private final String TABLA_HERRAMIENTA = "CREATE TABLE DBherramientas (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "_idFinca INTEGER," +
            "NombreHerramienta TEXT," +
            "id_herramienta INTEGER)";

    private final String TABLA_OTRO = "CREATE TABLE DBotros (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "_idFinca INTEGER," +
            "NombreArticulo TEXT," +
            "Descripcion TEXT," +
            "id_otro INTEGER)";

    private final String TABLA_INSUMO = "CREATE TABLE DBinsumos (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "_idFinca INTEGER," +
            "TipoInsumo TEXT," +
            "NombreInsumo TEXT," +
            "Cantidad TEXT," +
            "id_insumo INTEGER)";

    public DB_Finca(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_FINCA);
        db.execSQL(TABLA_ANIMAL);
        db.execSQL(TABLA_HERRAMIENTA);
        db.execSQL(TABLA_OTRO);
        db.execSQL(TABLA_INSUMO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS DBfincas");
        //onCreate(db);
    }
}
