package com.test.turkcelltest.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class ProductItem(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("price")
    val price: Int? = null,

    @field:SerializedName("product_id")
    val productId: String? = null,

    @field:SerializedName("name")
    val name: String? = null
)