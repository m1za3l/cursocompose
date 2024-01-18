package com.example.cursocompose.ui.layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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

class SpacerActivity: ComponentActivity() {
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

    @Composable
    @Preview(showSystemUi=true)
    fun ExersiceConSpacer(){
        Column(modifier=Modifier.fillMaxSize()){
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(Color.Cyan),
                contentAlignment=Alignment.Center){
                Text("ejmplo1")
            }
            MySpacer(value = 20)
            Row(modifier=Modifier.weight(1f)){
                Box(modifier= Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red),
                    contentAlignment=Alignment.Center){
                    Text("ejmplo2")
                }
                Box(modifier= Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green),
                    contentAlignment=Alignment.Center){
                    Text("ejmplo3")
                }
            }
            MySpacer(value = 70)
            Box(modifier= Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.Magenta),
                contentAlignment=Alignment.BottomCenter){
                Text("ejmplo4")
            }
        }
    }

    @Composable
    fun MySpacer(value:Int){
        Spacer(modifier=Modifier.height(value.dp))
    }
}