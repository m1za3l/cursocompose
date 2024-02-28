package com.example.cursocompose.ui.componentes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Pending
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.*

class MyFloatingButton {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyTest(){
        Scaffold(
            bottomBar = {MyBottomNavigation()},// añadirlo para ponerlo dentro del bottomBar
            floatingActionButton = {MyFAB() },
            floatingActionButtonPosition = FabPosition.Center, //mover el FAB
        ){
            it
            contentColorFor(backgroundColor = Color.Blue)
        }
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

    //Ponerlo en la navTabs
    //material 2 isfloatingactionbuttondocked
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
                label = { Text(text = "Pending") }
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
                label = { Text(text = "badge") }
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
                label = { Text(text = "home") }
            )
        }
    }


}