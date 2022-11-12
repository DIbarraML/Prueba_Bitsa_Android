package com.example.prueba_bitsa

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba_bitsa.domain.StateWindow
import com.example.prueba_bitsa.domain.Window
import com.example.prueba_bitsa.databinding.ItemWindowBinding

class WindowAdapter(private var listWindows: List<Window>) :
    RecyclerView.Adapter<WindowAdapter.ViewHolder>() {

    fun setList(list: List<Window>) {
        listWindows = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemWindowBinding.inflate(
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

    class ViewHolder(private val binding: ItemWindowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(window: Window) {
            val resource = when (window.stateWindow) {
                StateWindow.C -> R.drawable.window_closed
                StateWindow.A -> R.drawable.window
                StateWindow.I -> R.drawable.window_left
                StateWindow.D -> R.drawable.window_right
            }
            binding.imageWindow.setImageResource(resource)
            binding.numberWindow.text = window.numWindow.toString()
        }
    }
}
