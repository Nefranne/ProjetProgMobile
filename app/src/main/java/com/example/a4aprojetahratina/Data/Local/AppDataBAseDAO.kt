package com.example.a4aprojetahratina.Data.Local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.a4aprojetahratina.Data.Local.models.UserLocal

@Database(entities = arrayOf(UserLocal::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao
}