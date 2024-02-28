package com.example.cursocompose.ui.cleanarquitect.login.data

import com.example.cursocompose.ui.cleanarquitect.login.data.network.LoginService


/*
// el repositorio va ser la clase que diga se lo pido a retorfit a bd un ficgero guardado
 */
class LoginRespository {

    private val api=LoginService()

    suspend fun doLogin(user:String, password:String):Boolean{
        //aki validaciones, vete a bd, a retrofit
        return api.doLogin(user,password)
    }

}