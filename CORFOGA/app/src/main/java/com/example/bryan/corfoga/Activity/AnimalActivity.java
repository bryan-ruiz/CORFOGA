package com.example.bryan.corfoga.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.bryan.corfoga.Class.Animal;
import com.example.bryan.corfoga.Adarter.AnimalAdapter;
import com.example.bryan.corfoga.R;

import java.util.ArrayList;

public class AnimalActivity extends AppCompatActivity {
    private ListView listView;
    private AnimalAdapter animalAdapter;
    private ArrayList<Animal> listItems;
    private Animal animal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        llenar();
        listView = (ListView) findViewById(R.id.listFarms);
        animalAdapter = new AnimalAdapter(listItems,this);
        listView.setAdapter(animalAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Animal selectedAnimal = (Animal) listView.getItemAtPosition(i);
                Intent intent = new Intent(getBaseContext(), InspectionActivity.class);
                startActivity(intent);
            }
        });
    }
    private void llenar() {
        int x = 0;
        listItems = new ArrayList<Animal>();
        while (x < 4) {
            animal = new Animal("a"+x,"a"+x,"a","a",1);
            x += 1;
            listItems.add(animal);
        }
    }
}
