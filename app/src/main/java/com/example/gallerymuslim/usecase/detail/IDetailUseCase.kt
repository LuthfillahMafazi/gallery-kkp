package com.example.gallerymuslim.usecase.detail

import com.example.gallerymuslim.entities.GalleryEntities
import com.example.gallerymuslim.vo.Resource
import kotlinx.coroutines.flow.Flow

interface IDetailUseCase {
    suspend fun getDetailProduct(id: Int): Flow<Resource<GalleryEntities>>
}