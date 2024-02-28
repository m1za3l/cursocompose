package com.example.cursocompose.ui.telcel.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cursocompose.ui.theme.CursocomposeTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.ui.platform.LocalContext
import com.example.cursocompose.ui.componentes.RecyckerViews


class HelpScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CursocomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    RecyckerViews().SuperHeroStickerView()
                }
            }
        }
    }

    data class Helps(val title : String)

    fun getServicesOne():List<String>{
        return listOf("Telcel Bot","Por Telefono", "Por correo electronico", "Centro de atencion a clientes")
    }

    fun getServicesTwo():List<String>{
        return listOf("Notificaciones","Terminos y condiciones", "Aviso de Privacidad")
    }

    fun getIcons():List<ImageVector>{
        return listOf(
            Icons.Default.CardTravel,
            Icons.Default.Facebook,
            Icons.Default.YoutubeSearchedFor,
            Icons.Default.Fingerprint)
    }

    @Preview (showSystemUi = true)
    @Composable
    fun ScreenHelp() {
        Column(modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .background(Color(0XFFEBF3F7))){
                Titles("Contactanos")
                Options(getServicesOne())
                Titles("Acerca de Telcel")
                Options(getServicesTwo())
                Spacer(modifier = Modifier.size(16.dp))
                SubTitles("Version 15.6.0",Modifier.align(Alignment.CenterHorizontally))
                SubTitles("2024 Radiomovil Dipsa S.A de C.V",Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.size(16.dp))
                Icons(getIcons())
        }
    }

    @Composable
    fun Icons(icons: List<ImageVector>) {
        val context = LocalContext.current
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, bottom = 30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            icons.forEach {
                Icon(
                    imageVector = it,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp).clickable {
                        Toast.makeText(context, "hola", Toast.LENGTH_LONG).show()
                    },
                    tint=Color.Blue)
            }
        }
    }

    @Composable
    fun Options(services: List<String>) {
        Column(){
            services.forEach {
                ItemTitle(title = it)
            }
        }
    }

    @Composable
    fun Titles(title:String){
        Text(
            modifier = Modifier.padding(10.dp),
            text = title,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }

    @Composable
    fun SubTitles(title: String, modifier: Modifier){
        Text(
            modifier = modifier.padding(10.dp),
            text = title,
            color = Color(0XFF545556),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }

    @Composable
    fun ItemTitle(title: String) {
        val context = LocalContext.current
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp).clickable {
                    Toast.makeText(context, title, Toast.LENGTH_SHORT).show()
                },
            shape = ShapeDefaults.Small,
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = title,
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }


}