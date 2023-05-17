package com.arekusalex.lab05.ui.movie.billboard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.arekusalex.lab05.data.model.MovieModel
import com.arekusalex.lab05.databinding.MovieItemBinding

class MovieRecyclerViewHolder (private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: MovieModel, clickListener: (MovieModel) -> Unit) {
        binding.movieTitleCard1.text = movie.name
        binding.movieScoreCard1.text = movie.qualification

        binding.firstMovieCard.setOnClickListener {
            clickListener(movie)
        }
    }
}