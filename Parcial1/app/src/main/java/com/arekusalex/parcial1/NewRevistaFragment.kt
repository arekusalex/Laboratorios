package com.arekusalex.parcial1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.arekusalex.parcial1.databinding.FragmentNewRevistaBinding
import com.arekusalex.parcial1.ui.revista.viewmodel.RevistaViewModel

class NewRevistaFragment : Fragment() {
    private val revistaViewModel: RevistaViewModel by activityViewModels {
        RevistaViewModel.Factory
    }

    private lateinit var binding: FragmentNewRevistaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewRevistaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()
    }

    private fun setViewModel(){
        binding.viewmodel = revistaViewModel
    }

    private fun observeStatus(){
        revistaViewModel.status.observe(viewLifecycleOwner) {
                status ->
            when {
                status.equals(RevistaViewModel.WRONG_INFORMATION) -> {
                    Log.d("APP_TAG", status)
                    revistaViewModel.clearStatus()
                }
                status.equals(RevistaViewModel.REVISTA_CREATED) -> {
                    Log.d("APP_TAG", status)
                    Log.d("APP_TAG", revistaViewModel.getRevistas().toString())

                    revistaViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }
}