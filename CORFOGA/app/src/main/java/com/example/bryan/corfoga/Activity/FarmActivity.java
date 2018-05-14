package com.example.bryan.corfoga.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bryan.corfoga.Class.Animal;
import com.example.bryan.corfoga.Class.Farm;
import com.example.bryan.corfoga.Adarter.FarmAdapter;
import com.example.bryan.corfoga.Class.Global;
import com.example.bryan.corfoga.R;

import java.util.ArrayList;

public class FarmActivity extends AppCompatActivity {
    private ListView listView;
    private FarmAdapter farmAdapter;
    private ArrayList<Farm> listItems;
    private Farm farm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farms);
        llenar();
        listView = (ListView) findViewById(R.id.listFarms);
        farmAdapter = new FarmAdapter(listItems,this);
        listView.setAdapter(farmAdapter);
        String param = (String) getIntent().getExtras().getString("selectedRegion");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Farm selectedFarm = (Farm) listView.getItemAtPosition(i);
                Global.getInstance().setAnimalsList(selectedFarm.getAnimalListDB(getApplication()));
                if (Global.getInstance().getAnimalsList().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"¡No hay animales disponibles!",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(getBaseContext(), AnimalActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
    private void llenar() {
        int x = 0;
        listItems = Global.getInstance().getFarmsList();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_buscador_fincas, menu);
        return true;
    }
}
