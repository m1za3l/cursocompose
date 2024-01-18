package com.example.cursocompose.ui.layouts

import android.os.Bundle
import android.widget.HorizontalScrollView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
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

class RowActivity : ComponentActivity() {
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

    @Preview(heightDp = 250, showBackground = true)
    @Composable
    fun MyRowWeightManual(){
        Row(Modifier.fillMaxSize(), horizontalArrangement=Arrangement.SpaceBetween){
            Text("misael",modifier = Modifier
                .background(Color.Red)
                .weight(1f))
            Text("misael ap",modifier = Modifier
                .background(Color.Yellow)
                .weight(1f))
            Text("misael",modifier = Modifier
                .background(Color.Blue)
                .weight(1f))
            Text("misael jm",modifier = Modifier
                .background(Color.Green)
                .weight(1f))
        }
    }

    @Preview(heightDp = 250, showBackground = true)
    @Composable
    fun MyRowWeightAtm(){
        Row(Modifier.fillMaxSize(), horizontalArrangement=Arrangement.SpaceBetween){
            Text("misael",modifier = Modifier.background(Color.Red))
            Text("misael ap",modifier = Modifier.background(Color.Yellow))
            Text("misael",modifier = Modifier.background(Color.Blue))
            Text("misael jm",modifier = Modifier.background(Color.Green))
        }
    }

    @Preview(heightDp = 250, showBackground = true)
    @Composable
    fun MyRowScroll(){
        Row(
            Modifier
                .fillMaxSize()
                .horizontalScroll(rememberScrollState())){
            Text("misael",modifier = Modifier.background(Color.Red).width(50.dp))
            Text("misael ap",modifier = Modifier.background(Color.Yellow).width(50.dp))
            Text("misael",modifier = Modifier.background(Color.Blue).width(50.dp))
            Text("misael jm",modifier = Modifier.background(Color.Green).width(50.dp))
            Text("misael",modifier = Modifier.background(Color.Red).width(50.dp))
            Text("misael ap",modifier = Modifier.background(Color.Yellow).width(50.dp))
            Text("misael",modifier = Modifier.background(Color.Blue).width(50.dp))
            Text("misael jm",modifier = Modifier.background(Color.Green).width(50.dp))
            Text("misael",modifier = Modifier.background(Color.Red).width(50.dp))
            Text("misael ap",modifier = Modifier.background(Color.Yellow).width(50.dp))
            Text("misael",modifier = Modifier.background(Color.Blue).width(50.dp))
            Text("misael jm",modifier = Modifier.background(Color.Green).width(50.dp))
            Text("misael",modifier = Modifier.background(Color.Red).width(50.dp))
            Text("misael ap",modifier = Modifier.background(Color.Yellow).width(50.dp))
            Text("misael",modifier = Modifier.background(Color.Blue).width(50.dp))
            Text("misael jm",modifier = Modifier.background(Color.Green).width(50.dp))
        }
    }


    @Preview(showSystemUi = true)
    @Composable
    fun Exersice1(){
        Column(Modifier.fillMaxSize()){
            Box(Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .weight(1f),
                contentAlignment =Alignment.Center){
                Text("ejemplo 1")
            }
            Row(Modifier.weight(1f)){
                Box(Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red),
                    contentAlignment = Alignment.Center){
                    Text("ejemplo 2")
                }
                Box(Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.Green), 
                    contentAlignment = Alignment.Center
                )
                {
                    Text("ejemplo 3")
                }
            }
            Box(Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.Magenta),
                contentAlignment = Alignment.BottomCenter){
                Text("ejemplo 4")
            }
        }
    }

}