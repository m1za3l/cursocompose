package com.example.cursocompose.ui.exersice.julio.loginviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModelEjJul: ViewModel() {

    //solo se puede acceder desde el live data
    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private val _pass = MutableLiveData<String>()
    val pass : LiveData<String> = _pass

    private val _enableBtn = MutableLiveData<Boolean>()
    val enableBtn : LiveData<Boolean> =_enableBtn

    //haces un metodo cuando vas a observar, y cambiar la variable
    //la devuelves y pasa al valor desde donde se puede acceder
    fun onValueChange(mEmail: String, mPass:String) {
        _email.value = mEmail
        _pass.value = mPass
        _enableBtn.value = logicBtn(mEmail, mPass)
    }

    fun logicBtn(email:String, pass:String):Boolean{
        return pass.length>5 && email.contains("@")
    }

}