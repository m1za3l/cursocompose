package com.example.cursocompose.ui.layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cursocompose.ui.theme.CursocomposeTheme

class ColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CursocomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }


    @Preview(heightDp = 250, widthDp = 250, showBackground = true)
    @Composable
    fun MyColumn(){
        Column(Modifier.fillMaxSize()){
            Text("hola misael",modifier = Modifier.background(Color.Red))
            Text("hola misael ap",modifier = Modifier.background(Color.Yellow))
            Text("hola misael",modifier = Modifier.background(Color.Blue))
            Text("hola misael jm",modifier = Modifier.background(Color.Green))
        }
    }

    @Preview(heightDp = 250, widthDp = 250, showBackground = true)
    @Composable
    fun MyColumnPesosDististiosWeight(){
        Column(Modifier.fillMaxSize()){
            Text("hola misael",modifier = Modifier
                .background(Color.Red)
                .weight(1f))
            Text("hola misael ap",modifier = Modifier
                .background(Color.Yellow)
                .weight(1f))
            Text("hola misael",modifier = Modifier
                .background(Color.Blue)
                .weight(1f))
            Text("hola misael jm",modifier = Modifier
                .background(Color.Green)
                .weight(1f))
        }
    }

    @Preview(heightDp = 250, widthDp = 250, showBackground = true)
    @Composable
    fun MyColumnAutomaticoPesosCentrado(){
        Column(Modifier.fillMaxSize(), verticalArrangement= Arrangement.SpaceAround){
            Text("hola misael",modifier = Modifier.background(Color.Red))
            Text("hola misael ap",modifier = Modifier.background(Color.Yellow))
            Text("hola misael",modifier = Modifier.background(Color.Blue))
            Text("hola misael jm",modifier = Modifier.background(Color.Green))
        }
    }

    @Preview(heightDp = 250, widthDp = 250, showBackground = true)
    @Composable
    fun MyColumnAutomaticoPesosTop(){
        Column(Modifier.fillMaxSize(),verticalArrangement= Arrangement.SpaceBetween) {
            Text("hola misael",modifier = Modifier.background(Color.Red))
            Text("hola misael ap",modifier = Modifier.background(Color.Yellow))
            Text("hola misael",modifier = Modifier.background(Color.Blue))
            Text("hola misael jm",modifier = Modifier.background(Color.Green))
        }
    }

    @Preview(heightDp = 250, widthDp = 250, showBackground = true)
    @Composable
    fun MyColumnAutomaticoMarginTopBottom(){
        Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly) {
            Text("hola misael",modifier = Modifier.background(Color.Red))
            Text("hola misael ap",modifier = Modifier.background(Color.Yellow).align(Alignment.End))
            Text("hola misael",modifier = Modifier.background(Color.Blue))
            Text("hola misael jm",modifier = Modifier.background(Color.Green))
        }
    }


    @Preview(heightDp = 250, widthDp = 250, showBackground = true)
    @Composable
    fun MyColumnScrooll(){
        Column(Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())){
            Text("hola misael",modifier = Modifier.background(Color.Red).fillMaxWidth().height(100.dp))
            Text("hola misael",modifier = Modifier.background(Color.Yellow).fillMaxWidth().height(100.dp))
            Text("hola misael",modifier = Modifier.background(Color.Blue).fillMaxWidth().height(100.dp))
            Text("hola misael",modifier = Modifier.background(Color.Green).fillMaxWidth().height(100.dp))
            Text("hola misael",modifier = Modifier.background(Color.Red).fillMaxWidth().height(100.dp))
            Text("hola misael",modifier = Modifier.background(Color.Yellow).fillMaxWidth().height(100.dp))
            Text("hola misael",modifier = Modifier.background(Color.Blue).fillMaxWidth().height(100.dp))
            Text("hola misael",modifier = Modifier.background(Color.Green).fillMaxWidth().height(100.dp))
            Text("hola misael",modifier = Modifier.background(Color.Red).fillMaxWidth().height(100.dp))
            Text("hola misael",modifier = Modifier.background(Color.Yellow).fillMaxWidth().height(100.dp))
            Text("hola misael",modifier = Modifier.background(Color.Blue).fillMaxWidth().height(100.dp))
            Text("hola misael",modifier = Modifier.background(Color.Green).fillMaxWidth().height(100.dp))

        }
    }
}