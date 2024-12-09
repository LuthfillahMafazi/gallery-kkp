package com.example.gallerymuslim.register

import android.util.Log
import com.example.gallerymuslim.dao.RegisterDao
import com.example.gallerymuslim.entities.RegisterEntities

class RegisterRepository(private val dao: RegisterDao) {

    val users = dao.getAllUsers()
    suspend fun insert(user: RegisterEntities) {
        return dao.insert(user)
    }

    suspend fun getUserName(userName: String):RegisterEntities?{
        return dao.getUsername(userName)
    }
}