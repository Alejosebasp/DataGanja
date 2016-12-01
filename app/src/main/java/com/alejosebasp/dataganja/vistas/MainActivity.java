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
import com.alejosebasp.dataganja.controladores.Singleton;
import com.alejosebasp.dataganja.modelos.Finca;
import com.alejosebasp.dataganja.util.Constants;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity{


    private ListView LV_lista_fincas;

    private AdminBaseDatos adminBaseDatos;
    ArrayList<Finca> Listafincas = new ArrayList<>();
    private BaseAdapterListaFincas adapter;
    private FloatingActionButton FAB_AgregarFinca_Main;
    private int g = 0;
    private String ListarURL = Constants.IP + "App_ProFarm/ListarFinca.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adminBaseDatos = new AdminBaseDatos(this);
        listarFincas();

        LV_lista_fincas = (ListView)findViewById(R.id.LV_lista_fincas);
        FAB_AgregarFinca_Main = (FloatingActionButton)findViewById(R.id.FAB_AgregarFinca_Main);


       /*if (g == 0) {
            if (Listafincas.isEmpty()) {
                lanzarAgregarFinca();
                g++;
            }
        }*/
        //else {

            adapter = new BaseAdapterListaFincas(getBaseContext(), Listafincas);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    LV_lista_fincas.setAdapter(adapter);
                }
            }).start();
            updateLista(adapter);
           //g=0;
        //}

        LV_lista_fincas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Finca finca = Listafincas.get(position);
                        int _id = finca.get_id();
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

        listarFincas();
        adapter.setFincas(Listafincas);
        adapter.notifyDataSetChanged();
    }

    public void listarFincas(){

        StringRequest request = new StringRequest(Request.Method.POST, ListarURL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.v("Result", response);

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String result = jsonObject.getString("result");

                    if (result.equals("DONE")){

                        JSONArray fincas = jsonObject.getJSONArray("fincas");

                        for (int i = 0; i<fincas.length(); i++){

                            JSONObject finca = fincas.getJSONObject(i);

                            final int Id_Finca = finca.getInt("Id_Finca");
                            final String nombre_finca = finca.getString("Nombre_Finca");
                            final double tamaño = finca.getDouble("Tamano_HTS_");
                            final String Ubicacion = finca.getString("Ubicacion_Finca");
                            final String Tipo_Produccion = finca.getString("Tipo_Produccion");
                            final Double Saldo = finca.getDouble("Saldo_Finca");

                            Finca f = new Finca(Id_Finca, tamaño, nombre_finca, Ubicacion, Tipo_Produccion, Saldo);
                            Listafincas.add(f);
                            Log.v("finca_log", finca.toString());
                        }
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
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("ID_FINCA", "1");
                return params;
            }
        };

        request.setRetryPolicy(new DefaultRetryPolicy(
                3000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        Singleton.getInstance(MainActivity.this).addToRequestQueue(request);
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