package com.example.cursocompose.ui.estados

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class Estados {
    //gone visible, viewmodel

    //no se va actualizar, se vuelve a crear de nuevo
    //asegura estar actualizada

    @Preview(showSystemUi = true)
    @Composable
    fun MyStateExample() {
        var count = remember { mutableStateOf(0) }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(onClick = { count.value += 1 }) {
                Text("pulsar")
            }
            Text(text = "ha sido pulsado : ${count.value} veces ")
        }
    }


    //pero si roto la pantalla, el ciclo de vida de las activities
    //cuando rota la activity se destruye y se vuelve a crear
    //lo anterior solo es con la funcion, ahora es con activity
    @Preview(showSystemUi = true)
    @Composable
    fun MyStateExampleSaveable() {
        var count = rememberSaveable { mutableStateOf(0) }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(onClick = { count.value += 1 }) {
                Text("pulsar")
            }
            Text(text = "ha sido pulsado : ${count.value} veces ")
        }
    }

    //optimizar el codigo, lo del value no esta chido por by
    //importar: import androidx.compose.runtime.*
    @Preview(showSystemUi = true)
    @Composable
    fun MyStateExampleProperty() {
        var count by rememberSaveable { mutableStateOf(0) }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(onClick = { count += 1 }) {
                Text("pulsar")
            }
            Text(text = "ha sido pulsado : $count veces ")

        }
    }

    //Patron para ponerlo  o usarlo en otro lado, lo que esta en en el textField
    //mandarlo desde el activity, a otra clase, de padre a hijo

    //controlar un estado en un remember en una funcion
    //hacerlo sin estados, no cargar al compose
    //sacar el estado e un miembro superior

    //recibir el dato en el padre

    //va recibir el estado del objeto, y una FUNCION y esta funcion regresara un String

    /*
    add: import androidx.compose.runtime.*
    en Main Activity:
       var myText by remember {mutableStateOf("")}
       TextosContendores().MyTextField(myText){myText=it}
     */
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyTextField(name:String, onValueChanged: (String)->Unit ){
        TextField(value = name, onValueChange = {onValueChanged(it)})
    }
}