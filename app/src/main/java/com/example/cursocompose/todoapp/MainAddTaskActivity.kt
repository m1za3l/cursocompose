package com.example.cursocompose.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.cursocompose.todoapp.addtask.ui.TaskScreen
import com.example.cursocompose.todoapp.addtask.ui.TaskViewModel
import com.example.cursocompose.ui.theme.CursocomposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainAddTaskActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val taskViewModel:TaskViewModel by viewModels()

        super.onCreate(savedInstanceState)
        setContent {
            CursocomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskScreen(taskViewModel)
                }
            }
        }
    }
}