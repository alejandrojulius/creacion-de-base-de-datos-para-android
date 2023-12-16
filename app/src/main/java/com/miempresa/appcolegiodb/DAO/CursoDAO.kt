package com.miempresa.appcolegiodb.DAO

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.miempresa.appcolegiodb.Entidades.Curso


class CursoDAO(contexto: Context) {
    //definimos la variable parav el sqliteOpenhelper = databasehelpers
    var helper = DatabaseHelper(contexto)

    fun GrabarCurso(objcur: Curso):String{
        //abrir la bd en modo escritura

        var bd:SQLiteDatabase = helper.writableDatabase



        //var cadSQL = "insert into curso values(" + objcur.codcur +",'"+ objcur.nomcur  +"')"

        //var cadSQL2 = "insert into curso values(${objcur.codcur},'${objcur.nomcur}')"

        //bd.execSQL(cadSQL2)



        // definir la variable de tipo ContentValues

        var valores = ContentValues()

        // sintaxis para enviar un valor a una columna, sin importar el tipo de dato

        // valores.put("nom_columna", valor_asignar)

        valores.put("codcur", objcur.codcur)

        valores.put("nomcur", objcur.nomcur)

        valores.put("nhoras", objcur.nhoras)

        valores.put("precio", objcur.precio)



        // insertar los valores del contentvalues en la tabla

        // bd.insert("nomtabla",null, variable_contentvalues)

        bd.insert("curso", null, valores)



        // cerrar la bd

        bd.close()

        //

        return "El Curso: ${objcur.nomcur} fue registrado correctamente"
    }

    fun ListarCursoString(): ArrayList<String>{
        var lista = ArrayList<String>()
        //abrir
        var bd = helper.readableDatabase
        var  c:Cursor = bd.rawQuery("select*from curso", null)
        var  cadena =""
        if (c.count >0){
            //c.moveToFirst()
            while (c.moveToNext()){
                cadena = "" + c.getInt(0) + " - " +

                        c.getString(1) + " - " +

                        c.getDouble(3)

                //

                lista.add(cadena)

            }

        }

        //

        c.close()

        bd.close()



        return lista
    }
}