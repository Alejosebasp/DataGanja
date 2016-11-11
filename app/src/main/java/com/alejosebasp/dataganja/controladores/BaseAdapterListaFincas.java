package com.alejosebasp.dataganja.controladores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.alejosebasp.dataganja.R;
import com.alejosebasp.dataganja.modelos.Finca;

import java.util.ArrayList;

/**
 * Created by alejandrosebastian on 26/05/2016.
 */
public class BaseAdapterListaFincas extends BaseAdapter{

    private Context context;
    private ArrayList<Finca> fincas;

    public BaseAdapterListaFincas(Context context, ArrayList<Finca> fincas) {

        this.context = context;
        this.fincas = fincas;
    }

    static class ViewHolder{
        TextView TV_nombre_finca;
        TextView TV_nombre_propietario;
        TextView TV_ubicacion;
    }

    @Override
    public int getCount() {
        return fincas.size();
    }

    @Override
    public Object getItem(int position) {
        return fincas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.vista_lista_fincas, null);
            viewHolder = new ViewHolder();

            viewHolder.TV_nombre_finca = (TextView)convertView.findViewById(R.id.TV_nombre_finca);
            viewHolder.TV_nombre_propietario = (TextView)convertView.findViewById(R.id.TV_nombre_propietario);
            viewHolder.TV_ubicacion = (TextView)convertView.findViewById(R.id.TV_ubicacion);

            convertView.setTag(viewHolder);
        }
        else viewHolder = (ViewHolder)convertView.getTag();

        Finca finca = fincas.get(position);
        String nombre_finca = "Nombre finca: "+finca.getNombre_finca();
        String nombre_propietario = "Nombre propietario: " + finca.getNombre_propietario();
        String ubicacion = "Ubicacion: " + finca.getUbicacion();

        viewHolder.TV_nombre_finca.setText(nombre_finca);
        viewHolder.TV_nombre_propietario.setText(nombre_propietario);
        viewHolder.TV_ubicacion.setText(ubicacion);

        return convertView;
    }

    public void setFincas(ArrayList<Finca> fincas) {
        this.fincas = fincas;
    }
}
