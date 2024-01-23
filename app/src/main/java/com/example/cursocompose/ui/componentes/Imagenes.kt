package com.example.cursocompose.ui.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cursocompose.R

class Imagenes {

    @Preview(showSystemUi = true)
    @Composable
    fun MyImage(){

        Image(painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "ejemplo",
            Modifier.alpha(0.5f))
    }

    @Preview(showSystemUi = true)
    @Composable
    fun MyImageAdvance(){
        Box(modifier= Modifier.fillMaxSize()){
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "ejemplo",
                //juegas para hacerlo mas circular o menos
                modifier = Modifier
                    .size(60.dp)
                    .align(Alignment.Center)
                    .clip(RoundedCornerShape(100f))
            )
        }
    }

    //todo no funcionaba el circle Shape, lo hice de nuevo en otra funcion y ya agarro jejej
    @Preview(showSystemUi = true)
    @Composable
    fun MyImageAdvanceCircular(){
        Box(modifier= Modifier.fillMaxSize()){
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "ejemplo",
                //el borde va a la imagen completa
                modifier = Modifier
                    .clip(CircleShape)
                    .border(5.dp, Color.Yellow)
            )
        }
    }

    //todo no funcionaba el circle Shape, lo hice de nuevo en otra funcion y ya agarro jejej
    @Preview(showSystemUi = true)
    @Composable
    fun MyImageAdvanceCircular2(){
        Box(modifier= Modifier.fillMaxSize()){
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "ejemplo",
                //el borde va a la imagen completa
                modifier = Modifier
                    .clip(CircleShape)
                    .border(5.dp, Color.Yellow, CircleShape)
            )
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    fun MyIcon() {
        //https://fonts.google.com/icons
        //es parte de material design 24 x 24
        //cambiar el color de las imagenes
        //add library: 'androidx.compose.material:material-icons-extended:1.5.4'
        Box(modifier= Modifier.fillMaxSize(), contentAlignment = Alignment.TopEnd) {
            Icon(
                imageVector = Icons.Rounded.Star,
                modifier = Modifier.size(30.dp),
                contentDescription = null,
                tint = Color.Red
            )
        }
    }


    @Preview(showSystemUi = true)
    @Composable
    fun LoginScreen(){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Row(Modifier.align(Alignment.End)) {
                Header(Modifier)
            }
            Row(Modifier.align(Alignment.CenterHorizontally)){
                Header(Modifier)
            }
            Box(modifier = Modifier.align(Alignment.End)){
                Header(Modifier)
            }
        }
    }


    @Composable
    fun Header(modifier: Modifier) {

            Icon(imageVector = Icons.Rounded.Close,
                contentDescription = "close app",
                modifier = modifier.size(60.dp)
            )

    }

    @Preview(showSystemUi = true)
    @Composable
    fun MyHeaderBodyFooter(){
        Box(modifier = Modifier.fillMaxSize().padding(14.dp)){
            MyHeader(Modifier.align(Alignment.TopEnd))
            MyHeader(Modifier.align(Alignment.Center))
            MyHeader(Modifier.align(Alignment.BottomStart))
        }
    }

    @Composable
    fun MyHeader(modifier: Modifier) {
        Text("hola", modifier=modifier)

    }

}