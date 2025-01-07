package com.example.gallerymuslim.usecase.register

import com.example.gallerymuslim.entities.RegisterEntities
import com.example.gallerymuslim.vo.Resource
import kotlinx.coroutines.flow.Flow

interface IRegisterUseCase {
    fun registerUser(registerEntities: RegisterEntities)
    suspend fun getUserName(userName: String): Flow<Resource<RegisterEntities?>>
}