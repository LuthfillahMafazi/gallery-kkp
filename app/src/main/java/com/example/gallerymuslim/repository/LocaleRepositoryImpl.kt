package com.example.gallerymuslim.repository

import androidx.lifecycle.LiveData
import com.example.gallerymuslim.entities.RegisterEntities
import com.example.gallerymuslim.source.LocaleDataSource
import com.example.gallerymuslim.vo.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LocaleRepositoryImpl @Inject constructor(
    private val localeDataSource: LocaleDataSource
): ILocaleRepository {
    override fun registerUser(registerEntities: RegisterEntities) {
        localeDataSource.registerUser(registerEntities)
    }

    override suspend fun getUserName(userName: String): Flow<Resource<RegisterEntities?>> {
        return flow {
            emit(Resource.Loading())
            localeDataSource.getUserName(userName).collect {
                emit(Resource.Success(it))
            }
        }
    }

    override fun getAllUser(): LiveData<List<RegisterEntities>> {
        return localeDataSource.getAllUser()
    }
}