package com.example.bryan.corfoga.Class;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bryan.corfoga.Database.DataBaseHelper;
import com.example.bryan.corfoga.Database.DataBaseContract;
import java.util.ArrayList;

/**
 * Created by Bryan on 26/02/2018.
 */

public class Animal {
    private String asocebuId;
    private String animalId;
    private String gender;
    private String birthdate;private ArrayList<Inspection> inspectionsList;

    public Animal(String asocebuId, String animalId, String gender, String birthdate) {
        this.asocebuId = asocebuId;
        this.animalId = animalId;
        this.gender = gender;
        this.birthdate = birthdate;
        this.inspectionsList = new ArrayList<Inspection>();
    }

    public String getAsocebuId() {
        return this.asocebuId;
    }

    public void setAsocebuId(String asocebuId) {
        this.asocebuId = asocebuId;
    }

    public String getAnimalId() {
        return this.animalId;
    }

    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthdate() {
        return this.birthdate;
    }

    public void setBirthDate(String birthdate) {
        this.birthdate = birthdate;
    }

    public long addInspectionDB(Context context, Inspection inspection) {
        // usar la clase DataBaseHelper para realizar la operacion de insertar
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        // Obtiene la base de datos en modo escritura
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
        // Crear un mapa de valores donde las columnas son las llaves
        ContentValues values = new ContentValues();
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_INSPECTION_ID, inspection.getInspectionId());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_ANIMAL_ID, this.getAnimalId());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_INSPECTION_WEIGHT, inspection.getWeight());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_INSPECTION_SCROTAL_CIRCUMFERENCE, inspection.getScrotalCircumference());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_INSPECTION_FEED_SYSTEM, inspection.getFeedSystem());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_INSPECTION_COMMENT, inspection.getComment());
        // Insertar la nueva fila
        return db.insert(DataBaseContract.DataBaseEntry.TABLE_NAME_INSPECTION, null, values);
    }

    public void addInspectionToExport() {

    }

    public ArrayList<Inspection> getInspectionListDB (Context context){
        this.inspectionsList = new ArrayList<Inspection>();
        Inspection inspection;
        String inspectionId, animalId, weight, scrotalCircumference, feedSystem, comment;
        // usar la clase DataBaseHelper para realizar la operacion de leer
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        // Obtiene la base de datos en modo lectura
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();
        // Define cuales columnas quiere solicitar // en este caso todas las de la clase
        String[] projection = {
                DataBaseContract.DataBaseEntry.COLUMN_NAME_INSPECTION_ID,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_ANIMAL_ID,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_INSPECTION_WEIGHT,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_INSPECTION_SCROTAL_CIRCUMFERENCE,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_INSPECTION_FEED_SYSTEM,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_INSPECTION_COMMENT
        };
        // Resultados en el cursor
        Cursor cursor = db.query(
                DataBaseContract.DataBaseEntry.TABLE_NAME_INSPECTION, // tabla
                projection, // columnas
                null, // where
                null, // valores del where
                null, // agrupamiento
                null, // filtros por grupo
                null // orden
        );
        do
        {
            animalId = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_ANIMAL_ID));
            if (animalId == this.getAnimalId()) {
                inspectionId = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_INSPECTION_ID));
                weight = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_INSPECTION_WEIGHT));
                scrotalCircumference = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_INSPECTION_SCROTAL_CIRCUMFERENCE));
                feedSystem = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_INSPECTION_FEED_SYSTEM));
                comment = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_INSPECTION_COMMENT));
                inspection = new Inspection(inspectionId,weight,scrotalCircumference,feedSystem,comment);
                this.inspectionsList.add(inspection);
            }
        }
        while (cursor.moveToNext());
        return this.inspectionsList;
    }
}
