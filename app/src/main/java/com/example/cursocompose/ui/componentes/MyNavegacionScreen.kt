package com.example.cursocompose.ui.componentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cursocompose.ui.theme.CursocomposeTheme

class MyNavegacionScreen : ComponentActivity() {
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

    @Composable
    fun MyTest(){
        val navigationController = rememberNavController()
        NavHost(navController = navigationController, startDestination = "pantallaBlue") {
            composable("pantallaRed") { Screen1(navigationController)}
            composable("pantallaBlue") { Screen2(navigationController)}
            composable("pantallaBlack") { Screen3(navigationController)}

        }
    }

    @Composable
    fun Screen1(navigationController: NavHostController) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)){
            Text(text = "Screen Red", modifier=Modifier.align(Alignment.Center).clickable {
                navigationController.navigate("pantallaBlack")
            })
        }
    }

    @Composable
    fun Screen2(navigationController: NavHostController) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)){
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Screen Blue")
                Button(onClick = { navigationController.navigate("pantallaRed") }) {
                    Text(text = "Ir Pantlla red")
                }
            }
        }
    }

    @Composable
    fun Screen3(navigationController: NavHostController) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)){
            Text(text = "Screen Black", modifier=Modifier.align(Alignment.Center).clickable {
                navigationController.navigate("pantallaBlue")
            })
        }
    }
}

//todo: es peligros tener todas las ids puestas asi en duro
class MyNavegacionScreenOptima (){

    //todo el proyecto va leer de aki
    sealed class Routes(val route:String){
        object Pantalla1:Routes("pantalla1")
        object Pantalla2:Routes("pantalla2")
        object Pantalla3:Routes("pantalla3")
    }

    @Composable
    fun MyTest(){
        val navigationController = rememberNavController()
        NavHost(navController = navigationController, startDestination = Routes.Pantalla1.route) {
            composable(Routes.Pantalla1.route) { Screen1(navigationController)}
            composable(Routes.Pantalla2.route) { Screen2(navigationController)}
            composable(Routes.Pantalla3.route) { Screen3(navigationController)}

        }
    }

    @Composable
    fun Screen1(navigationController: NavHostController) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)){
            Text(text = "Screen Red", modifier=Modifier.align(Alignment.Center).clickable {
                navigationController.navigate(Routes.Pantalla1.route)
            })
        }
    }

    @Composable
    fun Screen2(navigationController: NavHostController) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)){
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Screen Blue")
                Button(onClick = { navigationController.navigate(Routes.Pantalla2.route) }) {
                    Text(text = "Ir Pantlla red")
                }
            }
        }
    }

    @Composable
    fun Screen3(navigationController: NavHostController) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)){
            Text(text = "Screen Black", modifier=Modifier.align(Alignment.Center).clickable {
                navigationController.navigate(Routes.Pantalla3.route)
            })
        }
    }


}

//todo: pasar argumentos OBLIGATORIOS
class MyNavegacionConArgumentosObligatorios (){

    //todo el proyecto va leer de aki
    sealed class Routes(val route:String){
        object Pantalla1:Routes("pantalla1")
        object Pantalla2:Routes("pantalla2")
        object Pantalla3:Routes("pantalla3")
        object Pantalla4:Routes("pantalla4/{name}"){
            fun createRoute(name:String)="pantalla4/$name"
        }

    }

    @Composable
    fun MyTest(){
        val navigationController = rememberNavController()
        NavHost(navController = navigationController, startDestination = Routes.Pantalla1.route) {
            composable(Routes.Pantalla1.route) { Screen1(navigationController)}
            composable(Routes.Pantalla2.route) { Screen2(navigationController)}
            composable(Routes.Pantalla3.route) { Screen3(navigationController)}
            composable(
                route = Routes.Pantalla4.route,//todo: mejorado
                arguments = listOf(navArgument("name"){
                    type= NavType.StringType
                })
            ) { backStackEntry ->
                Screen4(
                    navigationController,
                    backStackEntry.arguments?.getString("name").orEmpty()
                )
            }
            //mejorado otro tipo de datos
            composable(
                route="Pantalla5/{name}",
                arguments = listOf(navArgument("name"){
                    type= NavType.IntType
                })
            ) { backStackEntry ->
                Screen5(
                    navigationController,
                    backStackEntry.arguments?.getInt("old") ?: 0
                )
            }
        }
    }

