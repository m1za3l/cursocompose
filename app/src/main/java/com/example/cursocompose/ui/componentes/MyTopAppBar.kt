package com.example.cursocompose.ui.componentes

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cursocompose.ui.theme.CursocomposeTheme

class MyTopAppBar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CursocomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyTest(){
        Scaffold(
            topBar = {MyToolbarv2()}
        ) {
            Log.i("m1m1","PaddingValues :${it}")
            Box(modifier = Modifier
                .background(Color.Red)
                .size(80.dp))
        }
    }

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    fun MyToolbar(){
        TopAppBar(
            title = { Text(text = "Mi primera toolbar")  },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Color.LightGray
            )
        )
    }

    //https://developer.android.com/jetpack/compose/components/app-bars?hl=es-419
    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    fun MyToolbarv2(){
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
                    onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            },
            actions = {
                IconButton(
                    onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = null
                    )
                }

                IconButton(
                    onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Android,
                        contentDescription = null
                    )
                }
            }
        )
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

}