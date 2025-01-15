package com.example.gallerymuslim.usecase.updateproduct

import com.example.gallerymuslim.entities.GalleryEntities
import com.example.gallerymuslim.vo.Resource
import kotlinx.coroutines.flow.Flow

interface IUpdateProductUseCase {
    fun updateProduct(galleryEntities: GalleryEntities)
    suspend fun getDetailProduct(id: Int): Flow<Resource<GalleryEntities>>
}