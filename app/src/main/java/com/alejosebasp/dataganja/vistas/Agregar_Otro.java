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

public class Agregar_Otro extends Activity {

    private Button BT_agregar_otro;
    private EditText ET_nombre_otro, ET_descripcion_otro, ET_id_otro;

    private boolean condicion1, condicion2;
    private String nombre, descripcion;
    private int id_otro;
    private AdminBaseDatos admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar__otro);

        condicion1 = false;
        condicion2 =  false;

        BT_agregar_otro = (Button)findViewById(R.id.BT_agregar_otro);
        ET_descripcion_otro = (EditText)findViewById(R.id.ET_descripcion_otro);
        ET_id_otro = (EditText)findViewById(R.id.ET_id_otro);
        ET_nombre_otro = (EditText)findViewById(R.id.ET_nombre_otro);

        admin = new AdminBaseDatos(this);

        Bundle extras = getIntent().getExtras();
        final int _idFinca = extras.getInt("_idFinca");

        BT_agregar_otro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerDatos(_idFinca);
            }
        });
    }

    private void obtenerDatos(int _idFinca) {

        if (ET_nombre_otro.getText().toString().isEmpty()){
            Toast.makeText(this, "Debe agregar un nombre.", Toast.LENGTH_SHORT).show();
            condicion1 = false;
        }
        else {
            condicion1 = true;
            nombre = ET_nombre_otro.getText().toString();}

        if (ET_descripcion_otro.getText().toString().isEmpty()){
            Toast.makeText(this, "Debe agregar una descripcion.", Toast.LENGTH_SHORT).show();
            condicion2 = false;
        }
        else {
            condicion2 = true;
            descripcion = ET_descripcion_otro.getText().toString();
        }
        if (ET_id_otro.getText().toString().isEmpty()){
            id_otro = 0;
        }
        else id_otro = Integer.parseInt(ET_id_otro.getText().toString());

        if (condicion1 && condicion2){

            admin.guardarOtro(_idFinca, nombre, descripcion, id_otro);

            Toast.makeText(this, "Se ha agregado el articulo.", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, Vista_Otros.class);
            intent.putExtra("_idFinca", _idFinca);
            startActivity(intent);
        }
    }
}
