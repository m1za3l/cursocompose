package com.example.cursocompose.ui.mvvm.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel(){

    //solo se puede acceder desde adentro del livedTA
    private val _email = MutableLiveData<String>()
    private val _password = MutableLiveData<String>()
    val email : LiveData<String> = _email
    val password : LiveData<String> = _password

    fun onLoginChanged(email:String){
        _email.value = email
    }

    fun onLoginChanged2(password:String){
        _password.value = password
    }

}