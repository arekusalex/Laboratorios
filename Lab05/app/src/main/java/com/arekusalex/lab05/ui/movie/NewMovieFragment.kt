package com.arekusalex.lab05.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import com.arekusalex.lab05.R
import com.arekusalex.lab05.data.category
import com.arekusalex.lab05.data.model.MovieModel
import com.google.android.material.textfield.TextInputEditText

class NewMovieFragment : Fragment() {

    private lateinit var nameEditText: TextInputEditText
    private lateinit var categoryEditText: TextInputEditText
    private lateinit var descriptionEditText: TextInputEditText
    private lateinit var qualificationEditText: TextInputEditText
    private lateinit var submitButton: Button

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.new_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        submitButton.setOnClickListener {
            movieViewModel.addMovies(
                MovieModel(
                    name = nameEditText.text.toString(),
                    category = categoryEditText.text.toString(),
                    description = descriptionEditText.text.toString(),
                    qualification = qualificationEditText.text.toString()
                )
            )

            Log.d("List: ", movieViewModel.getMovies().toString())
        }
    }

    private fun bind () {
        nameEditText = view?.findViewById(R.id.name_input)!!
        categoryEditText = view?.findViewById(R.id.category_input)!!
        descriptionEditText =  view?.findViewById(R.id.description_input)!!
        qualificationEditText = view?.findViewById(R.id.score_input)!!
        submitButton = view?.findViewById(R.id.submit_buton)!!
    }

}