package com.example.gallerymuslim.usecase.home

import androidx.lifecycle.LiveData
import com.example.gallerymuslim.entities.GalleryEntities
import com.example.gallerymuslim.entities.RegisterEntities
import com.example.gallerymuslim.vo.Resource
import kotlinx.coroutines.flow.Flow

interface IHomeUseCase {
    fun getAllUser(): LiveData<List<RegisterEntities>>
    suspend fun getListProduct(): Flow<Resource<List<GalleryEntities>>>
}