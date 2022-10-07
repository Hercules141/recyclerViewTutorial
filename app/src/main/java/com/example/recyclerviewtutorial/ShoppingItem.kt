package com.example.recyclerviewtutorial

import android.content.Context
import androidx.room.Room
import com.example.recyclerviewtutorial.room.AppDatabase
import com.example.recyclerviewtutorial.room.ShoppingItemDAO
import kotlin.random.Random

class ShoppingItem(val itemName: String, val itemCount: Int) {

//
//
//    companion object{
//        private var idCounter = 0
//        fun createItemList(amount: Int): ArrayList<ShoppingItem>{
//            val shoppingItemList = ArrayList<ShoppingItem>()
//            for(i in 1..amount){
//                shoppingItemList.add(ShoppingItem("Item Number: " + ++idCounter, Random.nextInt(),))
//            }
//            return shoppingItemList
//        }
//
//        fun loadShoppingItems(dao : ShoppingItemDAO): ArrayList<ShoppingItem>{
//
//            return ArrayList<ShoppingItem>(dao.getAll())
//        }
//    }

}