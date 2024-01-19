package com.example.cursocompose.ui.componentes

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.state.ToggleableState

class ControlDeSeleccion {
    @Preview(showBackground = true, heightDp = 300)
    @Composable
    fun MySwitch(){
        var state by remember{mutableStateOf(false)}
        var enable by remember {mutableStateOf(false)}
        Column(
            Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement= Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Switch(
                checked = state,
                onCheckedChange = {state = !state},
                enabled = enable,
                colors= SwitchDefaults.colors(
                        uncheckedThumbColor = Color.Red,
                        checkedThumbColor  = Color.Blue,


                )
            )

            Button(onClick = { enable=!enable }) {
                Text("habilita el check")
            }
        }

    }


    @Preview(showBackground = true, heightDp = 300)
    @Composable
    fun MyCheckBox(){
        var state by remember{mutableStateOf(false)}
        var enable by remember {mutableStateOf(false)}
        Column(
            Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement= Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Checkbox(checked = state,
                onCheckedChange = {state=!state},
                enabled = enable,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Red
                ))
            Button(onClick = { enable=!enable }) {
                Text("habilita el check")
            }
        }
    }

    /*
    en el Main
     Column() {
                        ControlDeSeleccion().MyCheckBoxWhitText()
                        ControlDeSeleccion().MyCheckBoxWhitText()
                    }
     */
    @Preview(showBackground = true)
    @Composable
    fun MyCheckBoxWhitText(){
        var state by remember{mutableStateOf(false)}
        Row(modifier=Modifier.padding(8.dp),   verticalAlignment = Alignment.CenterVertically){
            Checkbox(checked = state, onCheckedChange = {state=!state})
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Ejemplo 12")
        }
    }

    //listado de checbos
    //con toitulos, como se cual le corresponde a cada uno
    //@Preview(showBackground = true)
    /*
    en el mainvc:
    val myOptions =  ControlDeSeleccion().getOptions(titles =
                                listOf("verde","azul","amarillo")
                    )


                    Column() {
                        myOptions.forEach{
                            ControlDeSeleccion().MyCheckBoxList(checkInfo = it)
                        }
                    }
     */

    @Composable
    fun MyCheckBoxList(checkInfo: CheckInfo){
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
            Checkbox(checked =checkInfo.selected ,
                    onCheckedChange = {
                        checkInfo.onChangeState(!checkInfo.selected)
                    })
            Spacer(modifier = Modifier.size(20.dp))
            Text(text = checkInfo.title)
        }
    }

    @Composable
    fun getOptions(titles:List<String>):List<CheckInfo>{
        return titles.map {
            var status by remember{ mutableStateOf(false) }

            //esto es lo que va regresar al final del map
            CheckInfo(title = it,selected = status, onChangeState = {
                    //esta funcion va regresar un valar, q va escuchar el cambio
                    status=it
                    //y va cambiar el valor de la mismadata de la variable status
                 })
        }
    }

    data class CheckInfo(val title:String="",val selected:Boolean=false, val onChangeState:(Boolean)->Unit)
    //tres estados, select, unselecte, INDETERMINDADO
    @Composable
    fun MyTriStatusCheckBox(){
        var status by remember{ mutableStateOf(ToggleableState.Off) }
        TriStateCheckbox(state = status, onClick = {
            status = when( status){
                ToggleableState.On->{ToggleableState.Off}//regresa off, cuando esta en on y apachurras
                ToggleableState.Off->{ToggleableState.Indeterminate}
                ToggleableState.Indeterminate->{ToggleableState.On}
            }
        })
    }

    @Composable
    fun MyRadioButton(){
        RadioButton(selected = true, onClick = {  },
                enabled = true,
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Red,
                    unselectedColor = Color.Blue,
                    disabledSelectedColor = Color.Magenta
                )
            )
    }

    @Composable
    fun MyListRadioButton(){
        Column(Modifier.fillMaxSize()) {
            var name by remember{ mutableStateOf("Lulu") }
            Row() {
                RadioButton(selected = name == "Lulu", onClick = { name="Lulu" })
                Text(text = "Lulu")
            }
            Row() {
                RadioButton(selected = name == "Misa", onClick = { name="Misa" })
                Text(text = "Misa")
            }
            Row() {
                RadioButton(selected = name == "Nico", onClick = { name="Nico" })
                Text(text = "Nico")
            }
            Row() {
                RadioButton(selected = name == "Jafis", onClick = { name="Jafis" })
                Text(text = "Jafis")
            }
        }
    }

    //del ejemplo anterior lo voy hacer con listas y mejorado
    //todo: lo hice pero me selecciona todos , como q no guarda el estado ya SOLUCIONE
    /*
    val users = ControlDeSeleccion().MyConfigUser(users =
                            listOf("Lulu","Nico","Jafis","Misa")
                    )

                    Column() {
                        users.forEach {
                            ControlDeSeleccion().MyListRadioButtonMejorado(user = it)
                        }
                    }
     */
    @Composable
    fun MyListRadioButtonMejorado(user:User){
        Row() {
            RadioButton(
                selected = user.enable,
                onClick = { user.onClick(!user.enable) })
            Text(text = user.name)
        }
    }



    data class User(val name:String="", val enable:Boolean=false,val onClick:(Boolean)->Unit)

    @Composable
    fun MyConfigUser(users:List<String>):List<User>{
        return users.map {
            var enable by remember{ mutableStateOf(false) }//le pasas el parametro de entrada
            User(name = it,enable=enable, onClick = {//regresara el valor
                enable=it
            })
        }
    }

    //todo: Unica fuente de la verdad

}

