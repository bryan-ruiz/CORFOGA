package com.example.bryan.corfoga.Adarter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bryan.corfoga.Class.Animal;
import com.example.bryan.corfoga.R;

import java.util.ArrayList;

public class AnimalAdapter extends BaseAdapter {
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
        TextView textView = (TextView) view.findViewById(R.id.itemsIdAnimal);
        TextView textView2 = (TextView) view.findViewById(R.id.itemsIdAsocebu);
        textView.setText(animal.getAnimalId());
        textView2.setText(animal.getAsocebuId());
        return view;
    }
}
