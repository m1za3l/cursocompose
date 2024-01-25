package com.example.cursocompose.ui.layouts

import android.graphics.drawable.Icon
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.twotone.Face
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.runtime.*
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cursocompose.R

class ExercisesLayouts {

    @Composable
    fun CardTwitter(){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
            colors = CardDefaults.cardColors(
                contentColor = Color.White,
                containerColor = Color.Black,
            )
        ) {
            Row(modifier = Modifier) {
                IconUser()
                ContainerRight(Modifier)
            }
        }

    }


    @Composable
    fun IconUser() {
        Icon(modifier= Modifier
            .padding(2.dp)
            .size(55.dp),imageVector = Icons.Rounded.AccountCircle, contentDescription = "tres puntos")
    }

    @Composable
    fun ContainerRight(modifier: Modifier) {
        Column(modifier=Modifier.padding(8.dp)) {
            Titles()
            Spacer(modifier = Modifier.size(10.dp))
            Description()
            Spacer(modifier = Modifier.size(16.dp))
            ImageContainer()
            Spacer(modifier = Modifier.size(14.dp))

            val iconsPoints=MyConfigIcons()
            ThreeIcons(iconsPoints){

                iconsPoints.forEach{mIcon->
                   if(it.nameIcon == mIcon.nameIcon){
                       mIcon.onClick(mIcon.count, true)
                   }else{
                       mIcon.onClick(mIcon.count, false)
                   }
                }
            }
        }
    }


    @Composable
    fun Titles(){
        Row() {
            Text("Misa")
            Text("@MisaDevs")
            Text("4h")
            Icon(imageVector = Icons.Rounded.Close, contentDescription = "tres puntos")
        }
    }

    @Composable
    fun Description(){
        Text(" It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")
    }

    @Composable
    fun ImageContainer(){
        Image(painter = painterResource(id = R.drawable.fb), contentDescription = "Social lofin fb", Modifier.size(216.dp))

    }

    @Composable
    fun ThreeIcons( iconsPoints:List<IconPoint>,onClick:(IconPoint)->Unit){

        //una data class icon, colorEnaboe, conor, unable, contador
        Row(modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            iconsPoints.forEach{
                Row(modifier=Modifier
                    .clickable {
                    onClick(it)
                }
                ){

                        Icon(
                            imageVector = Icons.TwoTone.Face,
                            modifier = Modifier
                                .size(25.dp)
                                .align(Alignment.CenterVertically)
                                .background(
                                    shape=ShapeDefaults.Large,
                                    color= if(it.show){it.colorEnable}else{Color.Black}
                                )
                            ,
                            contentDescription = null,
                            tint =  if(it.show){Color.Black}else{it.colorEnable}
                        )

                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = it.count.toString())
                }
                Divider(modifier= Modifier
                    .width(1.dp)
                    .height(25.dp), color = Color.White)
                
            }
        }
    }

    data class IconPoint(
        val nameIcon :String = "",
        val resource: ImageVector = Icons.Rounded.AccountCircle,
        val colorEnable: Color=Color.Red,
        val show: Boolean=false,
        val count:Int=0,
        val onClick: (Int, Boolean) -> Unit)

    @Composable
    fun MyConfigIcons():List<IconPoint>{
        val colors = listOf(Color.Red ,Color.Blue, Color.Green)
        val enables = listOf(false ,true, false)
        val names = listOf("uno" ,"dos", "tres")
        val list = mutableListOf<IconPoint>()
        repeat(3){
            var mCount by remember{ mutableIntStateOf(0) }
            var mShow by remember{ mutableStateOf(enables[it]) }
            list.add(IconPoint(
                  colorEnable= colors[it],
                  count=mCount,
                  show=mShow,
                  nameIcon = names[it]
                ){ count, show ->
                if(mShow) {
                    mCount = count + 1
                }
                    mShow = show
                }
            )
        }
        return list
    }


}