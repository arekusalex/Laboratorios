package com.arekusalex.parcial1.ui.revista.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import com.arekusalex.parcial1.data.model.RevistaModel
import androidx.recyclerview.widget.RecyclerView
import com.arekusalex.parcial1.databinding.RevistaItemBinding
import com.arekusalex.parcial1.ui.revista.viewmodel.RevistaViewModel

class RevistaRecyclerViewAdapter(private val clickListener: (RevistaModel)-> Unit) : RecyclerView.Adapter<RevistaRecyclerViewHolder>() {
    private val revistas = ArrayList<RevistaModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RevistaRecyclerViewHolder {
        val binding =  RevistaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RevistaRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return revistas.size
    }

    override fun onBindViewHolder(holder: RevistaRecyclerViewHolder, position: Int) {
        val revista = revistas[position]
        holder.bind(revista, clickListener)
    }

    fun setData(revistasList: List<RevistaModel>){
        RevistaViewModel
        revistas.clear()
        revistas.addAll(revistasList)
    }
}