package com.arekusalex.lab05

import android.app.Application
import com.arekusalex.lab05.data.movies
import com.arekusalex.lab05.repositories.MovieRepository

class MovieReviewerApplication : Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}