package com.example.cursocompose.ui.componentes

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Pending
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.example.cursocompose.ui.theme.CursocomposeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

//https://developer.android.com/jetpack/compose/components/drawer?hl=es-419
//https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#ModalNavigationDrawer(kotlin.Function0,androidx.compose.ui.Modifier,androidx.compose.material3.DrawerState,kotlin.Boolean,androidx.compose.ui.graphics.Color,kotlin.Function0)

class MyModalDrawer : ComponentActivity() {
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
        ModalNavigationDrawerSample()
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ModalNavigationDrawerSample() {
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        // icons to mimic drawer destinations
        val items = listOf(Icons.Default.Favorite, Icons.Default.Face, Icons.Default.Email)
        val selectedItem = remember { mutableStateOf(items[0]) }
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    Spacer(Modifier.height(12.dp))
                    items.forEach { item ->
                        NavigationDrawerItem(
                            icon = { Icon(item, contentDescription = null) },
                            label = { Text(item.name) },
                            selected = item == selectedItem.value,
                            onClick = {
                                scope.launch { drawerState.close() }
                                selectedItem.value = item
                            },
                            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                        )
                    }
                }
            },
            content = {

                val snackbarHostState = remember{ SnackbarHostState() }
                val scope = rememberCoroutineScope()
                Scaffold(
                    snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
                    topBar = {
                        MyToolbar(drawerState,scope){
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
                    logic(drawerState,scope)//esto lo puedes poner si el scaffold
                }

            }
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun logic(drawerState: DrawerState, scope: CoroutineScope) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = if (drawerState.isClosed) ">>> Swipe >>>" else "<<< Swipe <<<")
            Spacer(Modifier.height(20.dp))
            Button(onClick = { scope.launch { drawerState.open() } }) {
                Text("Click to open")
            }
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
    fun MyToolbar(drawerState: DrawerState, scope: CoroutineScope,onClick:(String)->Unit){
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
                    onClick = {
                        onClick("Atras")
                        scope.launch { drawerState.open()}
                    }) {
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