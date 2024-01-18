package com.example.cursocompose.ui.layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cursocompose.ui.theme.CursocomposeTheme

class ModifiersActivity : ComponentActivity() {
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



//todo:Modifiers

@Preview(showBackground = true)
@Composable
fun MyTextAnchoAlto(){
    Text(text = "ejemplo de ancho y alto",
        modifier = Modifier
            .width(200.dp)
            .height(100.dp)
            .padding(start = 20.dp)
            .padding(vertical = 20.dp))
}

@Preview(showBackground = true)
@Composable
fun MyTextOcupaTodoElAncho() {
    Text(text="todo el ancho",
        modifier = Modifier
            .fillMaxWidth())
}

@Preview(showBackground = true)
@Composable
fun MyTextOcupaTodoElAlto() {
    Text(text="ocupa todo el Alto",
        modifier = Modifier.fillMaxHeight())
}

@Preview(showBackground = true)
@Composable
fun MyTextOcupaTodoElEspacio() {
    Text(text="Ocupa todo el espacio",
        modifier = Modifier.fillMaxSize())
}

@Preview(showBackground = true)
@Composable
fun MyTextPaddingEndRight(){
    Text(text = "padding start y end",
        modifier = Modifier
            .width(200.dp)
            .height(100.dp)
            .padding(start = 20.dp)
            .padding(end = 20.dp))//
}

@Preview(showBackground = true)
@Composable
fun MyTextPaddingEndRightAll(){
    Text(text = "padding de start y end, con una sola linea horizontal",
        modifier = Modifier
            .width(200.dp)
            .height(100.dp)
            .padding(horizontal = 20.dp))
}

@Preview(showBackground = true)
@Composable
fun MyTextPaddingTopBottom(){
    Text(text="pading de arriba y abajo",
        modifier = Modifier
            .padding(top=20.dp)
            .padding(bottom=20.dp))

}

@Preview(showBackground = true)
@Composable
fun MyTextPaddingTopBottomAll(){
    Text(text="padding en una sola linea de arriba y abajo",
        modifier=Modifier.padding(vertical=20.dp))
}
//todo: Previews
@Preview(
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