package com.test.turkcelltest.data.cache.db.fishdata

import com.test.turkcelltest.domain.entity.ProductDetails
import com.test.turkcelltest.domain.entity.ProductItem
import io.reactivex.Single

interface IProductsDAO {

    fun getProducts(): Single<List<ProductItem>>

    fun getProduct(id: Int): Single<ProductDetails>

    fun cacheProducts(products: List<ProductItem>)

    fun cacheProductDetails(productDetails: ProductDetails)
}