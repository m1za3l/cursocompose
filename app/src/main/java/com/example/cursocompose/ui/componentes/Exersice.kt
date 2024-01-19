package com.example.cursocompose.ui.componentes

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class Exersice {

    @Composable
    fun MyCheckBox(checkInfo: CheckInfo){
        Row(verticalAlignment=Alignment.CenterVertically){
            Checkbox(checked = checkInfo.state, onCheckedChange = {checkInfo.onCheckedChange(!checkInfo.state)} )
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = checkInfo.title)
        }
    }

    data class CheckInfo(val title:String="",val state:Boolean=false, val onCheckedChange:(Boolean)->Unit)

    @Composable
    fun getOptions(titles:List<String>):List<CheckInfo>{
        return titles.map {
            var estado by remember{mutableStateOf(false)}

            //aki mismo va oir el cambio en el metodo y regresara un valor, lo cabia el state
            CheckInfo(title = it,state = estado, onCheckedChange = {valorRetornado->
                estado=valorRetornado
                })
        }

    }

}