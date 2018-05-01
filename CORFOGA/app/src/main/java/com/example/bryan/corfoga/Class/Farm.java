package com.example.bryan.corfoga.Class;

import com.example.bryan.corfoga.Database.DataBaseHelper;
import com.example.bryan.corfoga.Database.DataBaseContract;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Farm {
    private String idFarm;
    private String name;
    private ArrayList<Animal> animalsList;

    public Farm(String id,String name) {
        this.idFarm = id;
        this.name = name;
        this.animalsList = new ArrayList<Animal>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdFarm() {
        return this.idFarm;
    }

    public void setIdFarm(String idFarm) {
        this.idFarm = idFarm;
    }

    public ArrayList<Animal> getAnimalsList() {
        return this.animalsList;
    }

    public void setAnimalsList(ArrayList<Animal> animalsList) {
        this.animalsList = animalsList;
    }

    public long addAnimalDB(Context context, Animal animal) {
        // usar la clase DataBaseHelper para realizar la operacion de insertar
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        // Obtiene la base de datos en modo escritura
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
        // Crear un mapa de valores donde las columnas son las llaves
        ContentValues values = new ContentValues();
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_ANIMAL_ID, animal.getAnimalId());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_FARM_ID, this.getIdFarm());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_ANIMAL_ASOCEBU_ID, animal.getAsocebuId());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_ANIMAL_BIRTHDATE, animal.getBirthdate());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_ANIMAL_GENDER, animal.getGender());
        // Insertar la nueva fila
        return db.insert(DataBaseContract.DataBaseEntry.TABLE_NAME_ANIMAL, null, values);
    }

    public ArrayList<Animal> getAnimalListDB (Context context){
        this.animalsList = new ArrayList<Animal>();
        Animal animal;
        String animalId, farmId, asocebuId, birthdate, gender;
        // usar la clase DataBaseHelper para realizar la operacion de leer
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        // Obtiene la base de datos en modo lectura
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();
        // Define cuales columnas quiere solicitar // en este caso todas las de la clase
        String[] projection = {
                DataBaseContract.DataBaseEntry.COLUMN_NAME_ANIMAL_ID,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_FARM_ID,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_ANIMAL_ASOCEBU_ID,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_ANIMAL_BIRTHDATE,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_ANIMAL_GENDER
        };
        // Resultados en el cursor
        Cursor cursor = db.query(
                DataBaseContract.DataBaseEntry.TABLE_NAME_ANIMAL, // tabla
                projection, // columnas
                null, // where
                null, // valores del where
                null, // agrupamiento
                null, // filtros por grupo
                null // orden
        );
        do
        {
            farmId = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_FARM_ID));
            if (farmId == this.getIdFarm()) {
                animalId = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_ANIMAL_ID));
                asocebuId = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_ANIMAL_ASOCEBU_ID));
                birthdate = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_ANIMAL_BIRTHDATE));
                gender = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_ANIMAL_GENDER));
                animal = new Animal(asocebuId,animalId, gender, birthdate);
                this.animalsList.add(animal);
            }
        }
        while (cursor.moveToNext());
        return this.animalsList;
    }
}
