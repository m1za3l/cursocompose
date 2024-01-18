package com.example.cursocompose.ui.layouts.constraits

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.cursocompose.ui.theme.CursocomposeTheme

class ConstraitActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CursocomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    //arriba e izquierda
    fun ExampleConstrait(){
        ConstraintLayout(modifier=Modifier.fillMaxSize()) {
            //crear muktiples variables si son del mismo tipo
            val(boxMangenta,
                boxRed,
                BoxBlue,
                BoxYelow,
                BoxGreen) = createRefs()

            Box(modifier = Modifier
                .background(Color.Magenta)
                .size(40.dp)
                .constrainAs(boxMangenta) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                })
            Box(modifier = Modifier
                .background(Color.Red)
                .size(40.dp)
                .constrainAs(boxRed) {
                    top.linkTo(boxMangenta.bottom)
                    end.linkTo(boxMangenta.start)
                })
            Box(modifier = Modifier
                .background(Color.Blue)
                .size(40.dp)
                .constrainAs(BoxBlue) {
                    bottom.linkTo(boxMangenta.top)
                    start.linkTo(boxMangenta.end)
                })
            Box(modifier = Modifier
                .background(Color.Yellow)
                .size(40.dp)
                .constrainAs(BoxYelow) {
                    bottom.linkTo(boxMangenta.top)
                    end.linkTo(boxMangenta.start)
                })

            Box(modifier = Modifier
                .background(Color.Green)
                .size(40.dp)
                .constrainAs(BoxGreen) {
                    top.linkTo(boxMangenta.bottom)
                    start.linkTo(boxMangenta.end)
                })
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ConstaritExampleGuide(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        //UNA LINEA abajo al 10%

        val boxRed = createRef()
        val topGuide = createGuidelineFromTop(0.1f)
        val starGuide=createGuidelineFromStart(0.1f)

        Box(modifier=Modifier.size(40.dp).background(Color.Red).constrainAs(boxRed){
            top.linkTo(topGuide)
            start.linkTo(starGuide)
        })

    }
}

//barrera una jaula nadie puede entrar
@Preview(showSystemUi = true)
@Composable
fun ConstaritExampleBarrier(){
    ConstraintLayout(modifier=Modifier.fillMaxSize()){


        val(boxYellow,
            boxRed ,
            boxGreen) = createRefs()
        val barrier = createEndBarrier(boxRed,boxGreen)


        Box(modifier=Modifier.background(Color.Green).size(85.dp).constrainAs(boxGreen){
            start.linkTo(parent.start, margin = 15.dp)
        })
        Box(modifier=Modifier.background(Color.Red).size(225.dp).constrainAs(boxRed){
            top.linkTo(boxGreen.bottom)
            start.linkTo(parent.start, margin = 35.dp)
        })
        Box(modifier=Modifier.background(Color.Yellow).size(55.dp).constrainAs(boxYellow){
            start.linkTo(barrier)
        })
    }
}

//cadenas
@Preview(showSystemUi = true)
@Composable
fun ConstraintChainExample(){
    ConstraintLayout(modifier=Modifier.fillMaxSize()){


        val(boxYellow,
            boxRed ,
            boxGreen) = createRefs()


        Box(modifier=Modifier.background(Color.Green).size(75.dp).constrainAs(boxGreen){


        })
        Box(modifier=Modifier.background(Color.Red).size(75.dp).constrainAs(boxRed){

        })
        Box(modifier=Modifier.background(Color.Yellow).size(75.dp).constrainAs(boxYellow){

        })

        createHorizontalChain(boxRed,boxGreen,boxYellow, chainStyle = ChainStyle.Packed)
    }
}