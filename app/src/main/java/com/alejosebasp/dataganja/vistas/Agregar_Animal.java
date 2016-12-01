package com.alejosebasp.dataganja.vistas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.alejosebasp.dataganja.R;
import com.alejosebasp.dataganja.controladores.AdminBaseDatos;

public class Agregar_Animal extends Activity {

    private EditText ET_id_animal, ET_especie_animal, ET_raza_animal;
    private EditText ET_peso_animal, ET_edad_animal, ET_dieta_animal;
    private RadioGroup RG_sexos_animal;
    private Button BT_agregar_animal;

    private AdminBaseDatos adminBaseDatos;
    private String sexo, especie, raza, etapa_productiva, proposito, dieta;
    private int id;
    private double peso, edad;
    //boolean condicion3 = false;
    boolean condicion1, condicion2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_animal);

        Bundle extras = getIntent().getExtras();
        final int _idFinca = extras.getInt("_id");

        adminBaseDatos = new AdminBaseDatos(this);

        ET_dieta_animal = (EditText)findViewById(R.id.ET_dieta_animal);
        ET_id_animal = (EditText)findViewById(R.id.ET_id_animal);
        ET_especie_animal = (EditText)findViewById(R.id.ET_especie_animal);
        ET_raza_animal = (EditText)findViewById(R.id.ET_raza_animal);
        ET_peso_animal = (EditText)findViewById(R.id.ET_peso_animal);
        ET_edad_animal = (EditText)findViewById(R.id.ET_edad_animal);
        RG_sexos_animal = (RadioGroup)findViewById(R.id.RG_sexos_animal);
        BT_agregar_animal = (Button)findViewById(R.id.BT_agregar_animal);

        BT_agregar_animal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarDatos(_idFinca);
            }
        });
    }

    private void asignarDatos(int _idFinca) {

        RG_sexos_animal.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.RB_sexo_hembra){
                    sexo = "Hembra";
                    //condicion3 = true;
                }
                else if (checkedId == R.id.RB_sexo_macho){
                    sexo = "Macho";
                    //condicion3 = true;
                }
            }
        });

        if (ET_id_animal.getText().toString().length() == 0){
            Toast.makeText(this, "Por favor ingrese un id.", Toast.LENGTH_SHORT).show();
            condicion1 = false;
        }
        else {
            id = Integer.parseInt(ET_id_animal.getText().toString());
            condicion1 = true;
        }

        if (ET_especie_animal.getText().toString().length() == 0){
            Toast.makeText(this, "Por favor ingrese la especie.", Toast.LENGTH_SHORT).show();
            condicion2 = false;
        }
        else {
            especie = ET_especie_animal.getText().toString();
            condicion2 = true;
        }

        if (ET_dieta_animal.getText().toString().length() == 0){
            dieta = " ";
        }
        else { dieta = ET_dieta_animal.getText().toString();}

        if (ET_edad_animal.getText().toString().length() == 0){
            edad = 0;
        }
        else { edad = Double.parseDouble(ET_edad_animal.getText().toString());}

        if (ET_peso_animal.getText().toString().length() == 0){
            peso = 0;
        }
        else { peso = Double.parseDouble(ET_peso_animal.getText().toString());}

        if (ET_raza_animal.getText().toString().length() == 0){
            raza = " ";
        }
        else { raza = ET_raza_animal.getText().toString();}

        if (condicion1 && condicion2){

            adminBaseDatos.guardarAnimal(_idFinca, peso, edad, id, sexo, proposito, etapa_productiva, dieta, raza, especie);

            Toast toast = Toast.makeText(getApplicationContext(), "El animal se ha agregado.", Toast.LENGTH_LONG);
            toast.show();

            Intent intent = new Intent(this, Vista_Animales.class);
            intent.putExtra("_idFinca", _idFinca);
            startActivity(intent);
        }


    }
}
