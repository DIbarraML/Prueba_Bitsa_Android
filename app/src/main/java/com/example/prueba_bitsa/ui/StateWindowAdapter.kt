package com.example.prueba_bitsa.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba_bitsa.R
import com.example.prueba_bitsa.WindowAdapter
import com.example.prueba_bitsa.databinding.ItemTextviewBinding
import com.example.prueba_bitsa.databinding.ItemWindowBinding
import com.example.prueba_bitsa.domain.StateWindow
import com.example.prueba_bitsa.domain.Window
import com.example.prueba_bitsa.domain.getState

class StateWindowAdapter(private val listWindows: List<String>): RecyclerView.Adapter<StateWindowAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTextviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listWindows[position])
    }

    override fun getItemCount(): Int = listWindows.size

    class ViewHolder(private val binding: ItemTextviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(message: String) {
            binding.itemTextview.text = message
        }
    }
}
