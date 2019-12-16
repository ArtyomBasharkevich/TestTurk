package com.test.turkcelltest.data.repository.dataprovider

import com.test.turkcelltest.domain.entity.ProductDetails
import com.test.turkcelltest.domain.entity.ProductItem
import io.reactivex.Single


interface DataProvider {

    fun getProducts(): Single<List<ProductItem>>

    fun getProduct(id: Int): Single<ProductDetails>

}