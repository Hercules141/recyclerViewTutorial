package com.example.recyclerviewtutorial.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ShoppingItemDataEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun shoppingItemDAO(): ShoppingItemDAO

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "myDatabase.db"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}