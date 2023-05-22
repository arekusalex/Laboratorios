package com.arekusalex.parcial1.repositories

import com.arekusalex.parcial1.data.model.RevistaModel

class RevistaRepository (private val revistas: MutableList<RevistaModel>) {
    fun getRevistas() = revistas

    fun addRevistas(movie: RevistaModel) = revistas.add(movie)
}