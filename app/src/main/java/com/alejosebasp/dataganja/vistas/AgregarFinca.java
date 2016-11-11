package com.alejosebasp.dataganja.vistas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.alejosebasp.dataganja.R;
import com.alejosebasp.dataganja.controladores.AdminBaseDatos;
import com.alejosebasp.dataganja.controladores.DB_Finca;

public class AgregarFinca extends Activity {

    private EditText ET_nombre_propietario, ET_nombre_finca, ET_tamaño_finca, ET_numero_trabajadores, ET_ubicacion;
    private Button BT_agregar_finca;
    private RadioGroup RG_tipo_produccion;
    private String tipoProduccion, nombrePropietario, nombreFinca, ubicacion;
    private int numeroTrabajadores;
    private double tamañoFinca;
    private boolean condicion1;
    private boolean condicion2;

    private static AdminBaseDatos adminBaseDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_finca);

        adminBaseDatos = new AdminBaseDatos(this);

        ET_nombre_propietario = (EditText)findViewById(R.id.ET_nombre_propietario);
        ET_nombre_finca = (EditText)findViewById(R.id.ET_nombre_finca);
        ET_tamaño_finca = (EditText)findViewById(R.id.ET_tamaño);
        ET_numero_trabajadores = (EditText)findViewById(R.id.ET_num_trabajadores);
        ET_ubicacion = (EditText)findViewById(R.id.ET_ubicacion);
        BT_agregar_finca = (Button)findViewById(R.id.BT_agregar_finca);
        RG_tipo_produccion = (RadioGroup)findViewById(R.id.RG_tipo_produccion);

        BT_agregar_finca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarDatos();
            }
        });
    }

    public void asignarDatos(){


        RG_tipo_produccion.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.RB_tipo_agricola){
                    tipoProduccion = "Agricola";
                }
                else if (checkedId == R.id.RB_tipo_agropecuario){
                    tipoProduccion = "Agropecuario";
                }
                else if (checkedId == R.id.RB_tipo_pecuario){
                    tipoProduccion = "Pecuario";
                }
                else tipoProduccion = " ";
            }
        });

        if (ET_nombre_propietario.getText().toString().length() == 0){
            Toast.makeText(this, "Por favor ingrese el nombre de propietario.", Toast.LENGTH_SHORT).show();
            condicion1 = false;
        }
        else {
            nombrePropietario = ET_nombre_propietario.getText().toString();
            condicion1 = true;
        }

        if (ET_nombre_finca.getText().toString().length() == 0){
            Toast.makeText(this, "Por favor ingrese el nombre de la finca.", Toast.LENGTH_SHORT).show();
            condicion2 = false;
        }
        else {
            nombreFinca = ET_nombre_finca.getText().toString();
            condicion2 = true;
        }
        if (ET_ubicacion.getText().toString().length() == 0){
            ubicacion = " ";
        }
        else {ubicacion = ET_ubicacion.getText().toString();}
        if (ET_numero_trabajadores.getText().toString().length() == 0){
            numeroTrabajadores = 0;
        }
        else {numeroTrabajadores = Integer.parseInt(ET_numero_trabajadores.getText().toString());}
        if (ET_tamaño_finca.getText().toString().length() == 0){
            tamañoFinca = 0;
        }
        else {tamañoFinca = Double.parseDouble(ET_tamaño_finca.getText().toString());}

        if (condicion1 && condicion2){

            adminBaseDatos.guardarFinca(nombrePropietario, nombreFinca, tamañoFinca, numeroTrabajadores, ubicacion, tipoProduccion);

            Toast toast = Toast.makeText(getApplicationContext(), "La finca se ha agregado.", Toast.LENGTH_LONG);
            toast.show();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }
}
