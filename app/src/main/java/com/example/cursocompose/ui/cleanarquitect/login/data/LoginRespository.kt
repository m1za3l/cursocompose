package com.example.cursocompose.ui.cleanarquitect.login.data

import com.example.cursocompose.ui.cleanarquitect.login.data.network.LoginService
import javax.inject.Inject


/*
// el repositorio va ser la clase que diga se lo pido a retorfit a bd un ficgero guardado
 */
class LoginRespository @Inject constructor(){

    private val api=LoginService()

    suspend fun doLogin(user:String, password:String):Boolean{
        //aki validaciones, vete a bd, a retrofit
        return api.doLogin(user,password)
    }

}