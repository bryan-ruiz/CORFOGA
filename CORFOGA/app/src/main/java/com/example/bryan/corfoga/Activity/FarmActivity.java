package com.example.bryan.corfoga.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bryan.corfoga.Class.Animal;
import com.example.bryan.corfoga.Class.Farm;
import com.example.bryan.corfoga.Adarter.FarmAdapter;
import com.example.bryan.corfoga.Class.Global;
import com.example.bryan.corfoga.R;

import java.util.ArrayList;
import java.util.List;

public class FarmActivity extends AppCompatActivity {
    private ListView listView;
    private FarmAdapter farmAdapter;
    private ArrayList<Farm> listItems;
    private Farm farm;
    private EditText buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farms);
        buscar = (EditText) findViewById(R.id.buscarF);
        listView = (ListView) findViewById(R.id.listFarms);
        llenar();
        mostrarLista();
        String param = (String) getIntent().getExtras().getString("selectedRegion");
        buscar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().equals("")){
                    llenar();
                    mostrarLista();
                }
                else{
                    //Hacer la busqueda
                    buscarFarm(charSequence.toString());
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
    private void llenar() {
        listItems = cloneList(Global.getInstance().getFarmsList());
    }
    private void buscarFarm(String busqueda){

        for(Farm fa : listItems ){
            if(!(fa.getName()+"").contains(busqueda)){
                listItems.remove(fa);
            }
        }
        farmAdapter.notifyDataSetChanged();

    }
    private void mostrarLista(){
        farmAdapter = new FarmAdapter(listItems,this);
        listView.setAdapter(farmAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Farm selectedFarm = (Farm) listView.getItemAtPosition(i);
                Global.getInstance().setAnimalsList(selectedFarm.getAnimalListDB(getApplication()));
                if (Global.getInstance().getAnimalsList().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"¡No hay animales disponibles!",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(getBaseContext(), AlertInspectionNumber.class);
                    startActivity(intent);
                }
            }
        });
    }

    public static ArrayList<Farm> cloneList(List<Farm> listaAnim) {
        ArrayList<Farm> clonedList = new ArrayList<Farm>(listaAnim.size());
        for (Farm f : listaAnim) {
            clonedList.add(new Farm(f));
        }
        return clonedList;
    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_buscador_fincas, menu);
        return true;
    }*/
}
