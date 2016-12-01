package com.alejosebasp.dataganja.vistas;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.alejosebasp.dataganja.R;
import com.alejosebasp.dataganja.controladores.AdminBaseDatos;
import com.alejosebasp.dataganja.controladores.BaseAdapterListaFincas;
import com.alejosebasp.dataganja.modelos.Finca;

import java.util.ArrayList;

public class MainActivity extends Activity{


    private ListView LV_lista_fincas;

    private AdminBaseDatos adminBaseDatos;
    private ArrayList<Finca> fincas;
    private BaseAdapterListaFincas adapter;
    private FloatingActionButton FAB_AgregarFinca_Main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adminBaseDatos = new AdminBaseDatos(this);
        listarFincas();

        LV_lista_fincas = (ListView)findViewById(R.id.LV_lista_fincas);
        FAB_AgregarFinca_Main = (FloatingActionButton)findViewById(R.id.FAB_AgregarFinca_Main);

        if (fincas.isEmpty()){
            lanzarAgregarFinca();
        }
        else {
            adapter = new BaseAdapterListaFincas(getBaseContext(), fincas);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    LV_lista_fincas.setAdapter(adapter);
                }
            }).start();
            updateLista(adapter);
        }

        LV_lista_fincas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Finca finca = fincas.get(position);
                        int _id = finca.getId();
                        lanzarVistaFinca(_id);
                    }
                }).start();
            }
        });

        FAB_AgregarFinca_Main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarAgregarFinca();
            }
        });
    }

    public void updateLista(final BaseAdapterListaFincas adapter){

        new Thread(new Runnable() {
            @Override
            public void run() {
                listarFincas();
                adapter.setFincas(fincas);
                adapter.notifyDataSetChanged();
            }
        }).start();
    }

    public void listarFincas(){
        fincas = adminBaseDatos.listarFincas();
    }

    public void lanzarAgregarFinca (){

        Intent intencion = new Intent(this, AgregarFinca.class);
        startActivity(intencion);
    }

    public void lanzarVistaFinca(int _id){
        Intent intent = new Intent(this, Vista_Finca.class);
        intent.putExtra("_id", _id);
        Log.v("Main", _id + "");
        startActivity(intent);
    }


}