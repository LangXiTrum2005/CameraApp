package com.photolab.vintage.util.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.photolab.vintage.R
import com.photolab.vintage.util.bean.FilterConfig

class FilterAdapter(
    private val context: Context,
    private val listener: FilterListener,
    val filterEffects: List<FilterConfig>
) : RecyclerView.Adapter<FilterAdapter.ViewHolder>() {

    var selectedFilterIndex = 0

    interface FilterListener {
        fun onFilterSelected(filterConfig: FilterConfig)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val filterImg: ImageView = view.findViewById(R.id.filterView)
        val filterName: TextView = view.findViewById(R.id.name)
        val cardView: View = view.findViewById(R.id.wrap)
        val lockImg: ImageView? = view.findViewById(R.id.lock)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.filter_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = filterEffects.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val filter = filterEffects[position]
        holder.filterName.text = filter.name

        Glide.with(context)
            .load(Uri.parse(filter.assetUrl))
            .into(holder.filterImg)

        holder.lockImg?.visibility = View.GONE

        holder.itemView.setOnClickListener {
            val prev = selectedFilterIndex
            selectedFilterIndex = holder.bindingAdapterPosition
            notifyItemChanged(prev)
            notifyItemChanged(selectedFilterIndex)
            listener.onFilterSelected(filter)
        }
    }
}
