package com.example.aydar.editingusersprofile

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.card_miracle.view.*
import kotlin.collections.ArrayList

class AdapterMiracle(var miracles: ArrayList<Miracle>) : RecyclerView.Adapter<AdapterMiracle.ViewHolder>() {

    private lateinit var listener: Listener

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.card_miracle, p0, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val miracle: Miracle = miracles.get(position)
        holder.txtName.text = miracle.name
        holder.imageMiracle.setImageResource(miracle.image)
        holder.itemView.setOnClickListener {
            listener.onClick(position)
        }
    }

    override fun getItemCount(): Int {
        return miracles.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtName: TextView = itemView.txt_miracle
        val imageMiracle: ImageView = itemView.image_miracle
    }

    interface Listener {
        fun onClick(position: Int)
    }

    fun setListener(listener: Listener) {
        this.listener = listener
    }

    fun submitList(newList : List<Miracle>){
        val miracleDiffCallback = MiracleDiffCallback(this.miracles, newList as ArrayList<Miracle>)
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(miracleDiffCallback)
        diffResult.dispatchUpdatesTo(this)
        miracles = newList
    }
}