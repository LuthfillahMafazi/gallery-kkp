package com.example.gallerymuslim.source

import com.example.gallerymuslim.dao.GalleryDao
import javax.inject.Inject

class LocaleDataSource @Inject constructor(
    private val galleryDao: GalleryDao
) {
}