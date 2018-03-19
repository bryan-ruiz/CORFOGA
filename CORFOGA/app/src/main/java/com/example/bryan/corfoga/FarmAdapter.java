package com.example.bryan.corfoga;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Bryan on 12/03/2018.
 */

public class FarmAdapter extends BaseAdapter {
    private ArrayList<Farm> listItems;
    private Context context;

    public FarmAdapter(ArrayList<Farm> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.listItems.size();
    }

    @Override
    public Farm getItem(int i) {
        return this.listItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Farm farm = getItem(i);
        view = LayoutInflater.from(this.context).inflate(R.layout.item_farm, null);
        TextView textView = (TextView) view.findViewById(R.id.farmName);
        textView.setText(farm.getName());
        return view;
    }
}
