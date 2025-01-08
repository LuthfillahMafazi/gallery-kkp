package com.example.gallerymuslim.usecase.login

import com.example.gallerymuslim.entities.RegisterEntities
import com.example.gallerymuslim.vo.Resource
import kotlinx.coroutines.flow.Flow

interface ILoginUseCase {
    suspend fun getUserName(userName: String): Flow<Resource<RegisterEntities?>>
}