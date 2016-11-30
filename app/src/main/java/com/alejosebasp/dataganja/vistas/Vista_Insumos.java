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
import com.alejosebasp.dataganja.controladores.BaseAdapterListaInsumos;
import com.alejosebasp.dataganja.modelos.Insumo;

import java.util.ArrayList;

public class Vista_Insumos extends Activity {
/*
    private Button BT_agregar_insumo_vista;
    private ListView LV_insumos_vista;

    private AdminBaseDatos adminBaseDatos;
    private ArrayList<Insumo> insumos;
    private BaseAdapterListaInsumos adapter;
    private int _idFinca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista__insumos);

        Bundle extras = getIntent().getExtras();
        _idFinca = extras.getInt("_idFinca");

        adminBaseDatos = new AdminBaseDatos(this);
        listarInsumos(_idFinca);

        BT_agregar_insumo_vista = (Button)findViewById(R.id.BT_agregar_insumo_vista);
        LV_insumos_vista = (ListView)findViewById(R.id.LV_insumos_vista);

        if (insumos == null){
            lanzarAgregarInsumo(_idFinca);
        }
        else {
            adapter = new BaseAdapterListaInsumos(this, insumos);
            LV_insumos_vista.setAdapter(adapter);

            updateLista();
        }

        BT_agregar_insumo_vista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarAgregarInsumo(_idFinca);
            }
        });
    }

    private void updateLista() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                listarInsumos(_idFinca);
                adapter.setInsumos(insumos);
                adapter.notifyDataSetChanged();
            }
        }).start();
    }

    private void listarInsumos(int _idFinca) {

        ArrayList<Insumo> lista = new ArrayList<>();

        if (adminBaseDatos.listarInsumos().isEmpty()){
            insumos = null;
        }
        else {
            for (Insumo insumo: adminBaseDatos.listarInsumos()){
                if (insumo.getIdFinca() == _idFinca){
                    lista.add(insumo);
                }
            }
            insumos = lista;
        }
    }

    public void lanzarAgregarInsumo(int _idFinca) {
        Intent intent = new Intent(this, Agregar_Insumo.class);
        intent.putExtra("_idFinca", _idFinca);
        startActivity(intent);
    }*/


}
