package com.example.gallerymuslim.repository

import androidx.lifecycle.LiveData
import com.example.gallerymuslim.entities.RegisterEntities
import com.example.gallerymuslim.vo.Resource
import kotlinx.coroutines.flow.Flow

interface ILocaleRepository {
    fun registerUser(registerEntities: RegisterEntities)
    suspend fun getUserName(userName: String): Flow<Resource<RegisterEntities?>>
    fun getAllUser(): LiveData<List<RegisterEntities>>
}