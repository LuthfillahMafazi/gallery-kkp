package com.example.gallerymuslim.presentation.detail

import androidx.lifecycle.ViewModel
import com.example.gallerymuslim.usecase.detail.IDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailProductViewModel @Inject constructor(
    private val iDetailUseCase: IDetailUseCase
): ViewModel() {

    suspend fun getDetailProduct(id: Int) = iDetailUseCase.getDetailProduct(id)
}