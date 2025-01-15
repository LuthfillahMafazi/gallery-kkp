package com.example.gallerymuslim.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gallerymuslim.entities.GalleryEntities
import com.example.gallerymuslim.entities.RegisterEntities

@Database(entities = [GalleryEntities::class, RegisterEntities::class], version = 2, exportSchema = true)
abstract class GalleryRoomDatabase: RoomDatabase() {

    abstract fun galleryDao(): GalleryDao
}