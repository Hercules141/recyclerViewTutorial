package com.example.recyclerviewtutorial

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewtutorial.room.ShoppingItemDataEntity

class ShoppingItemAdapter(private val mShoppingItemList:  List<ShoppingItemDataEntity>,val context: Context) : RecyclerView.Adapter<ShoppingItemAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val nameTextView = itemView.findViewById<TextView>(R.id.itemName)
        val amountTextView = itemView.findViewById<TextView>(R.id.itemAmount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = context
        val inflater = LayoutInflater.from(context)

        val shoppingItemView = inflater.inflate(R.layout.custom_row_layout, parent, false)
        return ViewHolder(shoppingItemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //bind data to actual visible items
        //binding index of Arraylist Data to holder item View thing
        val shoppingItem = mShoppingItemList[position]

        val itemName = holder.nameTextView
        val itemAmount = holder.amountTextView

        itemName.text = shoppingItem.shoppingItemName
        itemAmount.text = shoppingItem.shoppingItemCount.toString()

    }

    override fun getItemCount(): Int {
        return mShoppingItemList.size
    }
}