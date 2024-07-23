package com.example.cursocompose.ui.cleanarquitect.core.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//del final hasta la pantalla
//esto estaba antes de la inyeccion de dependencias
object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")
            .addConverterFactory(GsonConverterFactory.create())//convierte jsoin en data clase
            .build()
    }
}