package com.example.cursocompose.ui.login.basic

import android.app.Activity
import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.Cancel
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cursocompose.R
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

class ExersiceLogin {

    @Composable
    fun LoginScreen(){
        Box (modifier= Modifier
            .fillMaxSize()
            .padding(16.dp)){
            Header(Modifier.align(Alignment.TopEnd))
            Body(Modifier.align(Alignment.Center))
            Footer()
        }
    }

    @Composable
    fun Header(modifier: Modifier) {
        val activity = LocalContext.current as Activity
        Icon(
            modifier = modifier.clickable { activity.finish() },
            imageVector = Icons.Rounded.Cancel ,
            contentDescription = "close login")
    }

    @Composable
    fun Body(modifier: Modifier) {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var showButton by remember { mutableStateOf(false) }
        Column(modifier=modifier) {
            ImageLogo()
            Spacer(modifier = Modifier.size(16.dp))
            Email(email){
                email=it
                showButton=loginButton(email, password)
            }
            Spacer(modifier = Modifier.size(16.dp))
            Password(password = password){
                password=it
                showButton=loginButton(email, password)
            }
            Spacer(modifier = Modifier.size(16.dp))
            ButtonLogin(showButton)
        }


    }

    fun loginButton(email:String, password: String) = Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6

    @Composable
    fun ImageLogo(){
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.insta),
            contentDescription = "")
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Email(email: String, onValue:(String)->Unit){
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = email,
            onValueChange = {onValue(it)},
            placeholder = { Text(text = "Email")},
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Password(password: String, onValue:(String)->Unit){
        var passwordVisibility by remember { mutableStateOf(false) }
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = {onValue(it)},
            placeholder = { Text(text = "Password")},
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            trailingIcon = {
                val icon = if(passwordVisibility){
                    Icons.Filled.VisibilityOff
                }else{
                    Icons.Filled.Visibility
                }
                IconButton(onClick = {passwordVisibility = !passwordVisibility }) {
                    Icon(imageVector = icon, contentDescription = "show password")
                }
            },
            visualTransformation = if(passwordVisibility){
                VisualTransformation.None
            }else{
                PasswordVisualTransformation()
            }

        )

    }

    @Composable
    fun ButtonLogin(showButton: Boolean){
        Button(
            modifier = Modifier.fillMaxWidth(),
            enabled = showButton,
            onClick = { /*TODO*/ }) {
            Text("Start")
        }
    }

    @Composable
    fun Footer(){

    }

}