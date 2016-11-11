package com.alejosebasp.dataganja.vistas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.alejosebasp.dataganja.R;
import com.alejosebasp.dataganja.controladores.AdminBaseDatos;
import com.alejosebasp.dataganja.controladores.BaseAdapterListaFincas;
import com.alejosebasp.dataganja.modelos.Finca;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button BT_agregar_finca;
    private ListView LV_lista_fincas;

    private AdminBaseDatos adminBaseDatos;
    private ArrayList<Finca> fincas;
    private BaseAdapterListaFincas adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adminBaseDatos = new AdminBaseDatos(this);
        listarFincas();

        BT_agregar_finca = (Button)findViewById(R.id.BT_agregarFinca_main);
        LV_lista_fincas = (ListView)findViewById(R.id.LV_lista_fincas);

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
        BT_agregar_finca.setOnClickListener(this);
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
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.BT_agregarFinca_main:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        lanzarAgregarFinca();
                    }
                }).start();
                break;
        }
    }
}