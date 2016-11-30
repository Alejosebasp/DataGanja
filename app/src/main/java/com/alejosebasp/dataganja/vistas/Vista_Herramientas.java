package com.alejosebasp.dataganja.vistas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.alejosebasp.dataganja.R;
import com.alejosebasp.dataganja.controladores.AdminBaseDatos;
import com.alejosebasp.dataganja.controladores.BaseAdapterListaHerramientas;
import com.alejosebasp.dataganja.controladores.BaseAdapterListaInsumos;
import com.alejosebasp.dataganja.modelos.Herramienta;
import com.alejosebasp.dataganja.modelos.Insumo;

import java.util.ArrayList;

public class Vista_Herramientas extends Activity {
/*
    private Button BT_agregar_herramienta_vista;
    private ListView LV_herramientas_vista;

    private AdminBaseDatos adminBaseDatos;
    private ArrayList<Herramienta> herramientas;
    private BaseAdapterListaHerramientas adapter;
    private int _idFinca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista__herramientas);

        Bundle extras = getIntent().getExtras();
        _idFinca = extras.getInt("_idFinca");

        adminBaseDatos = new AdminBaseDatos(this);
        listarHerramientas(_idFinca);

        BT_agregar_herramienta_vista = (Button)findViewById(R.id.BT_agregar_herramienta_vista);
        LV_herramientas_vista = (ListView)findViewById(R.id.LV_herramientas_vista);

        if (herramientas == null){
            lanzarAgregarHerramienta(_idFinca);
        }
        else {
            adapter = new BaseAdapterListaHerramientas(this, herramientas);
            LV_herramientas_vista.setAdapter(adapter);

            updateLista();
        }

        BT_agregar_herramienta_vista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarAgregarHerramienta(_idFinca);
            }
        });
    }

    private void updateLista() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                listarHerramientas(_idFinca);
                adapter.setHerramientas(herramientas);
                adapter.notifyDataSetChanged();
            }
        }).start();
    }

    private void listarHerramientas(int _idFinca) {

        ArrayList<Herramienta> lista = new ArrayList<>();

        if (adminBaseDatos.listarHerramientas().isEmpty()){
            herramientas = null;
        }
        else {
            for (Herramienta h: adminBaseDatos.listarHerramientas()){
                if (h.getIdFinca() == _idFinca){
                    lista.add(h);
                }
            }
            herramientas = lista;
        }
    }

    private void lanzarAgregarHerramienta(int _idFinca) {
        Intent intent = new Intent(this, Agregar_Herramienta.class);
        intent.putExtra("_idFinca", _idFinca);
        startActivity(intent);
    }*/
}
