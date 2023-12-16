package com.miempresa.appcolegiodb.DAO

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(contexto: Context): SQLiteOpenHelper(contexto, "BDCOLEGIO", null, 1)
{
    //varialbes
    var tabla_curso = "create table curso(codcur interger primary key,)"+"nomcur text, nhoras interger, precio real);"
    //variable  para lenar filaas
    var fila_curso="insert into curso values (1001, 'Algoritmos 1', 4, 285);"

    override fun onCreate (db: SQLiteDatabase) {
        //ejecutamso laas  intruccioens  la  primera ves que es  invocada esta clase pe
        db.execSQL(tabla_curso)
        //
        db.execSQL(fila_curso)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}