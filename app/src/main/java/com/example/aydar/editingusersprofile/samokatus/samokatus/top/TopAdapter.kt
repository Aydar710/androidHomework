package com.example.aydar.editingusersprofile.samokatus.samokatus.top

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.aydar.editingusersprofile.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_samokatus_top_rv.view.*

class TopAdapter : ListAdapter<TopItem, TopAdapter.TopItemViewHolder>(TopItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_samokatus_top_rv, parent, false)
        return TopItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class TopItemViewHolder(override val containerView: View)
        : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(item: TopItem) {
            containerView.iv_item_background.setImageResource(item.background)
            containerView.iv_item_icon.setImageResource(item.icon)
            containerView.tv_title.text = item.text
        }
    }
}