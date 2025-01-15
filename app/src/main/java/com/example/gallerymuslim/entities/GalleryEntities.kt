package com.example.gallerymuslim.entities

import android.net.Uri
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GalleryEntities(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int? = 0,
    @ColumnInfo(name = "product_type")
    val productType: String? = null,
    @ColumnInfo(name = "product_name")
    val productName: String? = null,
    @ColumnInfo(name = "product_stock")
    val productStock: Int? = null,
    @ColumnInfo(name = "product_size")
    val productSize: String? = null,
    @ColumnInfo(name = "product_color")
    val productColor: String? = null,
    @ColumnInfo(name = "product_image")
    val productImage: String? = null,
    @ColumnInfo(name = "product_desc")
    val productDesc: String? = null,

    )