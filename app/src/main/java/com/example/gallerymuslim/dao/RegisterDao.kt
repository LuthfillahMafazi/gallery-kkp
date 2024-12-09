package com.example.gallerymuslim.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.gallerymuslim.entities.RegisterEntities

@Dao
interface RegisterDao {

    @Insert
    suspend fun insert(register: RegisterEntities)

    @Query("SELECT * FROM register_users_table ORDER BY userId DESC")
    fun getAllUsers(): LiveData<List<RegisterEntities>>

    @Query("DELETE FROM register_users_table")
    suspend fun deleteAll(): Int

    @Query("SELECT * FROM register_users_table WHERE user_name LIKE :userName")
    suspend fun getUsername(userName: String): RegisterEntities?
}