package com.example.cursocompose.ui.mvvm.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel(){

    //solo se puede acceder desde adentro del livedTA
    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    fun onLoginChanged(email:String){
        _email.value = email
    }

}