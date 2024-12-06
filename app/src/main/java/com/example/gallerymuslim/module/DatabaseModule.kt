package com.example.gallerymuslim.module

import android.content.Context
import androidx.room.Room
import com.example.gallerymuslim.dao.GalleryDao
import com.example.gallerymuslim.dao.GalleryRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): GalleryRoomDatabase {
        val passphrase = SQLiteDatabase.getBytes("gallery".toCharArray())
        val factory = SupportFactory(passphrase)
        return Room.databaseBuilder(
            context,
            GalleryRoomDatabase::class.java,
            "Gallery.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }

    @Provides
    fun provideGalleryDao(database: GalleryRoomDatabase): GalleryDao = database.galleryDao()
}