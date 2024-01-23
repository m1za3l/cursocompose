package com.example.cursocompose.ui.login.basic

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cursocompose.R
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.cursocompose.ui.theme.CursocomposeTheme


//primero las capas exteriores: header, content o BODY, footer
class LoginBasic : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CursocomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginBasic().LoginScreen()
                }
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    fun LoginScreen(){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {

            Box(modifier = Modifier.weight(0.1f)
                .align(Alignment.End)
                ){
                Header( Modifier)
            }


            Row(modifier= Modifier.weight(0.8f)
                .align(Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically){
                Body(Modifier)
            }


            Box(modifier = Modifier.weight(0.1f)
                .align(Alignment.Start)){
                Header( Modifier)
            }

        }
    }

    @Composable
    fun Body(modifier: Modifier) {
        var email by remember{ mutableStateOf("") }
        var password by remember{ mutableStateOf("") }
        Column(modifier=modifier,
               horizontalAlignment = Alignment.CenterHorizontally) {
            ImageLogo(Modifier)
            Spacer(modifier = Modifier.size(16.dp))
            Email(Modifier,email){email=it}
            Spacer(modifier = Modifier.size(16.dp))
            Password(Modifier,password){password=it}
            Spacer(modifier = Modifier.size(16.dp))
            Box(modifier = Modifier.align(Alignment.End)) {
                ForgotPasword(Modifier)
            }
        }
       
    }

    @Composable
    fun ForgotPasword(modifier: Modifier) {
        Text(text="Forgot password?", fontSize = 12.sp, fontWeight = FontWeight.Bold, color= Color.Blue)
    }

    @Composable
    fun ImageLogo(modifier: Modifier){
        Image(painter = painterResource(
            id = R.drawable.insta),
            contentDescription = "logo insta",
            alignment = Alignment.Center
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Email(modifier: Modifier, email: String, onValue:(String)->Unit){
        TextField(value = email, onValueChange = {onValue(it)} )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Password(modifier:Modifier, password:String, onValue:(String)->Unit){
        TextField(value = password, onValueChange = {onValue(it)})
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


}