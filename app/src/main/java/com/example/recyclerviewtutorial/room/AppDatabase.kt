package com.example.recyclerviewtutorial.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ShoppingItemDataEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun ShoppingItemDAO(): ShoppingItemDAO
}