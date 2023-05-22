package com.arekusalex.parcial1.ui.revista.recyclerview

import com.arekusalex.parcial1.data.model.RevistaModel

class RevistaRecyclerViewHolder {
    fun bind(movie: RevistaModel, clickListener: (RevistaModel)-> Unit){
        binding.revistaItemNameTextView.text = revista.name
        binding.revistaItemTextView.text = revista.qualification

        binding.revistaItemCardView.setOnClickListener{
            clickListener(revista)
        }
    }
}