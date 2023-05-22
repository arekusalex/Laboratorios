package com.arekusalex.parcial1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.arekusalex.parcial1.databinding.FragmentRevistaBinding
import com.arekusalex.parcial1.ui.revista.viewmodel.RevistaViewModel

class RevistaFragment : Fragment() {
    private val revistaViewModel: RevistaViewModel by activityViewModels {
        RevistaViewModel.Factory
    }

    private lateinit var binding: FragmentRevistaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRevistaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
    }

    private fun setViewModel(){
        binding.viewmodel = revistaViewModel
    }
}