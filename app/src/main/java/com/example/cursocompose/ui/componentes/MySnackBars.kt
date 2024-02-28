package com.example.cursocompose.ui.componentes

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

class MySnackBars {



    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MySnackbarWhithScaffold(){
        val snackbarHostState = remember{ SnackbarHostState() }
        val scope = rememberCoroutineScope()
        Scaffold(
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
            topBar = {
                MyToolbar(){
                    scope.launch {
                        Log.i("m1m1","MySnackbarWhithScaffold: $it")
                        snackbarHostState.showSnackbar(
                            message = it
                        )
                    }
                }
            }
        ){padding->
            padding
            contentColorFor(backgroundColor = Color.Blue)
        }
    }


    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    fun MyToolbar(onClick:(String)->Unit){
        TopAppBar(
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            title = {
                Text("Small Top App Bar")
            },
            navigationIcon = {
                IconButton(
                    onClick = { onClick("Atras") }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            },
            actions = {
                IconButton(
                    onClick = { onClick("Person") }) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = null
                    )
                }

                IconButton(
                    onClick = { onClick("mitad") }) {
                    Icon(
                        imageVector = Icons.Filled.Android,
                        contentDescription = null
                    )
                }
            }
        )
    }

    //https://www.youtube.com/watch?v=skfGvJ9PuQ0
    @Preview()
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyScaffoldSnackBar(){
        val snackbarHostState = remember{ SnackbarHostState() }
        val scope = rememberCoroutineScope()
        Scaffold(
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
        ) { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ){
                Button(onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = "my snackbar"
                        )
                    }
                }) {
                    Text(text = "show  SnackBar")
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MySnackBar(){

    }
}