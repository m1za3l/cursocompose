package com.example.cursocompose.ui.componentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Male
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Pending
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.cursocompose.ui.theme.CursocomposeTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

//https://medium.com/@bharadwaj.rns/bottom-navigation-in-jetpack-compose-using-material3-c153ccbf0593

class MyBottonNavigations : ComponentActivity() {
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
            bottomBar = { MyBottomNavigationMaterial3_v1() },
        ){
            it
            contentColorFor(backgroundColor = Color.Blue)
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

    //////////////////////////////   //////////////////////////////   //////////////////////////////

    // https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#BottomAppBar(kotlin.Function1,androidx.compose.ui.Modifier,kotlin.Function0,androidx.compose.ui.graphics.Color,androidx.compose.ui.graphics.Color,androidx.compose.ui.unit.Dp,androidx.compose.foundation.layout.PaddingValues,androidx.compose.foundation.layout.WindowInsets,androidx.compose.material3.BottomAppBarScrollBehavior)
    @Composable
    fun MyBottomNavigationMaterial3(){
        var index by remember { mutableIntStateOf(0) }
        BottomAppBar(
            actions = {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Menu, contentDescription = "Localized description")
                }
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Mail, contentDescription = "Localized description")
                }
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Male, contentDescription = "Localized description")
                }
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /* do something */ },
                    containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                    elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                ) {
                    Icon(Icons.Filled.Add, "Localized description")
                }
            }
        )
    }

    //Nota: También puedes usar BottomAppBar sin pasar un valor para actions y floatingActionButton. En ese caso, puedes crear una barra inferior personalizada de la app si completas BottomAppBar con contenido como lo harías con otros contenedores.
    //https://developer.android.com/jetpack/compose/components/app-bars?hl=es-419#bottom
    //////////////////////////////   //////////////////////////////   //////////////////////////////

    @Composable
    fun MyBottomNavigationMaterial3_v1(){
        var index by remember { mutableIntStateOf(0) }
        BottomAppBar(){
            Icon(
                imageVector=Icons.Default.Badge,
                contentDescription = null
            )
            Icon(
                imageVector=Icons.Default.Badge,
                contentDescription = null
            )
            Icon(
                imageVector=Icons.Default.Badge,
                contentDescription = null
            )
        }
    }




    //function to get the list of bottomNavigationItems
    fun bottomNavigationItems() : List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = "Home",
                icon = Icons.Filled.Home,
                route = Screens.Home.route
            ),
            BottomNavigationItem(
                label = "Search",
                icon = Icons.Filled.Search,
                route = Screens.Search.route
            ),
            BottomNavigationItem(
                label = "Profile",
                icon = Icons.Filled.AccountCircle,
                route = Screens.Profile.route
            ),
        )
    }
}


    sealed class Screens(val route : String) {
        object Home : Screens("home_route")
        object Search : Screens("search_route")
        object Profile : Screens("profile_route")
    }

    //initializing the data class with default parameters
    data class BottomNavigationItem(
        val label : String = "",
        val icon : ImageVector = Icons.Filled.Home,
        val route : String = ""
    )






