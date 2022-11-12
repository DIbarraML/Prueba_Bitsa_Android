package com.example.prueba_bitsa.domain

class CastleGame {

    private val persons: List<Int> = List(NUM_PERSONS) { it + 1 }
    val windows: List<Window> = List(NUM_WINDOWS) { Window(it + 1) }

    init {
        actionsWindowsWithPersons(windows)
    }

    fun actionsWindowsWithPersons(windows: List<Window>) {
        persons.map { indexPerson ->
            for (numWindow in indexPerson..windows.size step indexPerson) {
                changeState(numWindow, windows)
            }
        }
    }

    fun changeState(numWindow: Int, windows: List<Window>) {
        when {
            numWindow == 1 -> windows[0].stateWindow = StateWindow.I
            numWindow == 2 -> windows[numWindow - 1].stateWindow = StateWindow.A
            (numWindow % 2 == 0) -> windows[numWindow - 1].stateWindow = StateWindow.D
            else -> windows[numWindow - 1].stateWindow = StateWindow.I
        }
    }

    fun searchWins(windows: List<Window>): MutableList<Int> {
        val listPersonsWins: MutableList<Int> = mutableListOf()
        windows.mapIndexed { index, window ->
            if (window.stateWindow == StateWindow.A &&
                windows[index - 1].stateWindow == StateWindow.C &&
                windows[index + 1].stateWindow == StateWindow.C
            ) {
                listPersonsWins.add(window.numWindow)
            }
        }
        return listPersonsWins
    }

    fun  getStateAllWindows(windows: List<Window>): List<String> {
        val listStateWindow: MutableList<String> = mutableListOf()
        windows.map {
            listStateWindow.add(it.stateWindow.getState())
        }
        return listStateWindow
    }

    fun searchMoreWins(windows: List<Window>): MutableList<Int> {
        val listPersonsWins: MutableList<Int> = mutableListOf()
        windows.mapIndexed { _, window ->
            if (window.stateWindow == StateWindow.A) {
                listPersonsWins.add(window.numWindow)
            }
        }
        return listPersonsWins
    }

    fun getCountWindowOpen(): Int {
        var count = 0
        windows.map {
            if (it.stateWindow == StateWindow.A) count++
        }
        return count
    }

    fun getCountWindowClosed(): Int {
        var count = 0
        windows.map {
            if (it.stateWindow == StateWindow.C) count++
        }
        return count
    }

    fun getCountWindowLeft(): Int {
        var count = 0
        windows.map {
            if (it.stateWindow == StateWindow.I) count++
        }
        return count
    }

    fun getCountWindowRight(): Int {
        var count = 0
        windows.map {
            if (it.stateWindow == StateWindow.D) count++
        }
        return count
    }

    fun resetList() {
        windows.map {
            it.stateWindow = StateWindow.A
        }
        windows.map {
            println("RESETLIS ->${it.stateWindow.name}")
        }
    }

    companion object {
        private const val NUM_WINDOWS = 64
        private const val NUM_PERSONS = NUM_WINDOWS
    }

}