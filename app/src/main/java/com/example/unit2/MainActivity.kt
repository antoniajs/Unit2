package com.example.unit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var adapter: WishListAdapter
    val lists = mutableListOf<WishList>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listRvfeed = findViewById<RecyclerView>(R.id.listRv)
        var submitButton = findViewById<Button>(R.id.submitButton)
        var item_name = findViewById<TextView>(R.id.item_name)
        var item_price = findViewById<TextView>(R.id.item_price)
        var item_url = findViewById<TextView>(R.id.item_url)

        adapter = WishListAdapter(this, lists)
        listRvfeed.adapter = adapter
        listRvfeed.layoutManager = LinearLayoutManager(this )

        submitButton.setOnClickListener {
            var item_Name = findViewById<EditText>(R.id.itemName)
            var item_Price = findViewById<EditText>(R.id.price)
            var item_Url = findViewById<EditText>(R.id.url)


            item_name.setText(item_Name.text.toString())
            item_price.setText(item_Price.text.toString())
            item_url.setText(item_Url.text.toString())

            lists.add(WishList(item_Name.text.toString(), item_Price.text.toString(), item_Url.text.toString()))
            adapter.notifyItemInserted(lists.size - 1)

        }
    }
}