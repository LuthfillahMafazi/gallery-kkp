package com.example.gallerymuslim.module

import com.example.gallerymuslim.repository.ILocaleRepository
import com.example.gallerymuslim.usecase.HomeUseCase
import com.example.gallerymuslim.usecase.IHomeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideHomeUseCase(iLocaleRepository: ILocaleRepository): IHomeUseCase {
        return HomeUseCase(iLocaleRepository)
    }
}