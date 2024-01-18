package com.example.cursocompose.ui.componentes

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cursocompose.ui.theme.CursocomposeTheme
import androidx.compose.runtime.*

class Botones{

    @Preview(heightDp = 200, showBackground = true)
    @Composable
    fun MyBotonsExample(){
        Column(
            Modifier
                .fillMaxSize()
                .padding(24.dp)){
            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red ,//background
                    contentColor = Color.Blue // color del texto
                ),
                border = BorderStroke(5.dp,Color.Yellow)
            ){
                Column() {
                    Text("hola")
                    Text("hola")
                }

            }
        }
    }

    @Preview(heightDp = 200, showBackground = true)
    @Composable
    fun MyButtonState(){
        var enable by remember {mutableStateOf(true)}
        Column(
            Modifier
                .fillMaxSize()
                .padding(24.dp)){
            Button(
                onClick = { enable=false
                            Log.i("m2m2","enable: $enable")},
                enabled= enable,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red ,//background
                    contentColor = Color.Blue // color del texto
                ),
                border = BorderStroke(5.dp,Color.Yellow)
            ){
                Column() {
                    Text("hola")
                    Text("hola")
                }

            }
        }
    }

    /*
                    var value by remember{mutableStateOf(true)}
                    Botones().MyButtonStatePadre(value){
                        value=it
                        Log.i("m2m2","value: $it")
                    }
     */
    @Composable
    fun MyButtonStatePadre(value:Boolean, onClick:(Boolean)->Unit){
        Column(
            Modifier
                .fillMaxSize()
                .padding(24.dp)){
            Button(
                onClick = {
                    onClick(false)
                          },
                enabled= value,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red ,//background
                    contentColor = Color.Blue // color del texto
                ),
                border = BorderStroke(5.dp,Color.Yellow)
            ){
                Column() {
                    Text("hola")
                    Text("hola")
                }

            }
        }
    }

    @Preview(heightDp = 200, showBackground = true)
    @Composable
    fun MyOutlinedButton(){
        var enable by remember {mutableStateOf(true)}
        Column(
            Modifier
                .fillMaxSize()
                .padding(24.dp)){
            Button(
                onClick = { enable=false
                    Log.i("m2m2","enable: $enable")},
                enabled= enable,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red ,//background
                    contentColor = Color.Blue // color del texto
                ),
                border = BorderStroke(5.dp,Color.Yellow)
            ){
                Column() {
                    Text("hola")
                }

            }

            OutlinedButton(
                onClick = { enable=false
                    Log.i("m2m2","enable: $enable")},
                enabled= enable,
                colors = ButtonDefaults.buttonColors(
                    disabledContainerColor = Color.Black,
                    disabledContentColor = Color.Black
                )
            ){
                Column() {
                    Text("hola")
                }

            }
        }
    }

    @Preview(heightDp = 200, showBackground = true)
    @Composable
    fun MyTextButtonSinBordes(){
        Row(
            Modifier
                .height(120.dp)
                .fillMaxWidth()
                .padding(30.dp)) {
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "boton sin bordes")
            }
        }
    }

}