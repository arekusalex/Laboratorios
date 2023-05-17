package com.arekusalex.labo5

import android.app.Application
import com.arekusalex.labo5.data.movies
import com.arekusalex.labo5.repositories.MovieRepository

class MovieReviewerApplication : Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}