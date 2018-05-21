package com.example.bryan.corfoga.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.bryan.corfoga.Class.Animal;
import com.example.bryan.corfoga.Class.Global;
import com.example.bryan.corfoga.Class.Inspection;
import com.example.bryan.corfoga.R;

import java.util.Calendar;

public class InspectionActivity extends AppCompatActivity {
    Animal animal;
    Spinner spinner;
    String spinnerItemSelected;
    TextView register, code, gender, birthdate, weight, scrotalCircumference, comments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspection);
        register = (TextView) findViewById(R.id.register);
        code = (TextView) findViewById(R.id.code);
        gender = (TextView) findViewById(R.id.gender);
        birthdate = (TextView) findViewById(R.id.birthdate);
        weight = (TextView) findViewById(R.id.txtPeso);
        scrotalCircumference = (TextView) findViewById(R.id.txtCE);
        comments = (MultiAutoCompleteTextView) findViewById(R.id.txtObservaciones);
        animal = Global.getInstance().getAnimal();
        register.setText(String.valueOf(animal.getRegister()));
        code.setText(String.valueOf(animal.getCode()));
        gender.setText(String.valueOf(animal.getSex()));
        birthdate.setText(String.valueOf(animal.getBirthdate()));
        spinner = (Spinner) findViewById(R.id.spinAlimentacion);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_item_save:
                String weightTotal = weight.getText().toString();
                if (Integer.parseInt(weightTotal) >= 150 && Integer.parseInt(weightTotal) <= 999) {
                    int id = Global.getInstance().getInspectionId() -1;
                    Global.getInstance().setInspectionId(id);
                    int asocebuFarmID = animal.getAsocebuFarmID();
                    int userID = Global.getInstance().getUser().getIdUsuario();
                    String datetime = Calendar.getInstance().getTime().toString();
                    int visitNumber = Global.getInstance().getVisitNumber();
                    int animalID = animal.getId();
                    spinnerItemSelected = spinner.getSelectedItem().toString();
                    int feedingMethodID;
                    if (spinnerItemSelected.equals("1.Pastoreo")) {
                        feedingMethodID = 1;
                    } else if (spinnerItemSelected.equals("2.Semi Estabulación")) {
                        feedingMethodID = 2;
                    } else if (spinnerItemSelected.equals("3.Estabulación")) {
                        feedingMethodID = 3;
                    } else {
                        feedingMethodID = 4;
                    }
                    String scrotalC = scrotalCircumference.getText().toString();
                    String observations = comments.getText().toString();
                    //int id, int asocebuFarmID, int userID, String datetime, int visitNumber, int animalID, int feedingMethodID, String weight, String scrotalCircumference, String observations) {
                    Inspection inspection = new Inspection(id, asocebuFarmID, userID, datetime, visitNumber, animalID, feedingMethodID, weightTotal, scrotalC, observations);
                    Global.getInstance().getAnimal().addInspectionDB(getApplicationContext(), inspection);
                    Toast.makeText(getApplicationContext(), "¡Datos guardados correctamente, no olvide exportar los datos (vista regiones)!", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "¡Peso no válido!", Toast.LENGTH_LONG).show();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

