package com.example.gallerymuslim.source

import androidx.lifecycle.LiveData
import com.example.gallerymuslim.dao.GalleryDao
import com.example.gallerymuslim.entities.RegisterEntities
import kotlinx.coroutines.flow.Flow
import java.util.concurrent.Executors
import javax.inject.Inject

class LocaleDataSource @Inject constructor(
    private val galleryDao: GalleryDao
) {
    private val executorService = Executors.newSingleThreadExecutor()

    fun registerUser(registerEntities: RegisterEntities) {
        executorService.execute {
            galleryDao.insert(registerEntities)
        }
    }

    fun getUserName(userName: String): Flow<RegisterEntities?> = galleryDao.getUsername(userName)
    fun getAllUser(): LiveData<List<RegisterEntities>> = galleryDao.getAllUsers()


}