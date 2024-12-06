package com.example.gallerymuslim.module

import com.example.gallerymuslim.repository.ILocaleRepository
import com.example.gallerymuslim.repository.LocaleRepositoryImpl
import com.example.gallerymuslim.source.LocaleDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideLocaleDataSource(
        localeDataSource: LocaleDataSource
    ): ILocaleRepository {
        return LocaleRepositoryImpl(localeDataSource)
    }
}