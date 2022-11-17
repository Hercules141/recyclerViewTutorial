package com.example.recyclerviewtutorial

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.recyclerviewtutorial.room.AppDatabase
import com.example.recyclerviewtutorial.room.ShoppingItemDataEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
//        setContentView(R.layout.test)
        //Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show()

        setContentView(R.layout.activity_main)

        val db = AppDatabase.getDatabase(applicationContext)
        val dao = db.shoppingItemDAO()

        val items: MutableList<ShoppingItemDataEntity> = mutableListOf()
        //val items2:


        //get my RecyclerView
        val rvShoppingItems = findViewById<RecyclerView>(R.id.rvShoppingItems)
        //create a list with test data
//        val items = ShoppingItem.createItemList(155)
        //create Adapter
        val adapter = ShoppingItemAdapter(items,this)
        //set Recycler View Adapter to the one created
        rvShoppingItems.adapter = adapter
        //layoutmanager of recyclerView
        rvShoppingItems.layoutManager = LinearLayoutManager(this)


        CoroutineScope(Dispatchers.IO).launch{
            dao.insertAll(
//                ShoppingItemDataEntity(1, "käse", 10),
//                ShoppingItemDataEntity(2, "milch", 3)
            )

//            items.addAll(dao.getAll())


            adapter.notifyDataSetChanged()
//            Toast.makeText(applicationContext, "hi? from thread?", Toast.LENGTH_SHORT).show()

            items.add(ShoppingItemDataEntity(16, "hi", 12))
            adapter.notifyDataSetChanged()
        }

        super.onCreate(savedInstanceState)
    }
}
