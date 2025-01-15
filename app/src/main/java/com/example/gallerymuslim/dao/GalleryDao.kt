package com.example.gallerymuslim.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.gallerymuslim.entities.GalleryEntities
import com.example.gallerymuslim.entities.RegisterEntities
import kotlinx.coroutines.flow.Flow

@Dao
interface GalleryDao {

    @Insert
    fun insert(register: RegisterEntities)

    @Insert
    fun addProduct(product: GalleryEntities)

    @Update
    fun updateProduct(product: GalleryEntities)

    @Query("SELECT * FROM GalleryEntities ORDER BY id DESC")
    fun getAllProduct(): Flow<List<GalleryEntities>>

    @Query("SELECT * FROM GalleryEntities WHERE id = :id")
    fun getDetailProduct(id: Int): Flow<GalleryEntities?>

    @Query("SELECT * FROM register_users_table ORDER BY userId DESC")
    fun getAllUsers(): LiveData<List<RegisterEntities>>

    @Query("DELETE FROM register_users_table")
    suspend fun deleteAll(): Int

    @Query("SELECT * FROM register_users_table WHERE user_name LIKE :userName")
    fun getUsername(userName: String): Flow<RegisterEntities?>
}