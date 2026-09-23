package com.photolab.vintage.util.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.photolab.vintage.R

class CameraModeAdapter(
    private val modes: List<String>,
    private val onModeClicked: (Int) -> Unit
) : RecyclerView.Adapter<CameraModeAdapter.ModeViewHolder>() {

    private var selectedPosition = 0

    inner class ModeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.modeTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModeViewHolder {
        return ModeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.camera_mode_item, parent, false)
        )
    }

    override fun getItemCount(): Int = modes.size

    override fun onBindViewHolder(holder: ModeViewHolder, position: Int) {
        val isSelected = position == selectedPosition
        holder.title.text = modes[position]
        holder.title.setTextColor(
            ContextCompat.getColor(
                holder.itemView.context,
                if (isSelected) R.color.camera_accent else R.color.camera_text_muted
            )
        )
        holder.itemView.background = if (isSelected) {
            ContextCompat.getDrawable(holder.itemView.context, R.drawable.bg_camera_mode_selected)
        } else {
            null
        }
        holder.itemView.setOnClickListener {
            val clickedPosition = holder.bindingAdapterPosition
            if (clickedPosition != RecyclerView.NO_POSITION) {
                onModeClicked(clickedPosition)
            }
        }
    }

    fun select(position: Int) {
        if (position == selectedPosition || position !in modes.indices) return
        val previousPosition = selectedPosition
        selectedPosition = position
        notifyItemChanged(previousPosition)
        notifyItemChanged(selectedPosition)
    }
}
