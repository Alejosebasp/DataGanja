package com.alejosebasp.dataganja.vistas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alejosebasp.dataganja.R;
import com.alejosebasp.dataganja.controladores.AdminBaseDatos;
import com.alejosebasp.dataganja.modelos.Finca;

import java.util.ArrayList;

public class Vista_Finca extends AppCompatActivity {

    private TextView TV_nombre_finca_vista, TV_tipo_produccion;
    private TextView TV_propietario_vista;
    private TextView TV_tamaño_vista;
    private TextView TV_ubicacion_vista;
    private TextView TV_trabajadores_vista;
    private Button BT_ver_inventario;

    private AdminBaseDatos adminBaseDatos;
    private ArrayList<Finca> fincas;
    String[] datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista__finca);

        Bundle extras = getIntent().getExtras();
        final int _idFinca = extras.getInt("_id");

        adminBaseDatos = new AdminBaseDatos(this);
        fincas = adminBaseDatos.listarFincas();

        TV_nombre_finca_vista = (TextView)findViewById(R.id.TV_nombre_finca_vista);
        TV_propietario_vista = (TextView)findViewById(R.id.TV_propietario_vista);
        TV_tamaño_vista = (TextView)findViewById(R.id.TV_tamaño_vista);
        TV_ubicacion_vista = (TextView)findViewById(R.id.TV_ubicacion_vista);
        TV_trabajadores_vista = (TextView)findViewById(R.id.TV_trabajadores_vista);
        TV_tipo_produccion = (TextView)findViewById(R.id.TV_tipo_produccion_vista);
        BT_ver_inventario = (Button)findViewById(R.id.BT_ver_inventario);

        cargarDatos(_idFinca);

        BT_ver_inventario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarInventario(_idFinca);
            }
        });

    }

    public void cargarDatos(final int _id){


        new Thread(new Runnable() {
            @Override
            public void run() {

                for (Finca f: fincas){
                    if (f.getId() == _id) {
                        datos = new String[6];
                        final String nombre_finca = "Nombre de la finca: " + f.getNombre_finca();
                        final String nombre_propietario = "Propietario: " + f.getNombre_propietario();
                        final String tamaño = "Tamaño: " + f.getTamaño() + " hectareas";
                        final String ubicacion = "Ubicada en: " + f.getUbicacion();
                        final String trabajadores = "Numero de trabajadores: " + f.getNumero_trabajadores();
                        final String tipo_produccion = "Tipo de producción: " + f.getTipoProduccion();

                        datos[0] = nombre_finca;
                        datos[1] = nombre_propietario;
                        datos[2] = tamaño;
                        datos[3] = ubicacion;
                        datos[4] = trabajadores;
                        datos[5] = tipo_produccion;

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TV_nombre_finca_vista.setText(datos[0]);
                                TV_propietario_vista.setText(datos[1]);
                                TV_tamaño_vista.setText(datos[2]);
                                TV_ubicacion_vista.setText(datos[3]);
                                TV_trabajadores_vista.setText(datos[4]);
                                TV_tipo_produccion.setText(datos[5]);
                            }
                        });
                    }
                }
            }
        }).start();
    }

    public void lanzarInventario(final int _idFinca){
        Intent intencion = new Intent(this, Inventario.class);
        intencion.putExtra("_id", _idFinca);
        startActivity(intencion);
    }
}
