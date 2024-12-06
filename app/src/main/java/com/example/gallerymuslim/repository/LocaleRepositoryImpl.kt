package com.example.gallerymuslim.repository

import com.example.gallerymuslim.source.LocaleDataSource
import javax.inject.Inject

class LocaleRepositoryImpl @Inject constructor(
    private val localeDataSource: LocaleDataSource
): ILocaleRepository {
}