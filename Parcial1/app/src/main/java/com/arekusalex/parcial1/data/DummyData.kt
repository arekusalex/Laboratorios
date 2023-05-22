package com.arekusalex.parcial1.data

import com.arekusalex.parcial1.data.model.RevistaModel

val name = "Blur"
val subject = "Entretenimiento"

val name2 = "El Economista"
val subject2 = "Finanzas"

var revistas = mutableListOf(
    RevistaModel(name, subject),
    RevistaModel(name2, subject2)
)

