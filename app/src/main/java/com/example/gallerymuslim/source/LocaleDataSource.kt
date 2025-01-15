package com.example.gallerymuslim.source

import androidx.lifecycle.LiveData
import com.example.gallerymuslim.dao.GalleryDao
import com.example.gallerymuslim.entities.GalleryEntities
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

    fun addProduct(galleryEntities: GalleryEntities) {
        executorService.execute {
            galleryDao.addProduct(galleryEntities)
        }
    }

    fun updateProduct(galleryEntities: GalleryEntities) {
        executorService.execute {
            galleryDao.updateProduct(galleryEntities)
        }
    }

    fun getUserName(userName: String): Flow<RegisterEntities?> = galleryDao.getUsername(userName)

    fun getAllUser(): LiveData<List<RegisterEntities>> = galleryDao.getAllUsers()

    fun getAllProduct(): Flow<List<GalleryEntities>> = galleryDao.getAllProduct()

    fun getDetailProduct(idProduct: Int): Flow<GalleryEntities?> = galleryDao.getDetailProduct(idProduct)

}