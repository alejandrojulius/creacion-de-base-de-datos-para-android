package com.miempresa.appcolegiodb.Entidades

class Curso(xcod: Int, xnom:String, xhora: Int, xprecio:Double) {
                        //
              var codcur: Int=0
               var nomcur:String=""
              var nhoras:Int=0
              var precio: Double=0.0

    init {
        codcur = xcod
        nomcur = xnom
        nhoras = xhora
        precio = xprecio

    }
}