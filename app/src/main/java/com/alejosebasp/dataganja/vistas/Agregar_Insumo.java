package com.alejosebasp.dataganja.vistas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alejosebasp.dataganja.R;
import com.alejosebasp.dataganja.controladores.AdminBaseDatos;

public class Agregar_Insumo extends Activity {

    private EditText ET_tipo_insumo, ET_nombre_insumo, ET_cantidad_insumo, ET_id_insumo;
    private Button BT_agregar_insumo;

    private String tipoInsumo, nombreInsummo, cantidad;
    private int id;
    private boolean condicion1, condicion2;
    private AdminBaseDatos adminBaseDatos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_insumo);

        Bundle extras = getIntent().getExtras();
        final int _idFinca = extras.getInt("_id");

        adminBaseDatos = new AdminBaseDatos(this);

        ET_tipo_insumo = (EditText)findViewById(R.id.ET_tipo_insumo);
        ET_nombre_insumo = (EditText)findViewById(R.id.ET_nombre_insumo);
        ET_cantidad_insumo = (EditText)findViewById(R.id.ET_cantidad_insumo);
        ET_id_insumo = (EditText)findViewById(R.id.ET_id_insumo);
        BT_agregar_insumo = (Button)findViewById(R.id.BT_agregar_insumo);

        BT_agregar_insumo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerDatos(_idFinca);
            }
        });
    }

    private void obtenerDatos(int _idFinca) {

        if (ET_id_insumo.getText().toString().isEmpty()){
            id = 0;
        }
        else id = Integer.parseInt(ET_id_insumo.getText().toString());

        if (ET_cantidad_insumo.getText().toString().isEmpty()){
            Toast.makeText(this, "Debe agregar una cantidad.", Toast.LENGTH_SHORT).show();
            condicion1 = false;
        }
        else {
            cantidad = ET_cantidad_insumo.getText().toString();
            condicion1 = true;
        }

        if (ET_nombre_insumo.getText().toString().isEmpty()){
            Toast.makeText(this, "Debe agregar un nombre.", Toast.LENGTH_SHORT).show();
            condicion2 = false;
        }
        else {
            nombreInsummo = ET_nombre_insumo.getText().toString();
            condicion2 = true;
        }

        if (ET_tipo_insumo.getText().toString().isEmpty()){
            tipoInsumo = "";
        }
        else tipoInsumo = ET_tipo_insumo.getText().toString();

        if (condicion2 && condicion1){

            adminBaseDatos.guardarInsumo(_idFinca, tipoInsumo, nombreInsummo, cantidad, id);

            Toast.makeText(this, "Se ha agregado el insumo.", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, Vista_Insumos.class);
            intent.putExtra("_idFinca", _idFinca);
            startActivity(intent);
        }
    }
}
