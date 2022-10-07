package com.example.recyclerviewtutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.recyclerviewtutorial.room.AppDatabase
import com.example.recyclerviewtutorial.room.ShoppingItemDataEntity

class MainActivity : AppCompatActivity() {

    val db = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java, "myDatabase"
    ).build()

    val dao = db.ShoppingItemDAO()

    override fun onCreate(savedInstanceState: Bundle?) {
//        setContentView(R.layout.test)
        //Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show()

        setContentView(R.layout.activity_main)

//        dao.insertAll(ShoppingItem.createItemList(9)))
        dao.insertAll(
            ShoppingItemDataEntity(1, "käse", 10),
            ShoppingItemDataEntity(2, "milch", 3))
        //get my RecyclerView
        val rvShoppingItems = findViewById<RecyclerView>(R.id.rvShoppingItems)
        //create a list with test data
//        val items = ShoppingItem.createItemList(155)
        val items = dao.getAll()
        //create Adapter
        val adapter = ShoppingItemAdapter(items,this)
        //set Recycler View Adapter to the one created
        rvShoppingItems.adapter = adapter
        //layoutmanager of recyclerView
        rvShoppingItems.layoutManager = LinearLayoutManager(this)

        super.onCreate(savedInstanceState)
    }



}