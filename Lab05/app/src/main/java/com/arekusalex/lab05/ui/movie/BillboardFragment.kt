package com.arekusalex.lab05.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.arekusalex.lab05.R

class BillboardFragment : Fragment() {
    private lateinit var firstCardView: CardView
    private lateinit var secondCardView: CardView
    private lateinit var newMovieButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        firstCardView.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragment_main_to_fragment_first)
        }
        newMovieButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragment_main_to_fragment_second)
        }
    }

    private fun bind () {
        firstCardView = view?.findViewById(R.id.first_movie_card) as CardView
        secondCardView = view?.findViewById(R.id.second_movie_card) as CardView
        newMovieButton = view?.findViewById(R.id.fab)!!
    }

}