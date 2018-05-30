package com.example.bryan.corfoga.Database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    // debemos incrementar la version de la base de datos
    public static final int DATABASE_VERSION = 2;
    // Nombre de la base de datos
    public static final String DATABASE_NAME = "AndroidStorage.db";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public Boolean deleteDB(Context context) {
        boolean bool = context.deleteDatabase(DATABASE_NAME);
        return bool; // true if deleted;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear la base de datos de la app
        db.execSQL(DataBaseContract.SQL_CREATE_USER);
        db.execSQL(DataBaseContract.SQL_CREATE_FARM);
        db.execSQL(DataBaseContract.SQL_CREATE_ANIMAL);
        db.execSQL(DataBaseContract.SQL_CREATE_INSPECTION);


        //ToDo datos quemados
        //Datos quemados de prueba:
        //FARM

        String sqlf = "INSERT or replace INTO Farm (asocebuID, userID, name ,state , region, created_at, updated_at)" +
                " VALUES('1','2','papa','1','Región Chorotega','5435','5345')" ;
        db.execSQL(sqlf);

        String sqlf2 = "INSERT or replace INTO Farm (asocebuID, userID, name ,state , region, created_at, updated_at)" +
                " VALUES('1','2','hola','1','Región Chorotega','5435','5345')" ;
        db.execSQL(sqlf2);

        //Animales
        String sql = "INSERT or replace INTO Animal (id, asocebuFarmID, register, code ,sex , birthdate, fatherRegister, fatherCode,motherRegister ,motherCode )" +
                " VALUES('1','1','register','1','M','hoy','papa','2','mama','3')" ;

        db.execSQL(sql);
        String sql2 = "INSERT or replace INTO Animal (id, asocebuFarmID, register, code ,sex , birthdate, fatherRegister, fatherCode,motherRegister ,motherCode )" +
                " VALUES('2','1','register','1','M','hoy','papa','2','mama','3')" ;

        db.execSQL(sql2);

        //Inspecciones

        String sqli = "INSERT or replace INTO Inspection (id, asocebuFarmID, userID, datetime ,visitNumber , animalID, feedingMethodID, weight,scrotalCircumference,observations,state)" +
                " VALUES('1','1','2','656','1','1','Pastoreo','150','21','rertrtrt','1.Vivo')" ;
        db.execSQL(sqli);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DataBaseContract.SQL_DELETE_INSPECTION);
        db.execSQL(DataBaseContract.SQL_DELETE_ANIMAL);
        db.execSQL(DataBaseContract.SQL_DELETE_FARM);
        db.execSQL(DataBaseContract.SQL_DELETE_USER);
    }
}
