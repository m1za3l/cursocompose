package com.example.cursocompose.ui.componentes

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cursocompose.R
import com.example.cursocompose.ui.theme.CursocomposeTheme
import androidx.compose.runtime.*
import kotlinx.coroutines.launch

class RecyckerViews : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CursocomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    RecyckerViews().MyRecyclerWhitHeader()
                }
            }
        }
    }

    @Composable
    fun MyRecyclerBasic(){
        val myList = listOf("luu","jafis","nico","luu","jafis","nico","luu","jafis","nico","luu","jafis","nico")
        LazyColumn {
            //solo recibem items
            item{Text(text = "primer item") }
            item{Text(text = "segundo item") }
            //ya no a amno , con unrepeat
            items(3){
                Text(text = "count = $it")
            }
            //que los datos llegen de un lisatado
            items(myList){
                Text(text = "me llamo: $it")
            }
        }
    }

    @Composable
    fun MyRecyclerWhitHeader(){
        val myList = listOf("nico","luu","jafis","nico","luu","jafis","nico","luu","jafis","nico","luu","nico","luu","jafis","nico","luu","jafis","nico","luu","jafis","nico","luu","jafis","nico","luu","jafis","nico","luu","jafis","nico","luu","jafis","nico","luu","jafis","nico","luu","jafis","nico")
        LazyColumn {
            //solo recibem items
            item{
                Text(text = "HEADER",fontSize = 40.sp)
            }
            //que los datos llegen de un lisatado
            items(myList){
                Text(modifier= Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp),
                    text = "me llamo: $it",
                    fontSize = 30.sp
                    )
            }

            item{
                Text(text = "FOOTER",fontSize = 40.sp)
            }
        }
    }

    data class SuperHero(
        var superHeroName:String="",
        var realName:String,
        var publisher:String,
        @DrawableRes var photo:Int
        )

    private fun getSuperHero(): List<SuperHero> {
        return listOf(
            SuperHero("Spiderman","Petter Parker","Marvel", R.drawable.spiderman),
            SuperHero("Wolverine","Marvel","Marvel", R.drawable.logan),
            SuperHero("Batman","Bruce Wayne","DC", R.drawable.batman),
            SuperHero("Thor","Thor Odison","Marvel", R.drawable.thor),
            SuperHero("Flash","Jay Garrick","DC", R.drawable.flash),
            SuperHero("Green","Alan Scott","DC", R.drawable.green_lantern),
            SuperHero("Wonder Woman","Princess Diana","DC", R.drawable.wonder_woman),
            )
    }
    //ANCHO y alto FIJO
    //@Preview(showSystemUi = true)
    @Composable
    fun SuperHeroView(){
        val context = LocalContext.current
       LazyColumn() {
           items(4){
               LazyRow(modifier=Modifier.padding(10.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)){
                   items(getSuperHero()){superHero->
                       ItemHero(superHero){
                           Toast.makeText(context, it, Toast.LENGTH_LONG).show()
                       }
                   }
               }
               Spacer(modifier = Modifier.size(10.dp))
           }
        }

    }

    //@Preview(showSystemUi = true)
    @Composable
    fun SuperHeroGrid(){
        val context = LocalContext.current

        LazyVerticalGrid(
            //columns = GridCells.Fixed(2),
            columns = GridCells.Adaptive(100.dp),
            verticalArrangement =Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(12.dp),//esto es por fuera
            content = {
                items(getSuperHero()){superHero->
                ItemHero(superHero){
                    Toast.makeText(context, it, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    //@Preview(showSystemUi = true)
    @Composable
    fun SuperHeroRvState(){
        val context = LocalContext.current
        val rvState = rememberLazyListState()
        val showbutton by remember { derivedStateOf {rvState.firstVisibleItemIndex>0 }}
        val coroutineScope = rememberCoroutineScope()
        // un  minimo minimo escroll, comprobar, comprobar, un estado intermedio

        Column() {
            LazyColumn(
                state = rvState,
                modifier = Modifier
                    .padding(10.dp)
                    .weight(3f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(getSuperHero()) { superHero ->
                    ItemHero(superHero) {
                        Toast.makeText(context, it, Toast.LENGTH_LONG).show()
                    }
                }
            }

            Log.i("m1m1","{item a mostrarse : ${rvState.firstVisibleItemIndex}}")

            if (showbutton){
                TextButton(
                    modifier = Modifier
                        .padding(10.dp)
                        .background(Color.Blue)
                        .align(Alignment.CenterHorizontally),
                    onClick = {
                        coroutineScope.launch {
                            rvState.animateScrollToItem(0)
                        }
                    }) {
                    Text("aceptar", color = Color.White)
                }
            }
        }

    }

    //sticker Header
    //@Preview(showSystemUi = true)
    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun SuperHeroStickerView(){
        val context = LocalContext.current
        //un listado de nombra se agrupe por su nombre
        val superHero : Map<String,List<SuperHero>> = getSuperHero().groupBy { it.publisher }
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {

            superHero.forEach{(publisher,myHeros)->

                stickyHeader {
                    Text(
                        text = publisher,
                        modifier=Modifier
                            .fillMaxWidth()
                            .background(Color.Red),
                        fontWeight = FontWeight.Black,
                        fontSize = 20.sp,
                        color = Color.White
                    )
                }

                items(myHeros){myHero->
                    ItemHero(superHero = myHero){}
                }

            }

        }

    }

    @Composable
    fun ItemHero(superHero: SuperHero, onItemSelected:(String)->Unit) {
        Card(border = BorderStroke(
                        width=2.dp,
                        color=Color.Red),
            modifier = Modifier
                .width(200.dp)
                .clickable {
                    onItemSelected(superHero.superHeroName)
                }
        ) {
            Column (modifier=Modifier.padding(8.dp)){
                Image(
                    modifier=Modifier.fillMaxWidth(),
                    painter = painterResource(id = superHero.photo),
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop //para q ocupe el ancho
                )
                Text(
                    text = superHero.superHeroName,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Black
                )
                Text(
                    text = superHero.realName,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = superHero.publisher,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light
                )
            }
        }

    }

}