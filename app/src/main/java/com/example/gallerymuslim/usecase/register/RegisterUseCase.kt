package com.example.gallerymuslim.usecase.register

import com.example.gallerymuslim.entities.RegisterEntities
import com.example.gallerymuslim.repository.ILocaleRepository
import com.example.gallerymuslim.vo.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val localeRepository: ILocaleRepository
) : IRegisterUseCase {
    override fun registerUser(registerEntities: RegisterEntities) {
        return localeRepository.registerUser(registerEntities)
    }

    override suspend fun getUserName(userName: String): Flow<Resource<RegisterEntities?>> {
        return localeRepository.getUserName(userName)
    }

}