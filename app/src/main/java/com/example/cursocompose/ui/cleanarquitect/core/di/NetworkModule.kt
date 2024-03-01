package com.example.cursocompose.ui.cleanarquitect.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/*
donde aki adentro es el alcance de etsa clase
ej un activit, viewModel, muere entonces muere
busca con: @IntallIn()
tablade alacance : https://cursokotlin.com/dagger-hilt-inyeccion-de-dependencias-mvvm/
//SingletonComponent es usado comunmente para esto
 */

@Module // esto es un nmodulo
@InstallIn(SingletonComponent::class)
class NetworkModule {
    //proveeme retrofit

    //sea una unica instancia siguiendo el patron de SINGLETON, y no la etiqueta de arriba q no tiene nada q ver con S
    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")
            .addConverterFactory(GsonConverterFactory.create())//convierte jsoin en data clase
            .build()
    }
}