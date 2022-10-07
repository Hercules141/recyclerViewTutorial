package com.example.recyclerviewtutorial.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "items")
data class ShoppingItemDataEntity(
    @PrimaryKey val idShoppingItem: Int,
    @ColumnInfo(name = "itemName") val shoppingItemName: String?,
    @ColumnInfo(name = "itemCount") val shoppingItemCount: Int?


)