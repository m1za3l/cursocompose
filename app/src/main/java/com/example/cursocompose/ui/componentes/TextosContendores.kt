package com.example.cursocompose.ui.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp

class TextosContendores {

    @Preview( heightDp = 200, showBackground = true)
    @Composable
    fun MyText(){
        Column(Modifier.fillMaxSize()) {
            Text("esto es un ejmplo",color= Color.Blue)
            Text("esto es un ejmplo",color= Color.Red, fontWeight = FontWeight.Black)
            Text("esto es un ejmplo",color= Color.Red, fontStyle = FontStyle.Italic)
            Text("esto es un ejmplo",color= Color.Red, textDecoration = TextDecoration.LineThrough)
            Text("esto es un ejmplo",color= Color.Red, textDecoration = TextDecoration.combine(
                listOf(TextDecoration.LineThrough, TextDecoration.Underline)
            ))

            Text("esto es un ejmplo",color= Color.Blue, fontSize = 20.sp)
        }
    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Preview( heightDp = 200, showBackground = true)
    @Composable
    fun MyTextField(){
        Box(modifier = Modifier
            .size(200.dp)
            .background(Color.Red)) {
            var myText by remember { mutableStateOf("misa") }
            TextField(
                value = myText,
                onValueChange = { myText = it },
                shape = ShapeDefaults.Large)
        }
    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Preview( heightDp = 200, showBackground = true)
    @Composable
    fun MyTextFieldAdvance(){
        var myText by remember {mutableStateOf("")}
        TextField(value = myText,
            onValueChange = {
                            myText=if(it.contains("a")){
                                it.replace("a","")
                            }else{
                                it
                            }
               },
            label = { Text(text = "Introduce tu nombre")})
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview( heightDp = 200, showBackground = true)
    @Composable
    fun MyTextOutLine(){
        Column(Modifier.fillMaxSize()) {
            var myText by remember {mutableStateOf("")}
            OutlinedTextField(
                value=myText,
                modifier = Modifier.padding(20.dp),
                onValueChange = {myText=it},
                label = { Text(text = "Introduce tu nombre")},
                colors =  TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Magenta,
                    unfocusedBorderColor = Color.Blue)
            )
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

    //todo : STATE HOISTING
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ExersiceState(myText:String, onValueChanged:(String)->Unit){
        TextField(value = myText, onValueChange ={onValueChanged(it)} )
    }





















}