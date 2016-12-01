package com.alejosebasp.dataganja.controladores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.alejosebasp.dataganja.R;
import com.alejosebasp.dataganja.modelos.Animal;

import java.util.ArrayList;

/**
 * Created by alejandrosebastian on 27/05/2016.
 */
public class BaseAdapterListaAnimales extends BaseAdapter {

    private Context context;
    private ArrayList<Animal> animals;

    public BaseAdapterListaAnimales(Context context, ArrayList<Animal> animals) {
        this.context = context;
        this.animals = animals;
    }

    static class ViewHolder {
        TextView TV_id_animales_lista;
        TextView TV_especie_animales_lista;
        TextView TV_raza_animales_lista;
        TextView TV_edad_animales_lista;
        TextView TV_peso_animales_lista;
        TextView TV_sexo_animales_lista;
        TextView TV_proposito_animales_lista;
        TextView TV_etapaProductiva_animales_lista;
        TextView TV_dieta_animales_lista;
    }

    @Override
    public int getCount() {
        return animals.size();
    }

    @Override
    public Object getItem(int position) {
        return animals.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.vista_lista_animales, null);
            viewHolder = new ViewHolder();

            viewHolder.TV_dieta_animales_lista = (TextView)convertView.findViewById(R.id.TV_dieta_animales_lista);
            viewHolder.TV_edad_animales_lista = (TextView)convertView.findViewById(R.id.TV_edad_animales_lista);
            viewHolder.TV_especie_animales_lista = (TextView)convertView.findViewById(R.id.TV_especie_animales_lista);
            viewHolder.TV_id_animales_lista = (TextView)convertView.findViewById(R.id.TV_id_animales_lista);
            viewHolder.TV_peso_animales_lista = (TextView)convertView.findViewById(R.id.TV_peso_animales_lista);
            viewHolder.TV_raza_animales_lista = (TextView)convertView.findViewById(R.id.TV_raza_animales_lista);
            viewHolder.TV_sexo_animales_lista = (TextView)convertView.findViewById(R.id.TV_sexo_animales_lista);

            convertView.setTag(viewHolder);
        }
        else viewHolder = (ViewHolder)convertView.getTag();

        Animal animal = animals.get(position);

        String sexo, especie, raza, etapa_productiva, proposito, dieta, id, edad, peso;
        sexo = "Sexo: " + animal.getSexo();
        especie = "Especie: " + animal.getEspecie();
        raza = "Raza: " + animal.getRaza();
        etapa_productiva = "Etapa productiva: " + animal.getEtapa_productiva();
        proposito = "Proposito: " + animal.getProposito();
        dieta = "Dieta: " + animal.getDieta();
        id = "Id: " + animal.getId();
        edad = "Edad (meses): " + animal.getEdad();
        peso = "Peso: " + animal.getPeso();

        viewHolder.TV_id_animales_lista.setText(id);
        viewHolder.TV_sexo_animales_lista.setText(sexo);
        viewHolder.TV_raza_animales_lista.setText(raza);
        viewHolder.TV_edad_animales_lista.setText(edad);
        viewHolder.TV_dieta_animales_lista.setText(dieta);
        viewHolder.TV_proposito_animales_lista.setText(proposito);
        viewHolder.TV_etapaProductiva_animales_lista.setText(etapa_productiva);
        viewHolder.TV_especie_animales_lista.setText(especie);
        viewHolder.TV_peso_animales_lista.setText(peso);

        return convertView;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }
}
