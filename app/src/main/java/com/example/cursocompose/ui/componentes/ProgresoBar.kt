package com.example.cursocompose.ui.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*

class ProgresoBar {

    @Preview(showSystemUi = true)
    @Composable
    fun MyProgressBar(){
        Column(
            Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement=Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator(modifier=Modifier.padding(20.dp))
            LinearProgressIndicator(Modifier.padding(20.dp))
        }
    }

    //habilitar y desactivsar vistas en jetpack
    @Preview(showSystemUi = true)
    @Composable
    fun MyProgressBarOnoff(){
        var showLoading by remember{mutableStateOf(false)}

        Column(
            Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement=Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            if(showLoading) {
                CircularProgressIndicator(modifier = Modifier.padding(20.dp))
                LinearProgressIndicator(Modifier.padding(20.dp))
            }
            Button(onClick = {showLoading=!showLoading}) {
                Text(text = "pulsa")
            }


        }
    }

    @Preview(showSystemUi = true)
    @Composable
    fun MyProgressBarPorcentaje(){

        var percent by remember{mutableStateOf(0.5f)}

        Column(
            Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement=Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            CircularProgressIndicator(progress = percent)

            Row(modifier=Modifier.fillMaxWidth().padding(top = 30.dp),
                horizontalArrangement = Arrangement.Center){

                Button(onClick = {percent-=0.1f}) {
                    Text(text = "Reducir")
                }

                Button(onClick = {percent+=0.1f}) {
                    Text(text = "Aumentar")
                }

            }

        }
    }

}