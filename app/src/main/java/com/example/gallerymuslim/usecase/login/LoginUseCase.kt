package com.example.gallerymuslim.usecase.login

import com.example.gallerymuslim.entities.RegisterEntities
import com.example.gallerymuslim.repository.ILocaleRepository
import com.example.gallerymuslim.vo.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val iLocaleRepository: ILocaleRepository
): ILoginUseCase {
    override suspend fun getUserName(userName: String): Flow<Resource<RegisterEntities?>> {
        return iLocaleRepository.getUserName(userName)
    }
}