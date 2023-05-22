package com.arekusalex.parcial1.ui.revista.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.arekusalex.parcial1.data.model.RevistaModel
import com.arekusalex.parcial1.databinding.RevistaItemBinding

class RevistaRecyclerViewHolder(private val binding: RevistaItemBinding): RecyclerView.ViewHolder(binding.root)  {
    fun bind(revista: RevistaModel, clickListener: (RevistaModel)-> Unit){
        binding.revistaItemNameTextView.text = revista.name
        binding.revistaItemSubjectTextView.text = revista.subject

        binding.revistaItemCardView.setOnClickListener{
            clickListener(revista)
        }
    }
}