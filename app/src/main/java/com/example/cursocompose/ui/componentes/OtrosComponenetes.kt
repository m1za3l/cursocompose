package com.example.cursocompose.ui.componentes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class OtrosComponenetes {

    @Preview(showBackground = true)
    @Composable
    fun MyCard(){
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp), elevation = CardDefaults.cardElevation(
            defaultElevation = 12.dp
            ),
            shape = ShapeDefaults.Large,
            colors = CardDefaults.cardColors(
                contentColor = Color.Red,
                containerColor = Color.Blue,
            ),
            border = BorderStroke(5.dp, Color.Yellow)
        ) {

            Column(modifier = Modifier.padding(24.dp)) {
                Text(text = "hola")
                Text(text = "hola")
                Text(text = "hola")
            }

        }
    }

    //casi es lo mismo a la card,
    //una card es una surface, pero por defecto el elevado
    @Composable
    fun MySurface(){

    }

    //permite meter un circulo sobre algo, como el contador del icono de notificaciones
    @OptIn(ExperimentalMaterial3Api::class)
    @Preview(showBackground = true)
    @Composable
    fun MyBadgeBox(){
        //encima de q componente
        BadgedBox(
            modifier = Modifier.padding(30.dp),
            badge = {
                Badge(
                    content = {
                        Text(text = "1")
                    },
                    containerColor = Color.Blue,
                    contentColor = Color.White
                )
            },
        ) {
            //que esta debajo del badge
            Icon(imageVector = Icons.Default.Star, contentDescription = null)
        }
    }

    //DIVIDER, solo una linea q didive
    @Composable
    @Preview(showBackground = true)
    fun MyDivider(){
        Divider(modifier= Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
                color = Color.Red)
    }

    //el spinner, menu q le clickeas y se muestra  una lista
    //dropdownMenu

    //todo: se ve muy alejado en amin vc en el durface quita el fillmaxSize
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    @Preview(showBackground = true)
    fun MyDropDownMen() {
        var selectedText by remember { mutableStateOf("default") }
        var expanded by remember { mutableStateOf(false) }
        val students = listOf("Adriana", "lulu", "jafis")

        Column(modifier = Modifier.padding(24.dp)) {
            OutlinedTextField(
                value = selectedText,
                onValueChange = { selectedText = it },
                readOnly = true,
                enabled = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = true }
            )//esta funcion lambda regresa un valor it->
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                Modifier.fillMaxWidth()
            ) {

                students.forEach {
                    DropdownMenuItem(text = {
                        Text(text = it)
                    }, onClick = {
                        expanded = false
                        selectedText = it
                    })
                }

            }
        }
    }

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    fun MyBasicSlider(){
        var sliderPosition  by remember { mutableStateOf(0f) }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it })
            Text(text = "size: $sliderPosition")
            
        }
        
    }

    @Composable
    fun MyAdvanceSlider(){
        var sliderPosition  by remember { mutableStateOf(0f) }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Slider(
                value = sliderPosition,
                valueRange = 0f..10f,
                steps=9,//sn los pasos q debe sar, pero restale 2
                onValueChangeFinished = {sliderPosition.toString()},//se llama cuando pare el movimiento slider
                onValueChange = { sliderPosition = it })


            Text(text = "size: $sliderPosition")

        }
    }


    //una opcion inicial y una final
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyRangeSlider(){
        var currentSlider  by remember { mutableStateOf(0f..10f) }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
        ) {
            RangeSlider(
                value =currentSlider ,
                valueRange = 0f..10f,
                steps = 9,
                onValueChange = {currentSlider=it})
            Text(text = "valor inicial: ${currentSlider.start}")
            Text(text = "valor final: ${currentSlider.endInclusive}")

        }
        
    }


}