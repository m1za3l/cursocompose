package com.example.cursocompose.ui.cleanarquitect.login.data.network

import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import javax.inject.Inject


//todo: data puede pasar datos no solo de retrodit de bd tambien

/*
el encargado de llamar a todos los endPoints que tuviera este cliente:
            @GET("/v3/f78c9d33-28b1-4f81-9cf1-6d6ff78fa014")
            suspend fun doLogin(user:String, password:String):Response<LoginResponse>
el que tenga el objeto de retrofit que hicimos antes:
        class RetrofitHelper
        getRetrofit()
 */

/*
TODO: DAGGER HILT "LOS PROVIDERS"
-retrofit no esta PREPARADO
-creo un directorio di en core
-un modulo, las clases q se crean oara proveernos cosas

 */
class LoginService @Inject constructor(private val retrofit: Retrofit) {

    //private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun doLogin(user:String, password:String):Boolean{
        return with(Dispatchers.IO){
            //val response = retrofit.create(LoginClient::class.java).doLogin(user,password)
            val response = retrofit.create(LoginClient::class.java).doLogin()
            response.body()?.success ?:false
        }
    }
}

