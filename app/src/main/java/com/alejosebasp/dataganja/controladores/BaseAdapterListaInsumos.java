package com.alejosebasp.dataganja.controladores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.alejosebasp.dataganja.R;
import com.alejosebasp.dataganja.modelos.Insumo;

import java.util.ArrayList;

/**
 * Created by alejandrosebastian on 29/05/2016.
 */
public class BaseAdapterListaInsumos { //extends BaseAdapter {
/*
    private Context context;
    private ArrayList<Insumo> insumos;

    public BaseAdapterListaInsumos(Context context, ArrayList<Insumo> insumos) {
        this.context = context;
        this.insumos = insumos;
    }

    static class ViewHolder{
        TextView TV_nombre_insumos_lista;
        TextView TV_tipo_insumo_lista;
        TextView TV_catidad_insumos_lista;
        TextView TV_id_insumos_lista;
    }

    @Override
    public int getCount() {
        return insumos.size();
    }

    @Override
    public Object getItem(int position) {
        return insumos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.vista_lista_insumos, null);
            viewHolder = new ViewHolder();

            viewHolder.TV_catidad_insumos_lista = (TextView)convertView.findViewById(R.id.TV_cantidad_insumos_lista);
            viewHolder.TV_id_insumos_lista = (TextView)convertView.findViewById(R.id.TV_id_insumos_lista);
            viewHolder.TV_tipo_insumo_lista = (TextView)convertView.findViewById(R.id.TV_tipoInsumo_lista);
            viewHolder.TV_nombre_insumos_lista = (TextView)convertView.findViewById(R.id.TV_nombre_insumos_lista);

            convertView.setTag(viewHolder);
        }
        else viewHolder = (ViewHolder)convertView.getTag();

        Insumo insumo = insumos.get(position);
        String cantidad = "Cantidad del insumo: " + insumo.getCantidad();
        String id = "Id: " + insumo.getId();
        String tipoInsumo = "Tipo de insumo: " + insumo.getTipo_Insumo();
        String nombreInsumo = "Nombre del insumo: " + insumo.getNombre_Insumo();

        viewHolder.TV_nombre_insumos_lista.setText(nombreInsumo);
        viewHolder.TV_tipo_insumo_lista.setText(tipoInsumo);
        viewHolder.TV_id_insumos_lista.setText(id);
        viewHolder.TV_catidad_insumos_lista.setText(cantidad);

        return convertView;
    }

    public void setInsumos(ArrayList<Insumo> insumos) {
        this.insumos = insumos;
    }*/
}
