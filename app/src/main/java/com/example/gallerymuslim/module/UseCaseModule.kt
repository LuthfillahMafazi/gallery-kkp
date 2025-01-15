package com.example.gallerymuslim.module

import com.example.gallerymuslim.repository.ILocaleRepository
import com.example.gallerymuslim.usecase.home.HomeUseCase
import com.example.gallerymuslim.usecase.home.IHomeUseCase
import com.example.gallerymuslim.usecase.addproduct.AddProductUseCase
import com.example.gallerymuslim.usecase.addproduct.IAddProductUseCase
import com.example.gallerymuslim.usecase.detail.DetailUseCase
import com.example.gallerymuslim.usecase.detail.IDetailUseCase
import com.example.gallerymuslim.usecase.login.ILoginUseCase
import com.example.gallerymuslim.usecase.login.LoginUseCase
import com.example.gallerymuslim.usecase.register.IRegisterUseCase
import com.example.gallerymuslim.usecase.register.RegisterUseCase
import com.example.gallerymuslim.usecase.updateproduct.IUpdateProductUseCase
import com.example.gallerymuslim.usecase.updateproduct.UpdateProductUseCase
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

    @Provides
    fun provideAddProductUseCase(iLocaleRepository: ILocaleRepository): IAddProductUseCase {
        return AddProductUseCase(iLocaleRepository)
    }

    @Provides
    fun provideDetailUseCase(iLocaleRepository: ILocaleRepository): IDetailUseCase {
        return DetailUseCase(iLocaleRepository)
    }

    @Provides
    fun provideUpdateProductUseCase(iLocaleRepository: ILocaleRepository): IUpdateProductUseCase {
        return UpdateProductUseCase(iLocaleRepository)
    }
}