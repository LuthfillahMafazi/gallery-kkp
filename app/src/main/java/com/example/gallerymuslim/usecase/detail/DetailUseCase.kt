package com.example.gallerymuslim.usecase.detail

import com.example.gallerymuslim.entities.GalleryEntities
import com.example.gallerymuslim.repository.ILocaleRepository
import com.example.gallerymuslim.vo.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DetailUseCase @Inject constructor(
    private val iLocaleRepository: ILocaleRepository
): IDetailUseCase {
    override suspend fun getDetailProduct(id: Int): Flow<Resource<GalleryEntities>> {
        return iLocaleRepository.getDetailProduct(id)
    }
}