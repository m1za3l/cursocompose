package com.example.cursocompose.ui.exersice.julio.loginviewmodel

import android.os.Bundle
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cursocompose.ui.theme.CursocomposeTheme

//debe ser un acitiviy

class EjLoginJulio: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CursocomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    //debe ser en un activity
                    LoginScreen(LoginViewModelEjJul())
                }
            }
        }
    }


    //Aquime donde lo llames metes la insntancia, seria mejor inyectarlos
    // c desde la activity
    @Composable
    fun LoginScreen(loginViewModel:LoginViewModelEjJul){
        /*
        tienes varias opciones
        1.-un box que alinee en top end, center, y topbutton
        2.- column con pesos
         */
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            Header(Modifier.align(Alignment.TopEnd))
            Body(Modifier.align(Alignment.Center), loginViewModel)
            Footer(Modifier.align(Alignment.BottomCenter))
        }
    }

    @Composable
    fun Header(modifier: Modifier) {
        Icon(
            imageVector = Icons.Rounded.Close,
            contentDescription = null,
            modifier = modifier.size(30.dp)
        )
    }

    @Composable
    fun Body(modifier: Modifier, loginViewModel: LoginViewModelEjJul){
        Column(modifier=modifier) {
            // ahora las declararas con viewmodels, para q las observe
            //pero aun ocupas Unit, para regresar la variable a la unica fuente de la verdad
            //var email by rememberSaveable { mutableStateOf("") }
            val email by loginViewModel.email.observeAsState(initial = "")
            var pass by rememberSaveable { mutableStateOf("") }
            var enableBtn by rememberSaveable { mutableStateOf(false) }

            Email(email){
                //aki en la logica de viewModel  cambias la logica
                //mandas lo que regresa la funcion email, no email
                loginViewModel.onEmailChange(email=it)
            }
            Spacer(modifier = Modifier.size(16.dp))
            Password(pass) {
                pass = it
            }
            Spacer(modifier = Modifier.size(16.dp))
            LoginButton(Modifier, enableBtn)
            //debe aber una logica de habilitar el btn como pass>6 y email corecto

        }

    }

    fun logicBtn(email:String, pass:String):Boolean{
        return pass.length>5 && email.contains("@")
    }
    //mas PRO
    fun enableLogin(email:String, password:String) = Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length >6

    @Composable
    fun LoginButton(modifier: Modifier, enableBtn: Boolean) {
        Button(
            onClick = { /*TODO*/ },
            colors= ButtonDefaults.buttonColors(
                containerColor = Color(0XFF4EA8E9),
                disabledContainerColor = Color(0XFF78C8F9),
                contentColor = Color.White,
                disabledContentColor = Color.White
            ),
            enabled = enableBtn,
            modifier = modifier.fillMaxWidth())
        {
            Text(text = "Login In")
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Email(email: String, onChange: (String)->Unit) {
        TextField(
            value = email,
            onValueChange = {onChange(it)},
            modifier= Modifier.fillMaxWidth(),
            placeholder = { Text(text = "email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            maxLines = 1,
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                containerColor = Color(0XFFFAEFC4),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Password(pass:String, onChange:(String)->Unit) {
        var isShowPass by rememberSaveable { mutableStateOf(false) }
        TextField(
            value = pass,
            onValueChange = { onChange(it) },
            modifier= Modifier.fillMaxWidth(),
            placeholder = { Text(text = "password") },
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                containerColor = Color(0XFFFAEFC4),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            trailingIcon = {
                //le pregunta es porque el icon , no es un estado, y cambia porque la otra variable si lo es?
                val imgVector = if(isShowPass){
                    Icons.Filled.Visibility}else{
                    Icons.Filled.VisibilityOff}
                IconButton(onClick = { isShowPass=!isShowPass } ) {
                    Icon(
                        imageVector = imgVector,
                        contentDescription = "show password"
                    )
                }
            },
            //poner los asteriscos
            visualTransformation = if(isShowPass){
                VisualTransformation.None}else{
                PasswordVisualTransformation()
            }

        )
    }



    @Composable
    fun Footer(modifier: Modifier){
        Column(modifier = modifier.fillMaxWidth()){
            Divider(
                Modifier
                    .background(Color(0XFFF9F9F9))
                    .height(2.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(24.dp))
            SingUp()
            Spacer(modifier = Modifier.size(24.dp))
        }
    }

    @Composable
    fun SingUp() {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Don't have account?", fontSize = 12.sp)
            Text(text = "Sign up.", fontSize = 12.sp,
                modifier= Modifier.padding(horizontal = 10.dp),
                fontWeight = FontWeight.Black,
                color = Color(0XFF4EA8E9),)
        }
    }
}