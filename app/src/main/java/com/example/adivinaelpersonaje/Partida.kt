package com.example.adivinaelpersonaje

import java.util.*

data class Partida(
    val id_partida: Int,
    val id_jugadorW: Int,
    val id_jugadorL: Int,
    val puntaje: Int,
    val fecha: String
)