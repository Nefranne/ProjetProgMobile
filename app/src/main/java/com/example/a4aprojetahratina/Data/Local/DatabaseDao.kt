package com.example.a4aprojetahratina.Data.Local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.a4aprojetahratina.Data.Local.models.UserLocal

@Dao
interface DatabaseDao {
    @Query("SELECT * FROM UserLocal")
    fun getAll(): List<UserLocal>


    @Query("SELECT * FROM USERLOCAL WHERE email LIKE :email LIMIT 1")
    fun findByName(email: String): UserLocal?

    @Insert
    fun insert(users: UserLocal)

    @Delete
    fun delete(user: UserLocal)
}