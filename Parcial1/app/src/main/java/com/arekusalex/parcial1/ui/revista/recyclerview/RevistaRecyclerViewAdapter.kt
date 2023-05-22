package com.arekusalex.parcial1.ui.revista.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import com.arekusalex.parcial1.data.model.RevistaModel

import androidx.recyclerview.widget.RecyclerView

class RevistaRecyclerViewAdapter(private val clickListener: (RevistaModel)-> Unit) : RecyclerView.Adapter<RevistaRecyclerViewHolder>() {
    private val revistas = ArrayList<RevistaModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RevistaRecyclerViewHolder {
        val binding =  RevistaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RevistaRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return revistas.size
    }
}


























/*
* package com.example.laboratorio05.ui.movie.home.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.databinding.MovieItemBinding
import com.example.laboratorio05.ui.movie.viewmodel.MovieViewModel

class MovieRecyclerViewAdapter(
    private val clickListener: (MovieModel)-> Unit
) : RecyclerView.Adapter<MovieRecyclerViewHolder>(){
    private val movies = ArrayList<MovieModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRecyclerViewHolder {
        val binding =  MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieRecyclerViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie, clickListener)
    }

    fun setData(moviesList: List<MovieModel>){MovieViewModel
        movies.clear()
        movies.addAll(moviesList)
    }
}
*
*
* package com.example.laboratorio05.ui.movie.home.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.databinding.MovieItemBinding

class MovieRecyclerViewHolder(private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: MovieModel, clickListener: (MovieModel)-> Unit){
        binding.movieItemTitleTextView.text = movie.name
        binding.movieItemCalificationTextView.text = movie.qualification

        binding.movieItemCardView.setOnClickListener{
            clickListener(movie)
        }
    }

}*/