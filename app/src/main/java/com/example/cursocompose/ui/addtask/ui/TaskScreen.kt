package com.example.cursocompose.ui.addtask.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TaskScreen(taskViewModel: TaskViewModel) {
    //aparece un dialogo, y haces una nota, y lo metes en el listado

    Box(modifier=Modifier.fillMaxSize()){
        FloatingActionButton(onClick = {
            //mostar dialogo
        }) {

        }
    }

}