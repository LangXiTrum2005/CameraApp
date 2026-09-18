package com.photolab.vintage.util.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.photolab.vintage.R
import com.photolab.vintage.util.bean.CreditPackageConfig

class CreditPackageAdapter(
    private val packages: List<CreditPackageConfig>,
    private val onPackageSelected: (CreditPackageConfig) -> Unit
) : RecyclerView.Adapter<CreditPackageAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tvTitle)
        val price: TextView = view.findViewById(R.id.tvPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_credit_package, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = packages.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pkg = packages[position]
        holder.title.text = pkg.title
        holder.price.text = pkg.price
        holder.itemView.setOnClickListener {
            onPackageSelected(pkg)
        }
    }
}
