package com.example.hytechbabno.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hytechbabno.R
import com.example.hytechbabno.adapter.ItemAdapter
import com.example.hytechbabno.databinding.ActivityMainBinding
import com.example.hytechbabno.enum.ListType
import com.example.hytechbabno.model.Item


class MainActivity : AppCompatActivity() {
    private lateinit var context: Context
    private lateinit var viewDataBinding: ActivityMainBinding
    private var linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    private val lastVisibleItemPosition: Int
        get() {
            return linearLayoutManager.findLastVisibleItemPosition()
        }
    private val items: ArrayList<Item> = ArrayList<Item>()
    private lateinit var gridLayoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = applicationContext
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        recyclerViewInit(exampleData(), ListType.RECYCLER_VIEW)
    }

    private fun recyclerViewInit(itemlist: ArrayList<Item>, listType: ListType): Unit {
        var adapter: ItemAdapter = ItemAdapter(itemlist, this)
        when (listType) {
            ListType.RECYCLER_VIEW -> viewDataBinding.recyclerView.layoutManager = linearLayoutManager
            ListType.GRID_VIEW -> viewDataBinding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        }
        viewDataBinding.recyclerView.adapter = adapter
        setRecyclerViewScrollListener()
        setRecyclerViewItemTouchListener()
        adapter.setOnItemClickListener(object : ItemAdapter.IClickListener {
            override fun onClick(postion: Int, view: View) {
                when (postion) {
                    0 -> intent = Intent(context, LoginActivity::class.java)
                    1 -> intent = Intent(context, HamburgerButtonActivity::class.java)
                    2 -> intent = Intent(context, RecordButtonActivity::class.java)
                    3 -> intent = Intent(context, ErrorPageActivity::class.java)
                    4 -> intent = Intent(context, MultiButtonActivity::class.java)
                }
                startActivity(intent)

                Toast.makeText(context, exampleData().get(postion).itemName, Toast.LENGTH_LONG).show()
            }

        })

    }

    private fun exampleData(): ArrayList<Item> {
        items.add(createItem(ItemDetailsActivity(), "Data Binding"))
        items.add(createItem(HamburgerButtonActivity(), "Hamburger Menu"))
        items.add(createItem(RecordButtonActivity(), "Record Button"))
        items.add(createItem(ErrorPageActivity(), "Error Page"))
        items.add(createItem(MultiButtonActivity(), "Multi Button "))
        for (i in 4..10) {
            var item: Item = Item("empety$i", "Item$i", "" + (i + 30), "programmer$i")
            items.add(item)
        }
        return items
    }

    private fun createItem(activity: Activity, itemName: String): Item {
        var pakageName: String = activity.javaClass.name.replace(this.packageName, "\n")
        return Item("PackageName: $pakageName", itemName, "", "")
    }

    private fun setRecyclerViewScrollListener() {
        viewDataBinding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val totalItemCount = recyclerView.layoutManager!!.itemCount
//                if (!imageRequester.isLoadingData && totalItemCount == lastVisibleItemPosition + 1) {
                if (totalItemCount == lastVisibleItemPosition + 1) {
                    var DataBinding: Item = Item("new Item", "empty", "", "")
                    items.add(DataBinding)
                    recyclerViewInit(items, ListType.GRID_VIEW)
                }
            }
        })

    }

    private fun setRecyclerViewItemTouchListener() {

        //1
        val itemTouchCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, viewHolder1: RecyclerView.ViewHolder): Boolean {
                //2
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {
                //3
                val position = viewHolder.adapterPosition
                items.removeAt(position)
                viewDataBinding.recyclerView.adapter!!.notifyItemRemoved(position)
            }
        }

        //4
        val itemTouchHelper = ItemTouchHelper(itemTouchCallback)
        itemTouchHelper.attachToRecyclerView(viewDataBinding.recyclerView)
    }
}