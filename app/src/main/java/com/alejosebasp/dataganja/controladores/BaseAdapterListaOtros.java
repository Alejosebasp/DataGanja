package com.alejosebasp.dataganja.controladores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.alejosebasp.dataganja.R;
import com.alejosebasp.dataganja.modelos.Otro;

import java.util.ArrayList;

/**
 * Created by alejandrosebastian on 29/05/2016.
 */
public class BaseAdapterListaOtros extends BaseAdapter {

    private Context context;
    private ArrayList<Otro> otros;

    public BaseAdapterListaOtros(Context context, ArrayList<Otro> otros) {
        this.context = context;
        this.otros = otros;
    }

    public void setOtros(ArrayList<Otro> otros) {
        this.otros = otros;
    }

    static class ViewHolder{
        TextView TV_id_otro_vista;
        TextView TV_nombre_otro_vista;
        TextView TV_descripcion_otro_vista;
    }

    @Override
    public int getCount() {
        return otros.size();
    }

    @Override
    public Object getItem(int position) {
        return otros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.vista_lista_otros, null);
            viewHolder = new ViewHolder();

            viewHolder.TV_id_otro_vista = (TextView)convertView.findViewById(R.id.TV_id_otro_vista);
            viewHolder.TV_nombre_otro_vista = (TextView)convertView.findViewById(R.id.TV_nombre_otro_vista);
            viewHolder.TV_descripcion_otro_vista = (TextView)convertView.findViewById(R.id.TV_descripcion_otro_vista);

            convertView.setTag(viewHolder);
        }
        else viewHolder = (ViewHolder)convertView.getTag();

        Otro otro = otros.get(position);
        String id = "Id del articulo: " + otro.getId_otro();
        String nombre = "Nombre del articulo: " + otro.getNombre();
        String descripcion = "Descripcion del articulo: " + otro.getDescripcion();

        viewHolder.TV_id_otro_vista.setText(id);
        viewHolder.TV_nombre_otro_vista.setText(nombre);
        viewHolder.TV_descripcion_otro_vista.setText(descripcion);

        return convertView;
    }
}
