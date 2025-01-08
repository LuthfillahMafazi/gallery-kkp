package com.example.gallerymuslim.usecase

import androidx.lifecycle.LiveData
import com.example.gallerymuslim.entities.RegisterEntities

interface IHomeUseCase {
    fun getAllUser(): LiveData<List<RegisterEntities>>
}