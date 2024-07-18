package com.example.cursocompose.ui.exersice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class EjStates {
    //exersice estados
    @Composable
    fun MyStateExample(){
        Column (
            modifier= Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            //todo: solo funciona en el ciclo de vida, pero si se rota la pantalla?
            var count = remember{ mutableStateOf(0) }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                Button(onClick = { count.value -=1 }) {
                    Text(text = "pulsar -")
                }
                Button(onClick = { count.value +=1 }) {
                    Text(text = "pulsar +")
                }
            }

            Text(text="Ha sido pulsado: ${count.value}  veces")
        }
    }

    //todo: exersice estados aun cuando rote la screen no perdera el valor anterior
    @Composable
    fun MyStateExampleSaveable(){
        Column (
            modifier= Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            //todo: solo funciona en el ciclo de vida, pero si se rota la panatalla?
            var count = rememberSaveable{ mutableStateOf(0) }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                Button(onClick = { count.value -=1 }) {
                    Text(text = "pulsar -")
                }
                Button(onClick = { count.value +=1 }) {
                    Text(text = "pulsar +")
                }
            }

            Text(text="Ha sido pulsado: ${count.value}  veces")
        }
    }

    //Todo: un ej de algo q va escuchando los cambios, cada ves q escribes
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyTextField(){
        var cad by rememberSaveable{ mutableStateOf("") }
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            TextField(value = cad , onValueChange = {cad=it} ) //no va cambair el estado por si solo , lo que se escriba
            //TODO:  onValueChanged( (String) -> Unit ) va regresar algo en la misa funcion, en los mismos PARENTESIS
        }
    }

    //Todo: ejemplo de un estado cambiado desde el Main activity, progrmacion DECLARATIVA
    //SI PONEMOS ATENCION al solo metodo de onValueChanged, puedes copiar la filosofia de esto
    //si quiebra la cabeza
    /*
    pones en el MainActivity
                    var cad by rememberSaveable{ mutableStateOf("misa") }
                    MyTextFieldAdvanced(cad , {cad = it})
                    MyTextFieldAdvanced(cad) { cad=it} //todo: dos formas
                    //todo: lo anterior es una lambda, un metodo regresa una funcion, aun no lo comprendo
     */
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyTextFieldAdvanced( cad:String, onvaluChanged : (String)->Unit ){
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            TextField(value = cad , onValueChange = { onvaluChanged(it) } ) //no va cambair el estado por si solo , lo que se escriba
            //TODO:  onValueChanged( (String) -> Unit ) va regresar algo en la misma funcion, en los mismos PARENTESIS
            //TODO: el mismos meteodo se activa, y regresa it
        }
    }

    //Todo: ejemplo de dos funciones en un mismo llmado de un metodo, cambia el texfiel, y text
    /*
    pones en el MainActivity
                    var txtF by rememberSaveable{ mutableStateOf("txtF") }
                    var txt by rememberSaveable { mutableStateOf("txt") }
                    MyTextFieldWithText(txtF,txt, {txtF=it}, {txt=it})
     */
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyTextFieldWithText(cad:String, text:String, onValueCHanged: (String)->Unit, onValueText: (String)->Unit ){
        Column (
            modifier= Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            TextField(value = cad, onValueChange = {
                onValueCHanged(it)
                onValueText(it)//todo. no sabia que se pueden llmara 2 metodos o hacer aki una funcion
            })
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = text)
        }
    }

    //todo:Data class, con amado de lista y una variable saveanle, y una funcion que escucha
    @Composable
    fun MyListRadioBtnMejorado(alumno:Alumno){

        Row() {
            RadioButton(
                selected = alumno.value,
                onClick = { alumno.onChanged(!alumno.value)}
            )
            Text(text = alumno.name)
        }
        Spacer(modifier = Modifier.height(20.dp))

    }

    data class Alumno(val name:String, val value : Boolean=false, val onChanged : (Boolean)->Unit)

    @Composable
    fun generateSalon(){
        val alumnos  = generateList(listOf("lulu","misa","lalo"))
        Column(
            modifier= Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            alumnos.forEach {
                MyListRadioBtnMejorado(it)
            }
        }

    }

    @Composable
    fun generateList(user : List<String>):List<Alumno>{
        return user.map { it ->
            var enable by rememberSaveable{ mutableStateOf(true ) }
            Alumno(it , enable) {enable = it}
            //Alumno(it , enable, onChanged = {enable = it})
        }
    }

}