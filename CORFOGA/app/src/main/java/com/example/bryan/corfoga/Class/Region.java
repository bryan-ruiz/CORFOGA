package com.example.bryan.corfoga.Class;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bryan.corfoga.Database.DataBaseHelper;
import com.example.bryan.corfoga.Database.DataBaseContract;
import java.util.ArrayList;

/**
 * Created by Bryan on 29/04/2018.
 */

public class Region {
    private String name;
    private ArrayList<Farm> farmsList;

    public Region(String name) {
        this.name = name;
        this.farmsList = new ArrayList<Farm>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Farm> getFarmsList() {
        return this.farmsList;
    }

    public void setFarmsList(ArrayList<Farm> farmsList) {
        this.farmsList = farmsList;
    }

    public long addFarmDB(Context context, Farm farm) {
        // usar la clase DataBaseHelper para realizar la operacion de insertar
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        // Obtiene la base de datos en modo escritura
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
        // Crear un mapa de valores donde las columnas son las llaves
        ContentValues values = new ContentValues();
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_FARM_ID, farm.getIdFarm());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_REGION_NAME, this.name);
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_FARM_NAME, farm.getName());
        // Insertar la nueva fila
        return db.insert(DataBaseContract.DataBaseEntry.TABLE_NAME_FARM, null, values);
    }

    public ArrayList<Farm> getFarmListDB (Context context){
        this.farmsList = new ArrayList<Farm>();
        Farm farm;
        String id, region, name;
        // usar la clase DataBaseHelper para realizar la operacion de leer
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        // Obtiene la base de datos en modo lectura
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();
        // Define cuales columnas quiere solicitar // en este caso todas las de la clase
        String[] projection = {
                DataBaseContract.DataBaseEntry.COLUMN_NAME_FARM_ID,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_REGION_NAME,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_FARM_NAME
        };
        // Resultados en el cursor
        Cursor cursor = db.query(
                DataBaseContract.DataBaseEntry.TABLE_NAME_FARM, // tabla
                projection, // columnas
                null, // where
                null, // valores del where
                null, // agrupamiento
                null, // filtros por grupo
                null // orden
        );
        do
        {
            region = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_REGION_NAME));
            if (region == this.getName()) {
                id = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_FARM_ID));
                name = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_FARM_NAME));
                farm = new Farm(id, name);
                this.farmsList.add(farm);
            }
        }
        while (cursor.moveToNext());
        return this.farmsList;
    }
}
