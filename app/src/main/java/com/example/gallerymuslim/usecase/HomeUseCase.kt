package com.example.gallerymuslim.usecase

import androidx.lifecycle.LiveData
import com.example.gallerymuslim.entities.RegisterEntities
import com.example.gallerymuslim.repository.ILocaleRepository
import javax.inject.Inject

class HomeUseCase @Inject constructor(
    private val localeRepository: ILocaleRepository
): IHomeUseCase {
    override fun getAllUser(): LiveData<List<RegisterEntities>> {
        return localeRepository.getAllUser()
    }
}