package com.example.gallerymuslim.presentation.home

import androidx.lifecycle.ViewModel
import com.example.gallerymuslim.usecase.home.IHomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val iHomeUseCase: IHomeUseCase
): ViewModel() {

    suspend fun getListProduct() = iHomeUseCase.getListProduct()
}