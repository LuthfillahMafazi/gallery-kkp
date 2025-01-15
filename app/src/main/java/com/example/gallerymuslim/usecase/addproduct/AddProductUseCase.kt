package com.example.gallerymuslim.usecase.addproduct

import com.example.gallerymuslim.entities.GalleryEntities
import com.example.gallerymuslim.repository.ILocaleRepository
import javax.inject.Inject

class AddProductUseCase @Inject constructor(
    private val iLocaleRepository: ILocaleRepository
): IAddProductUseCase {
    override fun addProduct(galleryEntities: GalleryEntities) {
        return iLocaleRepository.addProduct(galleryEntities)
    }
}