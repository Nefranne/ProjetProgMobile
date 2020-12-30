package com.example.a4aprojetahratina.Data.Repository

import com.example.a4aprojetahratina.Data.Local.DatabaseDao
import com.example.a4aprojetahratina.Data.Local.models.toData
import com.example.a4aprojetahratina.Data.Local.models.toEntity
import com.example.a4aprojetahratina.Domain.entity.User

class UserRepository (
        private val databaseDao: DatabaseDao
        ) {


    suspend fun createUser(user : User) {
            databaseDao.insert(user.toData())

    }
    fun getUser(email: String) : User? {
        val userLocal= databaseDao.findByName(email)
        return userLocal?.toEntity()
    }


}