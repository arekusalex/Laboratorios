package com.arekusalex.labo5.repositories

import com.arekusalex.labo5.data.model.MovieModel

class MovieRepository (private val movies: MutableList<MovieModel>) {

    fun getMovies() = movies

    fun addMovies(movie: MovieModel) = movies.add(movie)
}