package com.example.gallerymuslim.usecase.home

import androidx.lifecycle.LiveData
import com.example.gallerymuslim.entities.GalleryEntities
import com.example.gallerymuslim.entities.RegisterEntities
import com.example.gallerymuslim.repository.ILocaleRepository
import com.example.gallerymuslim.vo.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeUseCase @Inject constructor(
    private val localeRepository: ILocaleRepository
): IHomeUseCase {
    override fun getAllUser(): LiveData<List<RegisterEntities>> {
        return localeRepository.getAllUser()
    }

    override suspend fun getListProduct(): Flow<Resource<List<GalleryEntities>>> {
        return localeRepository.getAllProduct()
    }
}