package com.photolab.vintage.util.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.photolab.vintage.R
import com.photolab.vintage.util.bean.LanguageModel

class LanguageAdapter(
    private val items: List<LanguageModel>,
    initialSelectedCode: String,
    private val onLanguageSelected: (LanguageModel) -> Unit
) : RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {

    var selectedCode: String = initialSelectedCode
        private set

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_language, parent, false)
        return LanguageViewHolder(view)
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        val item = items[position]
        holder.tvNativeName.text = item.nameNative
        holder.tvEnglishName.text = item.nameEnglish
        holder.ivFlag.setImageResource(item.flagResId)

        val isSelected = item.code.equals(selectedCode, ignoreCase = true)
        if (isSelected) {
            holder.layoutCardContainer.setBackgroundResource(R.drawable.bg_language_card_selected)
            holder.ivCheck.visibility = View.VISIBLE
        } else {
            holder.layoutCardContainer.setBackgroundResource(R.drawable.bg_language_card_unselected)
            holder.ivCheck.visibility = View.GONE
        }

        holder.itemView.setOnClickListener {
            if (!selectedCode.equals(item.code, ignoreCase = true)) {
                selectedCode = item.code
                notifyDataSetChanged()
                onLanguageSelected(item)
            }
        }
    }

    override fun getItemCount(): Int = items.size

    class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val layoutCardContainer: RelativeLayout = itemView.findViewById(R.id.layoutCardContainer)
        val ivFlag: ImageView = itemView.findViewById(R.id.ivFlag)
        val tvNativeName: TextView = itemView.findViewById(R.id.tvNativeName)
        val tvEnglishName: TextView = itemView.findViewById(R.id.tvEnglishName)
        val ivCheck: ImageView = itemView.findViewById(R.id.ivCheck)
    }
}
