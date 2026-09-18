package com.photolab.vintage.util.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.photolab.vintage.R
import com.photolab.vintage.util.DateUtil
import java.util.Date

class DateAdapter(
    private val context: Context,
    private val listener: DateListener
) : RecyclerView.Adapter<DateAdapter.ViewHolder>() {

    var selectedIndex = 1

    val dateFormats = listOf(
        DateItem("Tắt", ""),
        DateItem("Chuẩn", DateUtil.FORMAT_DEFAULT),
        DateItem("Kiểu 1", DateUtil.FORMAT_1),
        DateItem("Kiểu 2", DateUtil.FORMAT_2),
        DateItem("Kiểu 3", DateUtil.FORMAT_3),
        DateItem("Kiểu 4", DateUtil.FORMAT_4),
        DateItem("Kiểu 5", DateUtil.FORMAT_5),
        DateItem("Kiểu 6", DateUtil.FORMAT_6)
    )

    interface DateListener {
        fun onDateFormatSelected(format: String)
    }

    class DateItem(
        val title: String,
        val formatPattern: String
    )

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.icon)
        val name: TextView = view.findViewById(R.id.tool_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adjust_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dateFormats.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dateFormats[position]

        val previewText = if (item.formatPattern.isEmpty()) {
            "OFF"
        } else {
            DateUtil.getDateFormat(Date(), item.formatPattern)
        }

        holder.name.text = "${item.title}\n($previewText)"

        if (selectedIndex == position) {
            holder.icon.setImageResource(R.drawable.ic_calendar_selected)
            holder.name.setTextColor(context.getColor(R.color.primary))
        } else {
            holder.icon.setImageResource(R.drawable.ic_calendar)
            holder.name.setTextColor(context.getColor(R.color.on_surface_light))
        }

        holder.itemView.setOnClickListener {
            val oldPos = selectedIndex
            selectedIndex = holder.bindingAdapterPosition
            notifyItemChanged(oldPos)
            notifyItemChanged(selectedIndex)
            listener.onDateFormatSelected(item.formatPattern)
        }
    }
}
