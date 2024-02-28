package com.example.cursocompose.ui.componentes

import android.os.Bundle
import androidx.compose.runtime.*
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Pending
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cursocompose.ui.theme.CursocomposeTheme
import kotlinx.coroutines.launch

/**
 * todo: en un menu hamburquesa ya cambia todo
 */

class MyScaffolds : ComponentActivity() {
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
            },
            floatingActionButton = {MyFAB()},
            bottomBar = {MyBottomNavigation()}

        ) {
            Log.i("m1m1","PaddingValues :${it}")
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyScaffold(){
        Scaffold() {
            Log.i("m1m1","PaddingValues :${it}")
            Box(modifier = Modifier
                .background(Color.Red)
                .size(80.dp))
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyScaffoldv1(){
        Scaffold(
            content = {
                it
                Box(modifier = Modifier
                    .background(Color.Red)
                    .size(80.dp))
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

    @Composable
    fun MyFAB(){
        FloatingActionButton(
            onClick = { /*TODO*/ },
            containerColor = Color.LightGray
        ) {
            Icon(
                imageVector= Icons.Default.Pending,
                contentDescription = null
            )
        }
    }

    @Composable
    fun MyBottomNavigation() {
        var index by remember { mutableIntStateOf(0) }
        NavigationBar (
            containerColor = Color.Red,
            contentColor =  Color.White
        ){
            NavigationBarItem(
                selected = index==0,
                onClick = { index=0 },
                icon = {
                    Icon(
                        imageVector=Icons.Default.Pending,
                        contentDescription = null
                    )
                },
                label = { Text(text = "Pending")}
            )

            NavigationBarItem(
                selected = index==1,
                onClick = { index=1 },
                icon = {
                    Icon(
                        imageVector=Icons.Default.Badge,
                        contentDescription = null
                    )
                },
                label = { Text(text = "badge")}
            )

            NavigationBarItem(
                selected = index==2,
                onClick = { index=2 },
                icon = {
                    Icon(
                        imageVector=Icons.Default.Home,
                        contentDescription = null
                    )
                },
                label = { Text(text = "home")}
            )
        }
    }





}