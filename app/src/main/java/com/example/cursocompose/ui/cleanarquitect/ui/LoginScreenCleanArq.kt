package com.example.cursocompose.ui.cleanarquitect.ui

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cursocompose.R
import com.example.cursocompose.ui.theme.CursocomposeTheme

//loginBasic2
class LoginScreenCleanArq : ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CursocomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    //lo bueno seria inyectarlo
                    LoginScreen(LoginCleanArqViewModel())
                }
            }
        }
    }

    @Composable
    fun LoginScreen(loginViewModel: LoginCleanArqViewModel){
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)){
            Header(Modifier.align(Alignment.TopEnd))
            Body(Modifier.align(Alignment.Center),loginViewModel)
            Footer(Modifier.align(Alignment.BottomCenter))
        }
    }

    @Composable
    fun Header(modifier: Modifier) {
        val activity = LocalContext.current as Activity
        Icon(imageVector = Icons.Rounded.Close,
            contentDescription = "close app",
            modifier = modifier
                .size(30.dp)
                .clickable { activity.finish() }
        )
    }


    //estas 3 variables se enganche al viewModel
    @Composable
    fun Body(modifier: Modifier, loginViewModel: LoginCleanArqViewModel){

        val email:String by loginViewModel.email.observeAsState(initial = "")
        val password:String by loginViewModel.password.observeAsState(initial = "")
        val isLoginEnable:Boolean by loginViewModel.isLoginEnable.observeAsState(initial = false)

        Column(modifier=modifier) {
            ImageLogo(Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.size(16.dp))
            Email(email){
                loginViewModel.onLoginChanged(email = it,password =password)
            }//no es q este centrado es q ocupa todo el ancho
            Spacer(modifier = Modifier.size(16.dp))
            Password(password){
                loginViewModel.onLoginChanged(email =email,password =it)
            }
            Spacer(modifier = Modifier.size(16.dp))
            ForgotPasword(Modifier.align(Alignment.End))
            Spacer(modifier = Modifier.size(16.dp))
            //email y contraseña valida se habilita el boton
            LoginButton(Modifier, isLoginEnable, loginViewModel)
            Spacer(modifier = Modifier.size(16.dp))
            LoginDivider()
            Spacer(modifier = Modifier.size(16.dp))
            LoginSocial()


        }
    }

    @Composable
    fun LoginSocial(){
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
            Image(painter = painterResource(id = R.drawable.fb), contentDescription = "Social lofin fb", Modifier.size(16.dp))
            Text(
                text = "Continue as Misa",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0XFF4EA8E9),
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }

    @Composable
    fun LoginDivider(){
        Row (Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
            Divider(
                Modifier
                    .background(Color(0XFFF9F9F9))
                    .height(2.dp)
                    .weight(1f))
            Text(text = "OR", fontSize = 12.sp, modifier = Modifier.padding(16.dp),fontWeight= FontWeight.Bold, color=Color(0XFFB5B5B5) )
            Divider(
                Modifier
                    .background(Color(0XFFF9F9F9))
                    .height(2.dp)
                    .weight(1f))
        }
    }

    @Composable
    fun LoginButton(modifier: Modifier, loginEnable: Boolean, loginViewModel: LoginCleanArqViewModel) {
        Button(
            onClick = { loginViewModel.onLoginSelected()},
            colors= ButtonDefaults.buttonColors(
                containerColor = Color(0XFF4EA8E9),
                disabledContainerColor = Color(0XFFC4E6FA),
                contentColor = Color.White,
                disabledContentColor = Color.White
            ),
            enabled = loginEnable,
            modifier = modifier.fillMaxWidth())
        {
            Text(text = "Login In")
        }
    }

    @Composable
    fun ForgotPasword(modifier: Modifier) {
        Text(text="Forgot password?", fontSize = 12.sp, fontWeight = FontWeight.Bold,    color = Color(0XFF4EA8E9), modifier=modifier)
    }

    @Composable
    fun ImageLogo(modifier: Modifier){
        Image(painter = painterResource(
            id = R.drawable.insta),
            contentDescription = "logo insta",
            modifier = modifier
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Email(email: String, onValue:(String)->Unit){
        TextField(
            value = email,
            onValueChange = {onValue(it)},
            modifier=Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Email")},
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(0XFFB2B2B2),
                containerColor = Color(0XFFFAFAFA),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )

        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Password(password:String, onValue:(String)->Unit){
        var passwordVisibility by remember { mutableStateOf(false) }
        TextField(
            value = password,
            onValueChange = {onValue(it)},
            modifier=Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Password")},
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(0XFFB2B2B2),
                containerColor = Color(0XFFFAFAFA),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            trailingIcon = {
                val icon =if(passwordVisibility){
                    Icons.Filled.VisibilityOff
                }else{
                    Icons.Filled.Visibility
                }
                IconButton(onClick = { passwordVisibility =!passwordVisibility }) {
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
    fun Footer(modifier: Modifier){
        Column(modifier = modifier.fillMaxWidth()) {

            Divider(
                Modifier
                    .background(Color(0XFFF9F9F9))
                    .height(2.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(24.dp))
            SignUp()
            Spacer(modifier = Modifier.size(24.dp))

        }
    }

    @Composable
    fun SignUp() {
        // todo: sino funciona en el padre el CenterHorizontally, hazlo en elhijo con arragment
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(text = "Don't have account?", fontSize = 12.sp)
            Text(text = "Sign up.", fontSize = 12.sp, modifier=Modifier.padding(horizontal = 10.dp), fontWeight = FontWeight.Black,    color = Color(0XFF4EA8E9),)
        }
    }

}