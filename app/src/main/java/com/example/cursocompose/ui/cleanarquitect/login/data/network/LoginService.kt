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

class LoginService @Inject constructor(private val retrofit: Retrofit)
eto no va funcionar porquela clase Retrofit ya esta hecha pore so son los providers



 */
class LoginService @Inject constructor(private val loginClient: LoginClient) {//como se hace el provider ahora si puedes usar Retrofit
 // pero no necitamos esto-> class LoginService @Inject constructor(private val retrofit: Retrofit)
    //si no la interfaz implementada


    //el primer modulo que se tnia que hacer
    //private val retrofit = RetrofitHelper.getRetrofit()
    // ->estaba antesde modulos
    //esto era como una instancia para depues llamar a la interfaz

    suspend fun doLogin(user:String, password:String):Boolean{
        return with(Dispatchers.IO){
            //val response = retrofit.create(LoginClient::class.java).doLogin(user,password)
            val response = loginClient.doLogin()
                //estaba antes esto ->retrofit.create(LoginClient::class.java).doLogin()
            //pero ya esta inyectada la interfaz
            // a la clase LoginClient hay q hacer provider un interfaz
            response.body()?.success ?:false //si no responde el servicio ponle default false
        }
    }
}

