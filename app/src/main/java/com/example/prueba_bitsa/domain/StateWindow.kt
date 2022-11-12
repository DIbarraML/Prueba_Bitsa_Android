package com.example.prueba_bitsa.domain

enum class StateWindow {
    C,
    A,
    I,
    D;
}

fun StateWindow.getState(): String {
    return when (this) {
        StateWindow.C -> "Cerrado"
        StateWindow.A -> "Abierto"
        StateWindow.I -> "Ala Izquierda Abierta"
        StateWindow.D -> "Ala Derecha Abierta"
    }
}
