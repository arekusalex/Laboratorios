package com.arekusalex.lab05.ui.movie.billboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.arekusalex.lab05.R
import com.arekusalex.lab05.data.model.MovieModel
import com.arekusalex.lab05.databinding.FragmentBillboardBinding
import com.arekusalex.lab05.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter
import com.arekusalex.lab05.ui.movie.viewmodel.MovieViewModel

class BillboardFragment : Fragment() {
    private lateinit var firstCardView: CardView
    private lateinit var secondCardView: CardView
    private lateinit var newMovieButton: Button
    private lateinit var adapter: MovieRecyclerViewAdapter
    private lateinit var binding: FragmentBillboardBinding

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()

        setRecyclerView(view)

        firstCardView.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragment_main_to_fragment_first)
        }
        newMovieButton.setOnClickListener {
            movieViewModel.clearData()
            it.findNavController().navigate(R.id.action_fragment_main_to_fragment_second)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBillboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun showSelectedItem(movie: MovieModel) {
        movieViewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_fragment_main_to_fragment_second)
    }

    private fun displayMovies() {
        adapter.setData(movieViewModel.getMovies())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = MovieRecyclerViewAdapter {
            selectedMovie -> showSelectedItem((selectedMovie))
        }

        binding.recyclerView.adapter = adapter
        displayMovies()
    }

    private fun bind () {
        firstCardView = view?.findViewById(R.id.first_movie_card) as CardView
        newMovieButton = view?.findViewById(R.id.fab)!!
    }

}