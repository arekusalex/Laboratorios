package com.arekusalex.lab05.repositories

import com.arekusalex.lab05.data.model.MovieModel

class MovieRepository (private val movies: MutableList<MovieModel>) {

    fun getMovies() = movies

    fun addMovies(movie: MovieModel) = movies.add(movie)
}