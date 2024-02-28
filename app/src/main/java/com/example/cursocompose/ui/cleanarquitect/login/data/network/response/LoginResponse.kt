package com.example.cursocompose.ui.cleanarquitect.login.data.network.response

import com.google.gson.annotations.SerializedName


//simpre pon serealizer name, no lo puedes poner pero deber eser el mismo nombre del objeto
//con serialized le puedes poner otro nombre, y si se ofusca no hay lio
data class LoginResponse (@SerializedName ("success")val success:Boolean)