package com.alejosebasp.dataganja.vistas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alejosebasp.dataganja.R;
import com.alejosebasp.dataganja.controladores.AdminBaseDatos;
import com.alejosebasp.dataganja.controladores.Singleton;
import com.alejosebasp.dataganja.modelos.Finca;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Vista_Finca extends AppCompatActivity {

    private TextView TV_nombre_finca_vista, TV_tipo_produccion;
    private TextView TV_propietario_vista;
    private TextView TV_tamaño_vista;
    private TextView TV_ubicacion_vista;
    private TextView TV_trabajadores_vista;
    private Button BT_ver_inventario;
    private FloatingActionButton FAB_Editar_Vista_Finca;

    private RequestQueue requestQueue;
    private Singleton singleton;
    private String ListarURL = "http://192.168.0.6/App_ProFarm/ListarFinca.php";

    private AdminBaseDatos adminBaseDatos;
    private ArrayList<Finca> fincas;
    String[] datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista__finca);

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        singleton = Singleton.getInstance(getApplicationContext());
        FAB_Editar_Vista_Finca = (FloatingActionButton)findViewById(R.id.FAB_Editar_Vista_Finca);

        Bundle extras = getIntent().getExtras();
        final int Id_Finca = extras.getInt("_id");

        adminBaseDatos = new AdminBaseDatos(this);
        fincas = adminBaseDatos.listarFincas();

        TV_nombre_finca_vista = (TextView)findViewById(R.id.TV_nombre_finca_vista);
        TV_propietario_vista = (TextView)findViewById(R.id.TV_propietario_vista);
        TV_tamaño_vista = (TextView)findViewById(R.id.TV_tamaño_vista);
        TV_ubicacion_vista = (TextView)findViewById(R.id.TV_ubicacion_vista);
        TV_trabajadores_vista = (TextView)findViewById(R.id.TV_trabajadores_vista);
        TV_tipo_produccion = (TextView)findViewById(R.id.TV_tipo_produccion_vista);
        BT_ver_inventario = (Button)findViewById(R.id.BT_ver_inventario);

        //llama a la funcion que realiza el request
        cargarDatos(Id_Finca);

        FAB_Editar_Vista_Finca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarAgregarFinca(Id_Finca);
            }
        });

        BT_ver_inventario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarInventario(Id_Finca);
            }
        });
    }

    private void lanzarAgregarFinca(final int Id_Finca) {
        Intent intent = new Intent(this, AgregarFinca.class);
        intent.putExtra("_Id", Id_Finca);
        startActivity(intent);

    }

    public void cargarDatos(final int _id){

        StringRequest request = new StringRequest(Request.Method.POST, ListarURL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.v("Result", response);

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray fincas = jsonObject.getJSONArray("fincas");

                    for (int i = 0; i<fincas.length(); i++){

                        JSONObject finca = fincas.getJSONObject(i);

                        final int Id_Finca = finca.getInt("IDFINCA");
                        final String nombre_finca = finca.getString("NOMBRE_FINCA");
                        final String tamaño = finca.getString("TAMANO_HTS_");
                        final String Ubicacion = finca.getString("UBICACION_FINCA");
                        final String Tipo_Produccion = finca.getString("TIPO_PRODUCCION");
                        final String Saldo = finca.getString("SALDO_FINCA");

                        //coloca el resultado de la consulta en un TextView
                        TV_nombre_finca_vista.setText(String.valueOf(Id_Finca) + " " + nombre_finca +
                        " " + tamaño + " " + Ubicacion + " " + Tipo_Produccion + " " +
                        Tipo_Produccion + " " + Saldo + "\n");

                    }

                } catch (JSONException e) {
                    Log.e("ERROR JSON", e.getMessage(), e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ERROR", error.getMessage(), error);
            }
        });
        requestQueue.add(request);
    }

    public void lanzarInventario(final int Id_Finca){
        Intent intencion = new Intent(this, Inventario.class);
        intencion.putExtra("_id", Id_Finca);
        startActivity(intencion);
    }
}
