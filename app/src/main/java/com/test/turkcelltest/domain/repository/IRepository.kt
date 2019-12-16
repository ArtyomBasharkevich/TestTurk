package com.test.turkcelltest.domain.repository

import com.test.turkcelltest.domain.entity.ProductDetails
import com.test.turkcelltest.domain.entity.ProductItem
import io.reactivex.Single

interface IRepository {
    fun getProducts(): Single<List<ProductItem>>

    fun getProduct(id: Int): Single<ProductDetails>
}