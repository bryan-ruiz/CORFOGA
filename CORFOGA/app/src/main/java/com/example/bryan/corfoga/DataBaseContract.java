package com.example.bryan.corfoga;
import android.provider.BaseColumns;

/**
 * Created by Bryan on 20/02/2018.
 */

public class DataBaseContract {
    // Implementa la interfaz BaseColumns para heredar campos estandar del marco de Android _ID
    public static class DataBaseEntry implements BaseColumns {
        public static final String TABLE_NAME_FARM = "Farm";
        public static final String COLUMN_NAME_FARM_ID = "farmId";
        public static final String COLUMN_NAME_FARM_NAME_ = "name";

        public static final String TABLE_NAME_ANIMAL = "Animal";
        public static final String COLUMN_NAME_ANIMAL_ASOCEBU_ID= "asocebuId";
        public static final String COLUMN_NAME_ANIMAL_ID = "animalId";
        public static final String COLUMN_NAME_ANIMAL_GENDER = "gender";
        public static final String COLUMN_NAME_ANIMAL_BIRTHDATE = "birthdate";
        public static final String COLUMN_NAME_ANIMAL_STATE = "state";

        public static final String TABLE_NAME_INSPECTION = "Inspection";
        public static final String COLUMN_NAME_INSPECTION_ID = "inspectionId";
        public static final String COLUMN_NAME_INSPECTION_WEIGHT = "weight";
        public static final String COLUMN_NAME_INSPECTION_SCROTAL_CIRCUMFERENCE = "scrotalCircumference";
        public static final String COLUMN_NAME_INSPECTION_FEED_SYSTEM = "feedSystem";
        public static final String COLUMN_NAME_INSPECTION_COMMENT = "comment";
    }

    // Construir las tablas de la base de datos
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";

    // Creacion de tablas
    public static final String SQL_CREATE_FARM =
            "CREATE TABLE " + DataBaseEntry.TABLE_NAME_FARM + " (" +
                    DataBaseEntry.COLUMN_NAME_FARM_ID + TEXT_TYPE + "PRIMARY KEY" + COMMA_SEP +
                    DataBaseEntry.COLUMN_NAME_FARM_NAME_ + TEXT_TYPE +")";

    public static final String SQL_DELETE_FARM =
            "DROP TABLE IF EXISTS " + DataBaseEntry.TABLE_NAME_FARM;

    public static final String SQL_CREATE_ANIMAL =
            "CREATE TABLE " + DataBaseEntry.TABLE_NAME_ANIMAL + " (" +
                    DataBaseEntry.COLUMN_NAME_ANIMAL_ID + TEXT_TYPE + "PRIMARY KEY" + COMMA_SEP +
                    DataBaseEntry.COLUMN_NAME_FARM_ID + TEXT_TYPE + "FOREIGN KEY" + COMMA_SEP +
                    DataBaseEntry.COLUMN_NAME_ANIMAL_ASOCEBU_ID + TEXT_TYPE + COMMA_SEP +
                    DataBaseEntry.COLUMN_NAME_ANIMAL_BIRTHDATE + TEXT_TYPE + COMMA_SEP +
                    DataBaseEntry.COLUMN_NAME_ANIMAL_STATE + INTEGER_TYPE + COMMA_SEP +
                    DataBaseEntry.COLUMN_NAME_ANIMAL_GENDER + TEXT_TYPE +")";
    public static final String SQL_DELETE_ANIMAL =
            "DROP TABLE IF EXISTS " + DataBaseEntry.TABLE_NAME_ANIMAL;

    public static final String SQL_CREATE_INSPECTION =
            "CREATE TABLE " + DataBaseEntry.TABLE_NAME_INSPECTION + " (" +
                    DataBaseEntry.COLUMN_NAME_INSPECTION_ID + TEXT_TYPE + "PRIMARY KEY" + COMMA_SEP +
                    DataBaseEntry.COLUMN_NAME_ANIMAL_ID + TEXT_TYPE + "FOREIGN KEY" + COMMA_SEP +
                    DataBaseEntry.COLUMN_NAME_INSPECTION_WEIGHT + TEXT_TYPE + COMMA_SEP +
                    DataBaseEntry.COLUMN_NAME_INSPECTION_SCROTAL_CIRCUMFERENCE + TEXT_TYPE + COMMA_SEP +
                    DataBaseEntry.COLUMN_NAME_INSPECTION_FEED_SYSTEM + TEXT_TYPE + COMMA_SEP +
                    DataBaseEntry.COLUMN_NAME_INSPECTION_COMMENT + TEXT_TYPE + ")";

    public static final String SQL_DELETE_INSPECTION  =
            "DROP TABLE IF EXISTS " + DataBaseEntry.TABLE_NAME_INSPECTION;
}