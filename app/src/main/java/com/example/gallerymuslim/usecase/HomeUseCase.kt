package com.example.gallerymuslim.usecase

import com.example.gallerymuslim.repository.ILocaleRepository
import javax.inject.Inject

class HomeUseCase @Inject constructor(
    private val localeRepository: ILocaleRepository
): IHomeUseCase {
}