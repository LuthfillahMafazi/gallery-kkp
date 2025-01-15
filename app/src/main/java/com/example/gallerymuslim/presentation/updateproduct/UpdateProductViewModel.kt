package com.example.gallerymuslim.presentation.updateproduct

import androidx.lifecycle.ViewModel
import com.example.gallerymuslim.entities.GalleryEntities
import com.example.gallerymuslim.usecase.updateproduct.IUpdateProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UpdateProductViewModel @Inject constructor(
    private val iUpdateProductUseCase: IUpdateProductUseCase
): ViewModel() {

    suspend fun getDetailProduct(id: Int) = iUpdateProductUseCase.getDetailProduct(id)

    fun updateProduct(galleryEntities: GalleryEntities) = iUpdateProductUseCase.updateProduct(galleryEntities)

}