package com.example.cursocompose.ui.exersice.julio.loginviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModelEjJul: ViewModel() {

    //solo se puede acceder desde el live data
    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    //haces un metodo cuando vas a observar, y cambiar la variable
    //la devuelves y pasa al valor desde donde se puede acceder
    fun onEmailChange(email: String) {
        _email.value = email
    }

}