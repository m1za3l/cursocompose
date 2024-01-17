package com.example.cursocompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.sp
import com.example.cursocompose.ui.theme.CursocomposeTheme

class BoxActivity: ComponentActivity() {
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


    //todo: BOX
    @Preview(heightDp = 250, widthDp = 250, showBackground = true)
    @Composable
    fun MyBox(){
        Box(modifier=Modifier.fillMaxSize()){
            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.Red))
        }
    }

    @Preview(heightDp = 250, widthDp = 250, showBackground = true)
    @Composable
    fun MyBoxAlinealoCentrado(){
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center){
            Box(modifier = Modifier
                .size(70.dp)
                .background(Color.Gray)
            )
        }
    }

    @Preview(heightDp = 250, widthDp = 450, showBackground = true)
    @Composable
    fun MyBoxAlinealoCentradoArriba(){
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter){
            Box(modifier = Modifier
                .size(70.dp)
                .background(Color.Black))
        }
    }

    @Preview(heightDp = 250, widthDp = 450, showBackground = true)
    @Composable
    fun MyBoxAlinealoCentroEnd(){
        Box(modifier=Modifier.fillMaxSize(),
            contentAlignment = Alignment.CenterEnd){
            Box(modifier= Modifier
                .size(70.dp)
                .background(Color.Blue))
        }
    }

    @Preview(heightDp = 250, widthDp = 450, showBackground = true)
    @Composable
    fun MyWrapContentText(){
        Box(modifier = Modifier.background(Color.Red),
            contentAlignment = Alignment.BottomEnd){
            Box(modifier=Modifier
                .background(Color.Yellow)){
                Text(text = "el box amamrillo toma WRAP CONTENT del textView")
            }
        }
    }

    @Preview(heightDp = 250, widthDp = 450, showBackground = true)
    @Composable
    fun MyWrapContentTextSoloPorAlto(){
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopEnd){
            Box(modifier = Modifier
                .width(40.dp)
                .background(Color.Green)){
                Text(text="solo tendra un wrap content de lo alto, el ancho si esta defonido")
            }
        }
    }

    //centra es el segundo elemnto, desde el primero
    @Preview(heightDp = 250, widthDp = 450, showBackground = true)
    @Composable
    fun CentraText(){
        Box(modifier=Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center){
            Box(modifier=Modifier.size(90.dp).background(Color.Red),
                contentAlignment = Alignment.Center){
                Text(text="hola", fontSize = 15.sp)
            }
        }
    }

    @Preview(heightDp = 250, widthDp = 450, showBackground = true)
    @Composable
    fun MyScrollText(){
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopEnd){
            Box(modifier = Modifier
                .size(50.dp)
                .background(Color.Red)
                .verticalScroll(rememberScrollState())
            ){
                Text(text = "2024-01-17 15:32:45.486 com.example.cursocompose    ")
            }
        }

    }
}