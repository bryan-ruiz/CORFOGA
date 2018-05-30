package com.example.bryan.corfoga.Adarter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;


import com.example.bryan.corfoga.Class.Animal;
import com.example.bryan.corfoga.Class.Global;
import com.example.bryan.corfoga.Class.Inspection;
import com.example.bryan.corfoga.R;

import java.util.ArrayList;

public class AnimalAdapter extends BaseAdapter{
    private ArrayList<Animal> listItems;
    private Context context;


    public AnimalAdapter(ArrayList<Animal> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;

    }

    @Override
    public int getCount() {
        return this.listItems.size();
    }

    @Override
    public Animal getItem(int i) {
        return this.listItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Animal animal = getItem(i);
        view = LayoutInflater.from(this.context).inflate(R.layout.listview_item_row_animal, null);
        TextView idAnimal = (TextView) view.findViewById(R.id.itemsIdAnimal);
        TextView idFarm = (TextView) view.findViewById(R.id.itemsIdAsocebu);
        idAnimal.setText(String.valueOf(animal.getId()));
        idFarm.setText(String.valueOf(animal.getAsocebuFarmID()));

        //Todo si no funciona es porque no se esta obteniendo realmente la ultima inspeccion, entonces si no funciona, comprobarlo con la fecha de la inspeccion y ahi si traerse la inspeccion mas reciente.
        Inspection ultimaInspeccion = animal.getInspectionListDB(this.context).get(animal.getInspectionsList().size() - 1);
        //Inspection ultimaInspeccion = Global.getInstance().getAnimal().getInspectionListDB(this.context).get((Global.getInstance().getAnimal().getInspectionListDB(this.context).size())-1);

        //Toast.makeText(context, ultimaInspeccion.getStatusID() , Toast.LENGTH_LONG).show();
        if(ultimaInspeccion.getStatusID()=="Vivo"){
            //TODO si no funciona este color es por this.context ↓  , tambien se puede quemar el color con: Color.parseColor(“#ffffff”)
            view.setBackgroundColor(this.context.getResources().getColor(R.color.complete));

        }
        if(ultimaInspeccion.getStatusID()=="MuertoComercializado"){
            view.setBackgroundColor(this.context.getResources().getColor(R.color.deadMarket));

        }
        if(ultimaInspeccion.getStatusID()=="Externa"){
            view.setBackgroundColor(this.context.getResources().getColor(R.color.externalSituation));

        }













        return view;
    }
}
