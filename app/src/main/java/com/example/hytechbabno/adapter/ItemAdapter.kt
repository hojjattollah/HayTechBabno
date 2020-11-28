package com.example.hytechbabno.adapter

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hytechbabno.R
import com.example.hytechbabno.model.Item
import kotlinx.android.synthetic.main.item_details_list.view.*
import java.util.*

class ItemAdapter(var items: ArrayList<Item>, val context: Context) : RecyclerView.Adapter<ItemAdapter.ItemHolder>() {
    lateinit var mClickListener: IClickListener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ItemHolder(layoutInflater.inflate(R.layout.item_details_list, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        (holder as ItemHolder).bind(items.get(position))
    }

    fun setOnItemClickListener(clickListener: IClickListener) {
        mClickListener = clickListener
    }

    interface IClickListener {
        fun onClick(postion: Int, view: View)
    }

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            mClickListener.onClick(adapterPosition, itemView)
        }

        fun bind(item: Item): Unit {
            itemView.itemDescription.text = item.itemName
            itemView.itemDate.text = item.itemLastName
//            val id = context.resources.getIdentifier(item.itemName.toLowerCase(), "drawable", context.packageName)
//            itemView.itemImage.setBackgroundResource(id)
            val rnd = Random()
            val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                itemView.itemImage.setBackgroundColor(color)
            }
        }

    }
}