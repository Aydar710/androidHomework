package com.example.aydar.editingusersprofile.miracle

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.aydar.editingusersprofile.R.layout.card_miracle
import kotlinx.android.synthetic.main.card_miracle.view.*
import java.util.*
import kotlin.collections.ArrayList

class AdapterMiracle(val miracles: ArrayList<Miracle>) : RecyclerView.Adapter<AdapterMiracle.ViewHolder>() {

    private lateinit var listener: Listener

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(card_miracle, p0, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val miracle: Miracle = miracles.get(position)

        holder.txtName.text = miracle.name

        holder.imageMiracle.setImageResource(miracle.image)

        holder.itemView.setOnClickListener {
            listener?.let {
                it.onClick(position)
            }
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

    fun sortByOrder() {
        var newList: ArrayList<Miracle>? = ArrayList()
        newList?.addAll(Miracle.miracles)

        Collections.sort(newList, object : Comparator<Miracle> {
            override fun compare(o1: Miracle?, o2: Miracle?): Int {
                return o1!!.order - o2!!.order
            }
        })
        var miracleDiffCallback: MiracleDiffCallback = MiracleDiffCallback(miracles, newList!!)
        var diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(miracleDiffCallback)
        miracles.clear()
        miracles.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    fun sortByName(){
        var newList: ArrayList<Miracle>? = ArrayList()
        newList?.addAll(Miracle.miracles)

        Collections.sort(newList, object : Comparator<Miracle> {
            override fun compare(o1: Miracle?, o2: Miracle?): Int {
                return o1!!.name.compareTo(o2!!.name)
            }
        })
        var miracleDiffCallback: MiracleDiffCallback = MiracleDiffCallback(miracles, newList!!)
        var diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(miracleDiffCallback)
        miracles.clear()
        miracles.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }
}
