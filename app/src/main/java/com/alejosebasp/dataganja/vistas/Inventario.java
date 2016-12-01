package com.alejosebasp.dataganja.vistas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alejosebasp.dataganja.R;

public class Inventario extends AppCompatActivity {

    public Button BT_animales_inventario, BT_herramientas_inventario;
    public Button BT_insumos_inventario, BT_otros_inventario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);

        Bundle extras = getIntent().getExtras();
        final int _idFinca = extras.getInt("_id");

        BT_animales_inventario = (Button)findViewById(R.id.BT_animales_inventario);
        BT_herramientas_inventario = (Button)findViewById(R.id.BT_herramientas_inventario);
        BT_insumos_inventario = (Button)findViewById(R.id.BT_insumos_inventario);
        BT_otros_inventario = (Button)findViewById(R.id.BT_otros_inventario);

        BT_animales_inventario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarAnimales(_idFinca);
            }
        });
        BT_herramientas_inventario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarHerramientas(_idFinca);
            }
        });
        BT_insumos_inventario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarInsumos(_idFinca);
            }
        });


    }

    private void lanzarInsumos(int _idFinca) {
        Intent intent = new Intent(this, Vista_Insumos.class);
        intent.putExtra("_idFinca", _idFinca);
        startActivity(intent);
    }

    public void lanzarAnimales(int _idFinca){
        Intent intent = new Intent(this, Vista_Animales.class);
        intent.putExtra("_idFinca", _idFinca);
        startActivity(intent);
    }

    public void lanzarHerramientas(int _idFinca){
        Intent intent = new Intent(this, Vista_Herramientas.class);
        intent.putExtra("_idFinca", _idFinca);
        startActivity(intent);
    }
}
