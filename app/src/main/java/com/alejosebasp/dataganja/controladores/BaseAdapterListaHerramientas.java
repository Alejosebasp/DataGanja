package com.alejosebasp.dataganja.controladores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.alejosebasp.dataganja.R;
import com.alejosebasp.dataganja.modelos.Herramienta;

import java.util.ArrayList;

/**
 * Created by alejandrosebastian on 29/05/2016.
 */
public class BaseAdapterListaHerramientas extends BaseAdapter {

    private Context context;
    private ArrayList<Herramienta> herramientas;

    public BaseAdapterListaHerramientas(Context context, ArrayList<Herramienta> herramientas) {
        this.context = context;
        this.herramientas = herramientas;
    }

    static class ViewHolder {
        TextView TV_nombre_herramienta_lista;
        TextView TV_id_herramienta_lista;
    }

    public void setHerramientas(ArrayList<Herramienta> herramientas) {
        this.herramientas = herramientas;
    }

    @Override
    public int getCount() {
        return herramientas.size();
    }

    @Override
    public Object getItem(int position) {
        return herramientas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.vista_lista_herramientas, null);
            viewHolder = new ViewHolder();

            viewHolder.TV_id_herramienta_lista = (TextView)convertView.findViewById(R.id.TV_id_herramienta_lista);
            viewHolder.TV_nombre_herramienta_lista = (TextView)convertView.findViewById(R.id.TV_nombre_herramienta_lista);

            convertView.setTag(viewHolder);
        }
        else viewHolder = (ViewHolder)convertView.getTag();

        Herramienta herramienta = herramientas.get(position);

        String nombre = "Nombre de la herramienta: " + herramienta.getNombre_Herramienta();
        String id = "Id: " + herramienta.getId_Herramienta();

        viewHolder.TV_nombre_herramienta_lista.setText(nombre);
        viewHolder.TV_id_herramienta_lista.setText(id);

        return convertView;
    }
}
