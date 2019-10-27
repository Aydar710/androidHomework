package com.example.aydar.editingusersprofile.samokatus.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.aydar.editingusersprofile.R
import com.example.aydar.editingusersprofile.samokatus.main.model.DateType
import com.example.aydar.editingusersprofile.samokatus.main.model.TransactionType
import com.example.aydar.editingusersprofile.samokatus.main.model.ViewType
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_main_rv.view.*
import kotlinx.android.synthetic.main.item_main_rv_date.view.*

class MainAdapter : ListAdapter<ViewType, RecyclerView.ViewHolder>(MainItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ViewType.DATE_TYPE -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_main_rv_date, parent, false)
                DateTypeViewHolder(view)
            }
            else -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_main_rv, parent, false)
                TransactionTypeViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = getItem(position)) {
            is DateType -> (holder as DateTypeViewHolder).bind(item)
            is TransactionType -> (holder as TransactionTypeViewHolder).bind(item)
        }
    }


    inner class DateTypeViewHolder(override val containerView: View)
        : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(item: DateType) {
            containerView.tv_date.text = item.date
        }
    }

    inner class TransactionTypeViewHolder(override val containerView: View)
        : RecyclerView.ViewHolder(containerView), LayoutContainer {

        @SuppressLint("SetTextI18n")
        fun bind(item: TransactionType) {
            containerView.tv_title.text = item.name
            if (item.isPositive){
                containerView.tv_sum.setTextColor(containerView.context.resources.getColor(R.color.colorGreen))
                containerView.tv_sum.text = "+ ${item.sum} Р"
            }else{
                containerView.tv_sum.text = "- ${item.sum} Р"
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DateType -> ViewType.DATE_TYPE
            is TransactionType -> ViewType.TRANSACTION_TYPE
            else -> -1
        }
    }
}