    @Composable
    fun Screen1(navigationController: NavHostController) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)){
            Text(text = "Screen Red", modifier=Modifier.align(Alignment.Center).clickable {
                navigationController.navigate(Routes.Pantalla2.route)
            })
        }
    }

    @Composable
    fun Screen2(navigationController: NavHostController) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)){
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Screen Blue")
                Button(onClick = { navigationController.navigate(Routes.Pantalla3.route) }) {
                    Text(text = "Ir Pantlla red")
                }
            }
        }
    }

    //todo este es el bueno
    @Composable
    fun Screen3(navigationController: NavHostController) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)){
            Text(text = "Screen Black", modifier=Modifier.align(Alignment.Center).clickable {
                navigationController.navigate(Routes.Pantalla4.createRoute("misa ap"))
            })
        }
    }

    @Composable
    fun Screen4(navigationController: NavHostController, name:String) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)){
            Text(text = name, modifier=Modifier.align(Alignment.Center).clickable {
                navigationController.navigate("Pantalla5/30")
            })
        }
    }

    @Composable
    fun Screen5(navigationController: NavHostController, old:Int) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)){
            Text(text = "mi edad es: $old", modifier=Modifier.align(Alignment.Center).clickable {
                navigationController.navigate(Routes.Pantalla1.route)
            })
        }
    }

}

//todo: pasar argumentos OPCIONALES, EL 5TO ES OPTION
class MyNavegacionConArgumentosOPTION (){

    //todo el proyecto va leer de aki, PARA Q LO QUE KIERAS CAMBAOR CAMBIOALO, DESDE AKI
    sealed class Routes(val route:String){
        object Pantalla1:Routes("pantalla1")
        object Pantalla2:Routes("pantalla2")
        object Pantalla3:Routes("pantalla3")
        object Pantalla4:Routes("pantalla4/{name}"){
            fun createRoute(name:String)="pantalla4/$name"
        }
        //TODO: OPTIONAL
        object Pantalla5:Routes("pantalla5?name={name}"){
            fun createRoute(old:Int)="pantalla5?$old"
            fun sinArgumentos()="pantalla5"
        }

    }

    @Composable
    fun MyTest(){
        val navigationController = rememberNavController()
        NavHost(navController = navigationController, startDestination = Routes.Pantalla1.route) {
            composable(Routes.Pantalla1.route) { Screen1(navigationController)}
            composable(Routes.Pantalla2.route) { Screen2(navigationController)}
            composable(Routes.Pantalla3.route) { Screen3(navigationController)}
            composable(
                route = Routes.Pantalla4.route,//todo: mejorado
                arguments = listOf(navArgument("name"){
                    type= NavType.StringType
                })
            ) { backStackEntry ->
                Screen4(
                    navigationController,
                    backStackEntry.arguments?.getString("name").orEmpty()
                )
            }
            //todo: opcional
            composable(
                route=Routes.Pantalla5.route,
                arguments = listOf(navArgument("old") { defaultValue = "10" })
            ) { backStackEntry ->
                Screen5(
                    navigationController,
                    backStackEntry.arguments?.getInt("old") ?: 0
                )
            }
        }
    }

    @Composable
    fun Screen1(navigationController: NavHostController) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)){
            Text(text = "Screen Red", modifier=Modifier.align(Alignment.Center).clickable {
                navigationController.navigate(Routes.Pantalla2.route)
            })
        }
    }

    @Composable
    fun Screen2(navigationController: NavHostController) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)){
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Screen Blue")
                Button(onClick = { navigationController.navigate(Routes.Pantalla3.route) }) {
                    Text(text = "Ir Pantlla red")
                }
            }
        }
    }


    @Composable
    fun Screen3(navigationController: NavHostController) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)){
            Text(text = "Screen Black", modifier=Modifier.align(Alignment.Center).clickable {
                navigationController.navigate(Routes.Pantalla4.createRoute("misa ap"))
            })
        }
    }

    //todo: no paso nada
    @Composable
    fun Screen4(navigationController: NavHostController, name:String) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)){
            Text(text = name, modifier=Modifier.align(Alignment.Center).clickable {
                //navigationController.navigate("pantalla5")
                navigationController.navigate(Routes.Pantalla5.sinArgumentos())
            })
        }
    }

    @Composable
    fun Screen5(navigationController: NavHostController, old:Int) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)){
            Text(text = "mi edad es: $old", modifier=Modifier.align(Alignment.Center).clickable {
                navigationController.navigate(Routes.Pantalla1.route)
            })
        }
    }

}