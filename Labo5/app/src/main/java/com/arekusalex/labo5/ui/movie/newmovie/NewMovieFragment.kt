package com.arekusalex.labo5.ui.movie.newmovie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.arekusalex.labo5.R
import com.arekusalex.labo5.data.model.MovieModel
import com.arekusalex.labo5.databinding.FragmentNewMovieBinding
import com.arekusalex.labo5.ui.movie.viewmodel.MovieViewModel
import com.google.android.material.textfield.TextInputEditText

class NewMovieFragment : Fragment() {

    private lateinit var nameEditText: TextInputEditText
    private lateinit var categoryEditText: TextInputEditText
    private lateinit var descriptionEditText: TextInputEditText
    private lateinit var qualificationEditText: TextInputEditText
    private lateinit var submitButton: Button
    private lateinit var _binding: FragmentNewMovieBinding
    private val binding get() = _binding

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewMovieBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    Button()
                }
            }
        }
        return view
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

    private fun setViewModel() {
        binding.viewmodel = movieViewModel
    }

    private fun observeStatus() {
        movieViewModel.status.observe(viewLifecycleOwner) {
                status -> when {
            status.equals(MovieViewModel.WRONG_INFORMATION) -> {
                Log.d("APP_TAG", status)
                movieViewModel.clearStatus()
            }
            status.equals(MovieViewModel.MOVIE_CREATED) -> {
                Log.d("APP_TAG", status)
                Log.d("APP_TAG", movieViewModel.getMovies().toString())

                movieViewModel.clearStatus()
                findNavController().popBackStack()
            }
        }

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
