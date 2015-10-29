package com.puche.juegomaterial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/**
 * Created by Raimundo Puche on 19/10/2015.
 */
public class Funciones {

    protected SQLiteDatabase db;
    protected PuntajeDbHelper dbHelper;

    public void Crear(Context context, String scoreid, String nombre, Integer score){
        dbHelper = new PuntajeDbHelper(context);
        db = dbHelper.getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put(Puntaje.puntajeEntry.COLUMN_NAME_ENTRY_ID, scoreid);
        content.put(Puntaje.puntajeEntry.COLUMN_NAME_FIRST_NAME, nombre);
        content.put(Puntaje.puntajeEntry.COLUMN_SCORE, score);

        db.insert(Puntaje.puntajeEntry.TABLE_NAME, null, content);
        db.close();
    }

    public Cursor Mostrar (Context context){
        dbHelper = new PuntajeDbHelper(context);
        db = dbHelper.getWritableDatabase();

        String val [] = {Puntaje.puntajeEntry.COLUMN_NAME_ENTRY_ID, Puntaje.puntajeEntry.COLUMN_NAME_FIRST_NAME, Puntaje.puntajeEntry.COLUMN_SCORE};
        Cursor c = db.query(Puntaje.puntajeEntry.TABLE_NAME, val, null, null, null, null, null);

        return c;
    }



}
