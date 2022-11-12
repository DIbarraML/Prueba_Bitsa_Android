package com.example.prueba_bitsa.ui

import androidx.lifecycle.ViewModel
import com.example.prueba_bitsa.domain.CastleGame
import com.example.prueba_bitsa.domain.Window
import com.example.prueba_bitsa.domain.getState

class CastleViewModel : ViewModel() {

    private val castleGame = CastleGame()

    fun windowList() = castleGame.windows

    fun countWindowsOpen() = castleGame.getCountWindowOpen()

    fun countWindowsClosed() = castleGame.getCountWindowClosed()

    fun countWindowsLeft() = castleGame.getCountWindowLeft()

    fun countWindowsRight() = castleGame.getCountWindowRight()

    fun getAllStateWindows() =
        castleGame.getStateAllWindows(windowList())

    fun printStringState(): List<String> {
        val mutableList = mutableListOf<String>()
        windowList().map { window ->
            mutableList.add("Ventana #${window.numWindow} -> ${window.stateWindow.getState()}")
        }
        return mutableList
    }

    fun printWins(): List<String> {
        val mutableList = mutableListOf<String>()
        castleGame.searchWins(windowList()).map {
            mutableList.add("Jugador #${it}")
        }
        if (mutableList.isEmpty()) {
            mutableList.add("No se encontraron ganadores")
        }
        return mutableList
    }

    fun printMoreWins(): List<String> {
        val mutableList = mutableListOf<String>()
        castleGame.searchMoreWins(windowList()).map {
            mutableList.add("Jugador #${it}")
        }
        if (mutableList.isEmpty()) {
            mutableList.add("No se encontraron ganadores")
        }
        return mutableList
    }

    fun resetList() {
        castleGame.resetList()
    }

    fun runAgain() {
        castleGame.actionsWindowsWithPersons(windowList())
    }
}