package com.photolab.vintage.util.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.photolab.vintage.R
import com.photolab.vintage.view.ToolType

class EditingToolsAdapter(
    private val onToolSelected: (ToolType) -> Unit
) : RecyclerView.Adapter<EditingToolsAdapter.ViewHolder>() {

    private var selectedPosition = 1

    private val tools = listOf(
        ToolType.NONE,
        ToolType.FILTER,
        ToolType.DUST,
        ToolType.LIGHT,
        ToolType.MASK,
        ToolType.GRADIENT,
        ToolType.DATE
    )

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.imgToolIcon)
        val name: TextView = view.findViewById(R.id.txtTool)
        val wrapTool: View = view.findViewById(R.id.wrapTool)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_editing_tools, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = tools.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tool = tools[position]
        
        holder.name.text = when (tool) {
            ToolType.NONE -> "Xóa"
            ToolType.FILTER -> "Bộ lọc"
            ToolType.DUST -> "Bụi phim"
            ToolType.LIGHT -> "Ánh sáng"
            ToolType.MASK -> "Mặt nạ"
            ToolType.GRADIENT -> "Chuyển màu"
            ToolType.DATE -> "Ngày tháng"
        }

        val iconRes = when (tool) {
            ToolType.NONE -> R.drawable.ic_none
            ToolType.FILTER -> R.drawable.ic_filter
            ToolType.DUST -> R.drawable.ic_dust
            ToolType.LIGHT -> R.drawable.ic_light
            ToolType.MASK -> R.drawable.ic_mask
            ToolType.GRADIENT -> R.drawable.ic_gradient
            ToolType.DATE -> R.drawable.ic_calendar
        }
        holder.icon.setImageResource(iconRes)

        if (position == selectedPosition) {
            holder.wrapTool.setBackgroundResource(R.drawable.bg_tab_selected)
            holder.name.setTextColor(holder.itemView.context.getColor(R.color.dark_red))
        } else {
            holder.wrapTool.background = null
            holder.name.setTextColor(holder.itemView.context.getColor(R.color.on_surface_light))
        }

        holder.itemView.setOnClickListener {
            val oldPos = selectedPosition
            selectedPosition = holder.bindingAdapterPosition
            notifyItemChanged(oldPos)
            notifyItemChanged(selectedPosition)
            onToolSelected(tool)
        }
    }
}
