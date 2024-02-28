package com.example.cursocompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.cursocompose.ui.mvvm.login.LoginMvvm
import com.example.cursocompose.ui.theme.CursocomposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CursocomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }

//funcion con pase de parametros tambien una funcion

//TODO: PREVIEWS

@Preview (
    name = "1ra vista",
    heightDp = 80,
    widthDp = 200,
    showBackground = true,
    showSystemUi = true,
    apiLevel = 29,
    device = Devices.DEFAULT)
@Composable
fun MyTestSuperTest(){
    MySuperText("lulu")
}


@Composable
fun MySuperText(cad:String){
    Text(text = "soy $cad hola :)-- fdf "
    )
}

}