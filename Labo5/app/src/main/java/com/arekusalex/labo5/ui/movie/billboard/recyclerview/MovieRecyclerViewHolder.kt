package com.arekusalex.labo5.ui.movie.billboard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.arekusalex.labo5.data.model.MovieModel
import com.arekusalex.labo5.databinding.MovieItemBinding

class MovieRecyclerViewHolder (private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: MovieModel, clickListener: (MovieModel) -> Unit) {
        binding.movieTitleCard1.text = movie.name
        binding.movieScoreCard1.text = movie.qualification

        binding.firstMovieCard.setOnClickListener {
            clickListener(movie)
        }
    }
}