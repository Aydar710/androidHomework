package com.example.aydar.editingusersprofile.samokatus.samokatus.bot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.aydar.editingusersprofile.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_samokatus_bot_rv.view.*

class BotAdapter : ListAdapter<BotItem, BotAdapter.BotIemViewHolder>(BotItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BotIemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_samokatus_bot_rv, parent, false)
        return BotIemViewHolder(view)
    }

    override fun onBindViewHolder(holder: BotIemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class BotIemViewHolder(override val containerView: View)
        : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(item: BotItem) {
            containerView.tv_name.text = item.name
            containerView.tv_description.text = item.description
            containerView.iv_icon.setImageResource(item.icon)
        }
    }
}