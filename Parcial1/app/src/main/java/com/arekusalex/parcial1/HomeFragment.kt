package com.arekusalex.parcial1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.arekusalex.parcial1.data.model.RevistaModel
import com.arekusalex.parcial1.databinding.FragmentHomeBinding
import com.arekusalex.parcial1.ui.revista.recyclerview.RevistaRecyclerViewAdapter
import com.arekusalex.parcial1.ui.revista.viewmodel.RevistaViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment() {
        private lateinit var addRevistaFloatingActionButton: FloatingActionButton
        private lateinit var adapter: RevistaRecyclerViewAdapter
        private lateinit var binding: FragmentHomeBinding

        private val movieViewModel: RevistaViewModel by activityViewModels {
            RevistaViewModel.Factory
        }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            binding = FragmentHomeBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            setRecyclerView(view)

            binding.floatingActionButton.setOnClickListener {
                movieViewModel.clearData()
                it.findNavController().navigate(R.id.action_homeFragment_to_newRevistaFragment)
            }
        }

        private fun showSelectedItem(movie: RevistaModel){
            movieViewModel.setSelectedRevista(movie)
            findNavController().navigate(R.id.action_homeFragment_to_revistaFragment)
        }

        private fun displayRevistas(){
            adapter.setData(movieViewModel.getRevistas())
            adapter.notifyDataSetChanged()
        }

        private fun setRecyclerView(view: View) {
            binding.revistaRecyclerView.layoutManager = LinearLayoutManager(view.context)
            adapter = RevistaRecyclerViewAdapter { selectedRevista ->
                showSelectedItem(selectedRevista)
            }
            binding.revistaRecyclerView.adapter = adapter
            displayRevistas()
        }

}