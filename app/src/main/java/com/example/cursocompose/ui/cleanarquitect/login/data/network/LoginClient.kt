package com.example.cursocompose.ui.cleanarquitect.login.data.network

import com.example.cursocompose.ui.cleanarquitect.login.data.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.GET

/*
data:
bd
internet
 */


//el cliente de retrofit
// Lo siguinte es crear una clase servicio que consuma este cliente
interface LoginClient {
    //poner el final de endPoint
    @GET("/v3/f78c9d33-28b1-4f81-9cf1-6d6ff78fa014")
    suspend fun doLogin(user:String, password:String):Response<LoginResponse>

}