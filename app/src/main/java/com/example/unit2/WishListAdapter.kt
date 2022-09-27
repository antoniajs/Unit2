package com.example.unit2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishListAdapter(private val context: Context, private val items: MutableList<WishList>) : RecyclerView.Adapter<WishListAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemname = itemView.findViewById<TextView>(R.id.item_name)
        private val itemprice = itemView.findViewById<TextView>(R.id.item_price)
        private val itemurl = itemView.findViewById<TextView>(R.id.item_url)

        fun bind(WishList: WishList) {
            itemname.text = WishList.name
            itemprice.text = WishList.price
            itemurl.text = WishList.url

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //to inflate the item layout and create the holder
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.list_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: WishListAdapter.ViewHolder, position: Int) {
        val list_items = items.get(position)
        holder.bind(list_items)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}