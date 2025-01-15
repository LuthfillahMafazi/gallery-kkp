package com.example.gallerymuslim.usecase.updateproduct

import com.example.gallerymuslim.entities.GalleryEntities
import com.example.gallerymuslim.repository.ILocaleRepository
import com.example.gallerymuslim.vo.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpdateProductUseCase @Inject constructor(
    private val iLocaleRepository: ILocaleRepository
): IUpdateProductUseCase {
    override fun updateProduct(galleryEntities: GalleryEntities) {
        iLocaleRepository.updateProduct(galleryEntities)
    }

    override suspend fun getDetailProduct(id: Int): Flow<Resource<GalleryEntities>> {
        return iLocaleRepository.getDetailProduct(id)
    }
}