package com.test.turkcelltest.data.entity

import com.google.gson.annotations.SerializedName
import com.test.turkcelltest.domain.entity.ProductItem

data class Products(

    @field:SerializedName("products")
    val products: List<ProductItem>
)