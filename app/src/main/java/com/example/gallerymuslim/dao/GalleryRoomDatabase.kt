package com.example.gallerymuslim.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gallerymuslim.entities.GalleryEntities

@Database(entities = [GalleryEntities::class], version = 1)
abstract class GalleryRoomDatabase: RoomDatabase() {

    abstract fun galleryDao(): GalleryDao
}