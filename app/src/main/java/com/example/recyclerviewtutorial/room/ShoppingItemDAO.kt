package com.example.recyclerviewtutorial.room

import androidx.room.*

@Dao
interface ShoppingItemDAO {

    @Query("SELECT * FROM items")
    fun getAll() : List<ShoppingItemDataEntity>

    @Query("select * from items where idShoppingItem in (:itemIds)")
    fun getAllByIds(itemIds: IntArray): List<ShoppingItemDataEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg items: ShoppingItemDataEntity)

    @Delete
    fun delete(item: ShoppingItemDataEntity)

}