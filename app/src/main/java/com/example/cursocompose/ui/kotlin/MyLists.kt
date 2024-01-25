package com.example.cursocompose.ui.kotlin

class MyLists {

    fun myListBasic(){

        //listas inmutables
        val diasSemana:List<String> = listOf("lunes","martes","miercoles")
        println(diasSemana[2])
        diasSemana.first()

        val diasSemanaMutable : MutableList<String> = mutableListOf("lunes","martes","miercoles")
        diasSemanaMutable.add("Jueves")
        val result=diasSemanaMutable.filter {
            it== "lunes"
        }
        //añade todo lo que tenga lunes


    }

}