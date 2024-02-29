package com.example.cursocompose.ui.mvvm.login

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cursocompose.ui.cleanarquitect.login.domain.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel(){

    val loginUseCase = LoginUseCase()

    //solo se puede acceder desde adentro del livedTA
    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    private val _isLoginEnable = MutableLiveData<Boolean>()
    val isLoginEnable : LiveData<Boolean> = _isLoginEnable

    fun onLoginChanged(email:String, password:String){
        _email.value = email
        _password.value = password
        _isLoginEnable.value = enableLogin(email,password)
        //para no hacer loginUseCase.doLogin("","")
        //loginUseCase.("","")
    }

    fun enableLogin(email:String, password:String) = Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length >6

    //esta funcion se va llamar cuando el boton de login haya sido pulsado
    fun onLoginSelected(){
        viewModelScope.launch{
            val result = loginUseCase(email.value!!, password.value!!)
            if(result){
                //navegar a la siguiente ventana
                Log.i("m1m1m", "puedes ir: $result")
            }
        }
    }

}