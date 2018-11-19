package com.example.aydar.editingusersprofile

import android.app.Activity
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_miracle.view.*
import kotlin.collections.ArrayList

class AdapterMiracle(val miracles: ArrayList<Miracle>, private val activity: Activity) : RecyclerView.Adapter<AdapterMiracle.ViewHolder>() {

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

    fun sortByOrder() {
        val newList: ArrayList<Miracle>? = ArrayList()
        newList?.addAll(Miracle.miracles)

        Observable.fromIterable(newList)
                .map {
                    it.name = it.name + it.name.length + "by order"
                    it
                }
                .take(3)
                .toSortedList { o1, o2 -> o1.order - o2.order }
                .doOnSubscribe { activity.progress_bar.visibility = ProgressBar.VISIBLE }
                .doOnSuccess { activity.progress_bar.visibility = ProgressBar.INVISIBLE }
                .subscribe { miracles ->
                    val miracleDiffCallback = MiracleDiffCallback(this.miracles, miracles as ArrayList<Miracle>)
                    val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(miracleDiffCallback)
                    diffResult.dispatchUpdatesTo(this)
                }
    }

    fun sortByName() {
        val newList: ArrayList<Miracle>? = ArrayList()
        newList?.addAll(Miracle.miracles)

        Observable.fromIterable(newList)
                .map {
                    it.name = it.name + it.name.length
                    it
                }
                .take(5)
                .toSortedList { o1, o2 -> o1.name.compareTo(o2.name) }
                .doOnSubscribe { activity.progress_bar.visibility = ProgressBar.VISIBLE }
                .doOnSuccess { activity.progress_bar.visibility = ProgressBar.INVISIBLE }
                .subscribe { miracles ->
                    val miracleDiffCallback = MiracleDiffCallback(this.miracles, miracles as ArrayList<Miracle>)
                    val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(miracleDiffCallback)
                    diffResult.dispatchUpdatesTo(this)
                }
    }
}