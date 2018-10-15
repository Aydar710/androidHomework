package com.example.aydar.editingusersprofile.fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.LinearLayout
import com.example.aydar.editingusersprofile.R
import com.example.aydar.editingusersprofile.miracle.AdapterMiracle
import com.example.aydar.editingusersprofile.miracle.Miracle
import com.example.aydar.editingusersprofile.miracle.MiracleDetailActivity

class RecyclerFragment : Fragment(), AdapterMiracle.Listener {

    lateinit var adapter : AdapterMiracle

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view: View = inflater.inflate(R.layout.fragment_recycler, container, false)

        var recyclerView: RecyclerView = view.findViewById(R.id.recycler_fr)
        recyclerView.layoutManager = LinearLayoutManager(view.context, LinearLayout.VERTICAL, false)
        adapter = AdapterMiracle(Miracle.miracles)
        adapter.setListener(this)
        recyclerView.adapter = adapter

        return view
    }

    override fun onClick(position: Int) {
        val intent: Intent = Intent(context, MiracleDetailActivity::class.java)
        intent.putExtra(Miracle.EXTRA, position)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_recycler, menu)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_sort_by_order -> {
                adapter.sortByOrder()
                return true
            }
            R.id.menu_sort_by_name ->{
                adapter.sortByName()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
