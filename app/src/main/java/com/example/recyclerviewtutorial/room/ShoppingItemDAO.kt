package com.example.recyclerviewtutorial.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ShoppingItemDAO {

    @Query("select * from items")
    fun getAll() : List<ShoppingItemDataEntity>

    @Query("select * from items where idShoppingItem in (:itemIds)")
    fun getAllByIds(itemIds: IntArray): List<ShoppingItemDataEntity>

    @Insert
    fun insertAll(vararg items: ShoppingItemDataEntity)

    @Delete
    fun delete(item: ShoppingItemDataEntity)

}