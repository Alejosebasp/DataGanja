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

public class Agregar_Herramienta extends Activity {

    private EditText ET_nombre_herramienta, ET_id_herramienta;
    private Button BT_agregar_herramienta;

    private AdminBaseDatos adminBaseDatos;
    private boolean condicion1;
    int id;
    String nombreHerramienta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar__herramienta);

        Bundle extras = getIntent().getExtras();
        final int _idFinca = extras.getInt("_id");

        adminBaseDatos = new AdminBaseDatos(this);

        ET_id_herramienta = (EditText)findViewById(R.id.ET_id_herramienta);
        ET_nombre_herramienta = (EditText)findViewById(R.id.ET_nombre_herramienta);
        BT_agregar_herramienta = (Button)findViewById(R.id.BT_agregar_herramienta);

        BT_agregar_herramienta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerDatos(_idFinca);
            }
        });
    }

    private void obtenerDatos(int _idFinca) {

        if (ET_nombre_herramienta.getText().toString().isEmpty()){
            Toast.makeText(this, "Debe ingresar un nombre de herramienta", Toast.LENGTH_SHORT). show();
            condicion1 = false;
        }
        else {
            nombreHerramienta = ET_nombre_herramienta.getText().toString();
            condicion1 = true;
        }

        if (ET_id_herramienta.getText().toString().isEmpty()){
            id = 0;
        }
        else id = Integer.parseInt(ET_id_herramienta.getText().toString());

        if (condicion1){
            adminBaseDatos.guardarHerramienta(_idFinca, nombreHerramienta, id);

            Toast.makeText(this, "La herramienta se ha agregado.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Vista_Herramientas.class);
            intent.putExtra("_idFinca", _idFinca);
            startActivity(intent);
        }

    }
}
