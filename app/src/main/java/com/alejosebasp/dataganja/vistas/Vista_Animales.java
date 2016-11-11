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
import com.alejosebasp.dataganja.controladores.BaseAdapterListaAnimales;
import com.alejosebasp.dataganja.modelos.Animal;

import java.util.ArrayList;

public class Vista_Animales extends Activity {

    private Button BT_agregar_animal_vista;
    private ListView LV_animales_vista;

    private ArrayList<Animal> animals;
    private AdminBaseDatos adminBaseDatos;
    private BaseAdapterListaAnimales adapter;
    private int _idFinca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_animales);

        Bundle extras = getIntent().getExtras();
        _idFinca = extras.getInt("_idFinca");

        adminBaseDatos = new AdminBaseDatos(this);
        listarAnimals();

        BT_agregar_animal_vista = (Button)findViewById(R.id.BT_agregar_animal_vista);
        LV_animales_vista = (ListView)findViewById(R.id.LV_animales_vista);

        if (animals == null){
            lanzaAgregarAnimal(_idFinca);
        }
        else {
            adapter = new BaseAdapterListaAnimales(this, animals);
            LV_animales_vista.setAdapter(adapter);

            updateLista();
        }



        BT_agregar_animal_vista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzaAgregarAnimal(_idFinca);
            }
        });
    }

    @Override
    protected void onResume() {

        super.onResume();
        listarAnimals();
        adapter.setAnimals(animals);
        adapter.notifyDataSetChanged();

    }


    private void updateLista() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                listarAnimals();
                adapter.setAnimals(animals);
                adapter.notifyDataSetChanged();
            }
        }).start();
    }

    private void listarAnimals() {

        ArrayList<Animal> lista = new ArrayList<>();

        if (adminBaseDatos.listarAnimales().isEmpty()){
            animals = null;
        }
        else {
            for (Animal animal: adminBaseDatos.listarAnimales()){
                if (animal.get_idFinca() == _idFinca){
                    lista.add(animal);
                }
            }
            animals = lista;
        }
    }

    private void lanzaAgregarAnimal(int _idFinca) {
        Intent intent = new Intent(this, Agregar_Animal.class);
        intent.putExtra("_idFinca", _idFinca);
        startActivity(intent);
    }
}
