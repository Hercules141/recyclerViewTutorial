package com.example.recyclerviewtutorial

import android.os.Bundle
import android.view.View
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

        setContentView(R.layout.activity_main)

        val db = AppDatabase.getDatabase(applicationContext)
        val dao = db.shoppingItemDAO()

        val items: MutableList<ShoppingItemDataEntity> = mutableListOf()

        //get my RecyclerView
        val rvShoppingItems = findViewById<RecyclerView>(R.id.rvShoppingItems)
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

            for(i in (1..100)){
                items.add(ShoppingItemDataEntity(i, "hi", i))
            }

            adapter.notifyDataSetChanged()
        }

        //Button to call scroll function at runtime
        val button1: View = findViewById(R.id.floatingActionButton)
        button1.setOnClickListener {
            Toast.makeText(this, "Working!", Toast.LENGTH_SHORT).show()
        }

        super.onCreate(savedInstanceState)
    }
}
