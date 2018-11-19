package com.example.aydar.editingusersprofile

import android.support.v7.util.DiffUtil

class MiracleDiffCallback(var oldList: ArrayList<Miracle>, var newList: ArrayList<Miracle>) : DiffUtil.Callback() {
    override fun areItemsTheSame(p0: Int, p1: Int): Boolean {
        return oldList.get(p0).order == newList.get(p1).order
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(p0: Int, p1: Int): Boolean {
        return oldList.get(p0).equals(newList.get(p1))
    }
}