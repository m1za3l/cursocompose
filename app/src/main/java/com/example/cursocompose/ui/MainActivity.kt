package com.example.cursocompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.cursocompose.ui.theme.CursocomposeTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.example.cursocompose.ui.componentes.Dialogs
import com.example.cursocompose.ui.layouts.ExercisesLayouts
import com.example.cursocompose.ui.login.basic.ExersiceLogin
import com.example.cursocompose.ui.login.basic.LoginBasic
import com.example.cursocompose.ui.login.basic.LoginBasicV2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CursocomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    ExercisesLayouts().CardTwitter()
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