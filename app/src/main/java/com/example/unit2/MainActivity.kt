package com.example.unit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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


        adapter = WishListAdapter(this, lists)
        listRvfeed.adapter = adapter
        listRvfeed.layoutManager = LinearLayoutManager(this )

        submitButton.setOnClickListener {
            Log.i("Button works?", "Started clicking")
            var item_Name = findViewById<EditText>(R.id.enteredName)
            var item_Price = findViewById<EditText>(R.id.enteredPrice)
            var item_Url = findViewById<EditText>(R.id.enteredUrl)


            Log.i("Expected data", item_Name.text.toString())
            Log.i("Expected data", item_Price.text.toString())
            Log.i("Expected data", item_Url.text.toString())


            lists.add(WishList(item_Name.text.toString(), item_Price.text.toString(), item_Url.text.toString()))
            adapter.notifyItemInserted(lists.size - 1)

            item_Name.setText("")
            item_Price.setText("")
            item_Url.setText("")
            Log.i("Button works?", "Ended clicking")

        }
    }
}