package com.example.aydar.editingusersprofile.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.aydar.editingusersprofile.R

class FirstTabFragment : Fragment() {


    companion object {
        const val ARG_TEXT = "text"

        fun newInstance(title: String) =
                FirstTabFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_TEXT, title)
                    }
                }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view: View = inflater.inflate(R.layout.fragment_first_tab, container, false)
        var txt: TextView = view.findViewById(R.id.txt_first_tab)

        val text = arguments?.getString(ARG_TEXT) ?: "No bro"

        txt.text = text

        return view
    }
}
