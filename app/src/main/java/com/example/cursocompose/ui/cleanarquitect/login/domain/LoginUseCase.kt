package com.example.cursocompose.ui.cleanarquitect.login.domain

import com.example.cursocompose.ui.cleanarquitect.login.data.LoginRespository


/*
RetrofitHelper->(LoginClient DAO <->DataResponse)->
Service (consuma el cliente DAO) -> Repository (dira voy a BD, retrofit) -> UseCase(domain)

el dominio es la logica de negocio
una peticion necitamos saber si tiene permisos
si puede acder o no
y sera a traves de casos de uso
-si necesito recuperar el usuario llamaria a ese caso de uso
-vamos separando la logica de negocio
 */
class LoginUseCase {

    //el view model es el que  llamara a viewModel

    private val repository = LoginRespository()

    //nos ahorammos a que llame a una funcion operator invoke
    suspend operator fun invoke (user:String, password:String):Boolean{
        return repository.doLogin(user, password)
    }

}