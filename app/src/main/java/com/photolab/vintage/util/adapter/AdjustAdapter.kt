package com.photolab.vintage.util.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.photolab.vintage.R
import java.text.MessageFormat

class AdjustAdapter(
    private val context: Context,
    private val adjustListener: AdjustListener
) : RecyclerView.Adapter<AdjustAdapter.ViewHolder>() {

    var selectedFilterIndex = 0

    val filterConfigTemplate = "@adjust brightness {0} @adjust contrast {1} @adjust saturation {2} @vignette {3} 0.7 @adjust sharpen {4} 1 @adjust whitebalance {5} 1"

    val lstAdjusts = listOf(
        AdjustModel("Brightness", "brightness", R.drawable.brightness, R.drawable.brightness_selected, -1.0f, 0.0f, 1.0f),
        AdjustModel("Contrast", "contrast", R.drawable.contrast, R.drawable.contrast_selected, 0.5f, 1.0f, 1.5f),
        AdjustModel("Saturation", "saturation", R.drawable.saturation, R.drawable.saturation_selected, 0.0f, 1.0f, 2.0f),
        AdjustModel("Vignette", "vignette", R.drawable.vignette, R.drawable.vignette_selected, 0.0f, 0.6f, 0.6f),
        AdjustModel("Sharpen", "sharpen", R.drawable.sharpen, R.drawable.sharpen_selected, 0.0f, 0.0f, 10.0f),
        AdjustModel("Temp", "whitebalance", R.drawable.temperature, R.drawable.temperature_selected, -1.0f, 0.0f, 1.0f)
    )

    interface AdjustListener {
        fun onAdjustSelected(adjustModel: AdjustModel)
    }

    class AdjustModel(
        val name: String,
        val code: String,
        val iconRes: Int,
        val selectedIconRes: Int,
        val minValue: Float,
        var originValue: Float,
        val maxValue: Float
    )

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.icon)
        val toolName: TextView = view.findViewById(R.id.tool_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adjust_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = lstAdjusts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = lstAdjusts[position]
        holder.toolName.text = item.name

        if (selectedFilterIndex == position) {
            holder.icon.setImageResource(item.selectedIconRes)
            holder.toolName.setTextColor(context.getColor(R.color.primary))
        } else {
            holder.icon.setImageResource(item.iconRes)
            holder.toolName.setTextColor(context.getColor(R.color.on_surface_light))
        }

        holder.itemView.setOnClickListener {
            val oldPos = selectedFilterIndex
            selectedFilterIndex = holder.bindingAdapterPosition
            notifyItemChanged(oldPos)
            notifyItemChanged(selectedFilterIndex)
            adjustListener.onAdjustSelected(lstAdjusts[selectedFilterIndex])
        }
    }

    fun getCurrentAdjustModel(): AdjustModel = lstAdjusts[selectedFilterIndex]

    fun getFilterConfig(): String {
        return MessageFormat.format(
            filterConfigTemplate,
            lstAdjusts[0].originValue.toString(),
            lstAdjusts[1].originValue.toString(),
            lstAdjusts[2].originValue.toString(),
            lstAdjusts[3].originValue.toString(),
            lstAdjusts[4].originValue.toString(),
            lstAdjusts[5].originValue
        )
    }
}
