package com.example.recyclerviewtutorial

import android.os.Bundle
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

        var items: List<ShoppingItemDataEntity> = listOf()

        CoroutineScope(Dispatchers.IO).launch{
            dao.insertAll(
                ShoppingItemDataEntity(1, "käse", 10),
                ShoppingItemDataEntity(2, "milch", 3)
            )

            items = dao.getAll()
        }




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

        super.onCreate(savedInstanceState)
    }
}
