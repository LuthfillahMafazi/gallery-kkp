package com.example.gallerymuslim.presentation.addproduct

import androidx.lifecycle.ViewModel
import com.example.gallerymuslim.entities.GalleryEntities
import com.example.gallerymuslim.usecase.addproduct.IAddProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddProductViewModel @Inject constructor(
    private val iAddProductUseCase: IAddProductUseCase
): ViewModel() {

    fun addProduct(galleryEntities: GalleryEntities) = iAddProductUseCase.addProduct(galleryEntities)
}