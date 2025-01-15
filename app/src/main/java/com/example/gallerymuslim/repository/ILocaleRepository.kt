package com.example.gallerymuslim.repository

import androidx.lifecycle.LiveData
import com.example.gallerymuslim.entities.GalleryEntities
import com.example.gallerymuslim.entities.RegisterEntities
import com.example.gallerymuslim.vo.Resource
import kotlinx.coroutines.flow.Flow

interface ILocaleRepository {
    fun registerUser(registerEntities: RegisterEntities)
    suspend fun getUserName(userName: String): Flow<Resource<RegisterEntities?>>
    fun getAllUser(): LiveData<List<RegisterEntities>>
    fun addProduct(galleryEntities: GalleryEntities)
    suspend fun getAllProduct(): Flow<Resource<List<GalleryEntities>>>
    suspend fun getDetailProduct(id: Int): Flow<Resource<GalleryEntities>>
    fun updateProduct(galleryEntities: GalleryEntities)

}