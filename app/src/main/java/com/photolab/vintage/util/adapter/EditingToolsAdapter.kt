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
        
        holder.name.setText(when (tool) {
            ToolType.NONE -> R.string.ui_mode_none
            ToolType.FILTER -> R.string.ui_mode_filter
            ToolType.DUST -> R.string.ui_mode_dust
            ToolType.LIGHT -> R.string.ui_mode_light
            ToolType.MASK -> R.string.ui_mode_mask
            ToolType.GRADIENT -> R.string.ui_mode_gradient
            ToolType.DATE -> R.string.ui_date
        })

        val iconRes = when (tool) {
            ToolType.NONE -> R.drawable.ic_tool_erase
            ToolType.FILTER -> R.drawable.ic_tool_filter
            ToolType.DUST -> R.drawable.ic_tool_dust
            ToolType.LIGHT -> R.drawable.ic_tool_light
            ToolType.MASK -> R.drawable.ic_tool_mask
            ToolType.GRADIENT -> R.drawable.ic_tool_gradient
            ToolType.DATE -> R.drawable.ic_tool_date
        }
        holder.icon.setImageResource(iconRes)

        if (position == selectedPosition) {
            holder.wrapTool.setBackgroundResource(R.drawable.bg_tab_selected)
            holder.name.setTextColor(holder.itemView.context.getColor(R.color.primary))
        } else {
            holder.wrapTool.setBackgroundResource(R.drawable.bg_tool_glass)
            holder.name.setTextColor(holder.itemView.context.getColor(R.color.on_surface_variant))
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
