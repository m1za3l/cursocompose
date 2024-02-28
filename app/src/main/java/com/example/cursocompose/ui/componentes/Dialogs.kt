package com.example.cursocompose.ui.componentes

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

class Dialogs {

    @Composable
    fun MyDialogBasic(){
        AlertDialog(
            confirmButton = {
                //pon esto de a chaleco
                            TextButton(onClick = { /*TODO*/ }) {
                                Text(text = "Confirm button")
                            }
            } ,
            onDismissRequest = {
                //pon esto de a chaleco
            },
            dismissButton = {
                            TextButton(onClick = { /*TODO*/ }) {
                                Text(text = "DismissButton")
                            }
            }
            ,
            title = {
                Text(text = "Titulo")
            },
            text = { Text(text = "contenido de mensaje")}
        )

    }

    /*
     var onOffDialog by remember { mutableStateOf(false) }
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(onClick = { onOffDialog = true }) {
                            Text(text = "Mostrar boton")
                        }
                    }
                    Dialogs().MyAlertDialogOnOffShow(
                        show=onOffDialog,
                        confirmButton = {Log.i("m1m1","confirmado")},
                        //Todo:unica fuente de la verdad, pudo a ver sido en el pase de parametros false, pero es mejor aki
                        dismissButton = {onOffDialog=false}
                        )
     */

    @Composable
    fun MyAlertDialogOnOffShow(show: Boolean,
                          confirmButton:()->Unit,
                            dismissButton:()->Unit){
        if(show){
            AlertDialog(
                confirmButton = {
                    //pon esto de a chaleco
                    TextButton(onClick = {
                        confirmButton()
                    }) {
                        Text(text = "Confirm button")
                    }
                } ,
                onDismissRequest = {
                    //pon esto de a chaleco
                    dismissButton()
                },
                dismissButton = {
                    TextButton(onClick = {
                                            dismissButton()
                    }) {
                        Text(text = "DismissButton")
                    }
                }
                ,
                title = {
                    Text(text = "Titulo")
                },
                text = { Text(text = "contenido de mensaje")}
            )
        }

    }


    //custom dialog
    //todo: forzar que el usaurio no haga nada por que debe hacer algo
    @Composable
    fun MySimpleCustomDialog(show: Boolean, onDismiss: () -> Unit) {
        //meter la vista que queremos
        if (show) {

                Dialog(
                    onDismissRequest = { onDismiss() },
                    properties = DialogProperties(
                        dismissOnBackPress = false,
                        dismissOnClickOutside = false
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .background(Color.White)
                            .padding(24.dp)
                            .fillMaxWidth()

                    ) {
                        Text(text = "MY dialog simple")
                        Text(text = "MY dialog simple")

                        Text(text = "MY dialog simple")

                    }
                }


            }

        }

    /*  poinlo en el main VC
    var show by remember { mutableStateOf(false) }
                    var user by remember { mutableStateOf("none") }

                    val emails = listOf<String>("ejemplo1@gmail.com","ejemplo2@gmail.com","ejemplo3@gmail.com")

                    val accounts = emails.map {
                        Dialogs.Accounts(it)
                    }


                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center,

                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(text = "Cuenta seleccionada: $user")
                            Spacer(modifier = Modifier.size(20.dp))
                            Button(onClick = { show = true }) {
                                Text(text = "Mostrar Cuentas")
                            }

                        }

                    }

                    Dialogs().MyCustomDialogCUENTAS(
                        show=show,
                        accounts=accounts,
                        onDismiss = {show=false},
                            onClick = {
                                user=it
                                show=false
                            }
                    )
     */

    //google cambair de cuenta
    @Composable
    fun MyCustomDialogCUENTAS(show:Boolean, accounts:List<Accounts>, onDismiss: () -> Unit, onClick: (String) -> Unit){

        if (show) {

          Dialog(onDismissRequest = { onDismiss()}) {
              Column(modifier= Modifier
                  .fillMaxWidth()
                  .padding(14.dp)
                  .background(Color.White)) {
                  accounts.forEach {
                      MyAccounts(it,onClick)
                  }

              }

          }


        }


    }


    @Composable
    fun MyAccounts(user: Accounts, onClick: (String) -> Unit) {
        Row(modifier= Modifier
            .padding(14.dp)
            .clickable {
                onClick(user.email)
                Log.i("m1m1", "cuenta seleccionada: ${user.email}")
            }) {
            Icon(imageVector = user.resource,
                contentDescription = null,
                tint=Color.Red)
            Spacer(modifier = Modifier.size(20.dp))
            Text(text = user.email)
        }
    }

    data class Accounts(val email:String, val resource: ImageVector = Icons.Rounded.AccountCircle)


    //todo selecciona una unica opcion, con radioButton

    data class Users(val name:String="", var status :Boolean=false )


    /*
    var show by remember { mutableStateOf(false) }
                    var user by remember { mutableStateOf("none") }

                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center,

                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(text = "Cuenta seleccionada: $user")
                            Spacer(modifier = Modifier.size(20.dp))
                            Button(onClick = { show = true }) {
                                Text(text = "Mostrar Cuentas")
                            }

                        }

                    }

                    Dialogs().MyDialogSeleccionYAcepta(
                        show=show,
                        onDismiss = {show=false},
                        onChangeText = {
                            show=false
                            user=it
                        }
                    )
     */

    @Composable
    fun MyDialogSeleccionYAcepta(show: Boolean, onDismiss: () -> Unit, onChangeText: (String)->Unit) {

        val names = listOf("lulu", "jafis", "nico", "misa")
        var logic by remember{ mutableStateOf("") }


        val users = names.map {
            //todo: muy importante esta bariable debe estar adentro, porque corresponde acada objeto
            var status by remember{ mutableStateOf(false) }
            Users(name=it,
                status=false)
        }

        users.forEach{ if(it.name==logic) {
                it.status = true
            }
        }

        if (show) {
            Dialog(
                onDismissRequest = { onDismiss() }) {
                Column(
                    modifier = Modifier
                        .padding(14.dp)
                        .background(Color.White)
                ) {


                    users.forEach {
                        //el que regrese en true
                        //lo asocias con el usuario
                        //recorres toda la lista
                        //todos en falso
                        //solo el del nombre lo pones en true
                        MyUserRadioBtn(it){name->
                            logic=name
                        }
                    }

                    Row(Modifier.fillMaxWidth(), horizontalArrangement=Arrangement.SpaceBetween){

                        TextButton(onClick = { onChangeText(logic) },
                            modifier = Modifier
                                .background(Color.Blue)
                                .weight(1f)) {
                            Text(
                                text = "Aceptar",
                                color = Color.White

                            )
                        }
                        TextButton(onClick = { onDismiss() },
                            modifier = Modifier
                                .background(Color.Red)
                                .weight(1f)) {
                            Text(
                                text = "Cancelar",
                                color = Color.White
                            )
                        }
                    }
                }
            }

        }
    }

    @Composable
    fun MyUserRadioBtn(user: Users, onClick: (String) -> Unit) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            //horizontalArrangement = Arrangement.Center
        ) {

            RadioButton(selected = user.status, onClick = {
                onClick(user.name)
            })
            Text(text = user.name)
        }

    }


}