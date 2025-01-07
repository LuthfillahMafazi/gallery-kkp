package com.example.gallerymuslim.module

import com.example.gallerymuslim.repository.ILocaleRepository
import com.example.gallerymuslim.usecase.HomeUseCase
import com.example.gallerymuslim.usecase.IHomeUseCase
import com.example.gallerymuslim.usecase.login.ILoginUseCase
import com.example.gallerymuslim.usecase.login.LoginUseCase
import com.example.gallerymuslim.usecase.register.IRegisterUseCase
import com.example.gallerymuslim.usecase.register.RegisterUseCase
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

    @Provides
    fun provideRegisterUseCase(iLocaleRepository: ILocaleRepository): IRegisterUseCase {
        return RegisterUseCase(iLocaleRepository)
    }

    @Provides
    fun provideLoginUseCase(iLocaleRepository: ILocaleRepository): ILoginUseCase {
        return LoginUseCase(iLocaleRepository)
    }
}