package com.example.aydar.editingusersprofile

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class AdapterMiracle(val miracles: Array<Miracle>) : RecyclerView.Adapter<AdapterMiracle.ViewHolder>() {

    private lateinit var listener: Listener

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.card_miracle, p0, false)
        return ViewHolder(v as CardView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val miracle: Miracle = miracles[position]

        holder.txtName.text = miracle.name

        holder.imageMiracle.setImageResource(miracle.image)

        holder.itemView.setOnClickListener {
            if (listener != null)
                listener.onClick(position)
        }
    }

    override fun getItemCount(): Int {
        return miracles.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txtName: TextView = itemView.findViewById(R.id.txt_miracle)
        val imageMiracle: ImageView = itemView.findViewById(R.id.image_miracle)

    }

    interface Listener {
        fun onClick(position: Int)
    }

    fun setListener(listener: Listener) {
        this.listener = listener
    }
}