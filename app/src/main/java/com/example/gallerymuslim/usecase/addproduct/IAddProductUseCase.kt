package com.example.gallerymuslim.usecase.addproduct

import com.example.gallerymuslim.entities.GalleryEntities

interface IAddProductUseCase {
    fun addProduct(galleryEntities: GalleryEntities)
}