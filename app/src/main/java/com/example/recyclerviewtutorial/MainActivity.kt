package com.example.recyclerviewtutorial

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewtutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
//        setContentView(R.layout.test)
        //Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show()

        setContentView(R.layout.activity_main)
        //get my RecyclerView
        val rvShoppingItems = findViewById<RecyclerView>(R.id.rvShoppingItems)
        //create a list with test data
        val items = ShoppingItem.createItemList(15)
        //create Adapter
        val adapter = ShoppingItemAdapter(items,this)
        //set Recycler View Adapter to the one created
        rvShoppingItems.adapter = adapter
        //layoutmanager of recyclerView
        rvShoppingItems.layoutManager = LinearLayoutManager(this)

        super.onCreate(savedInstanceState)
    }


}