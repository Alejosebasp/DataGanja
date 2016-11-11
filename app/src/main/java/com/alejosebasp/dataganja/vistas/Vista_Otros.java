package com.alejosebasp.dataganja.vistas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.alejosebasp.dataganja.R;
import com.alejosebasp.dataganja.controladores.AdminBaseDatos;
import com.alejosebasp.dataganja.controladores.BaseAdapterListaOtros;
import com.alejosebasp.dataganja.modelos.Otro;

import java.util.ArrayList;


public class Vista_Otros extends Activity {

    private Button BT_agregar_otro_vista;
    private ListView LV_otros_vista;

    private ArrayList<Otro> otros;
    private BaseAdapterListaOtros adapter;
    private AdminBaseDatos adminBaseDatos;
    private int _idFinca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista__otros);

        Bundle extras = getIntent().getExtras();
        _idFinca = extras.getInt("_idFinca");

        adminBaseDatos = new AdminBaseDatos(this);
        listarOtros(_idFinca);

        BT_agregar_otro_vista = (Button)findViewById(R.id.BT_agregar_otro_vista);
        LV_otros_vista = (ListView)findViewById(R.id.LV_otros_vista);

        if (otros == null){
            lanzarAgregarOtro(_idFinca);
        }
        else {
            adapter = new BaseAdapterListaOtros(this, otros);
            LV_otros_vista.setAdapter(adapter);

            updateLista();
        }

        BT_agregar_otro_vista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarAgregarOtro(_idFinca);
            }
        });
    }

    private void updateLista() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                listarOtros(_idFinca);
                adapter.setOtros(otros);
                adapter.notifyDataSetChanged();
            }
        }).start();
    }

    private void listarOtros(int _idFinca) {

        ArrayList<Otro> lista = new ArrayList<>();

        if (adminBaseDatos.listarOtros().isEmpty()){
            otros = null;
        }
        else {
            for (Otro otro : adminBaseDatos.listarOtros()) {
                if (otro.getIdFinca() == _idFinca) {
                    lista.add(otro);
                }
            }
            otros = lista;
        }
    }

    public void lanzarAgregarOtro(int _idFinca) {
        Intent intent = new Intent(this, Agregar_Otro.class);
        intent.putExtra("_idFinca", _idFinca);
        startActivity(intent);
    }
}
