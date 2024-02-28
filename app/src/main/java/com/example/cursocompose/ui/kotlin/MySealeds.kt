package com.example.cursocompose.ui.kotlin


data class GameModel(val title:String, val serialNumber: String,val error:GameError,)

sealed class GameError(){
    object RayadoError:GameError()
    object InternetError:GameError()
    object NoError:GameError()
    object CongeladoError:GameError()

    data class VersionError(val version:String):GameError()
}

class MySealeds {

    val gameList = listOf(
        GameModel("Mario","1", GameError.RayadoError),
        GameModel("Mario 1","2", GameError.InternetError),
        GameModel("Mario 2","3", GameError.NoError),
        GameModel("Mario 3","4", GameError.CongeladoError) ,
        GameModel("Mario 3","4", GameError.VersionError("1.2.3"))
    )

    /*
    todo: Sealed class
    1.- te da las opciones el when
    2.- clean architectures
    3.-
     */
    fun logicGame(){
        gameList.forEach {game->
            when(game.error){
                GameError.CongeladoError -> llevarAlSoporte()
                GameError.InternetError -> eliminarJuego()
                GameError.NoError -> vender()
                GameError.RayadoError -> regalaJuego()
                is GameError.VersionError -> consultarVersion(game.error.version)
            }
        }
    }

    private fun consultarVersion(version: String) {
        TODO("Not yet implemented")
    }

    private fun regalaJuego() {
        TODO("Not yet implemented")
    }

    private fun vender() {
        TODO("Not yet implemented")
    }

    private fun eliminarJuego() {
        TODO("Not yet implemented")
    }

    private fun llevarAlSoporte() {
        TODO("Not yet implemented")
    }

}