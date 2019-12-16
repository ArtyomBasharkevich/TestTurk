package com.test.turkcelltest.data.cache

import com.test.turkcelltest.data.cache.db.fishdata.IProductsDAO
import com.test.turkcelltest.data.repository.dataprovider.DataProvider
import com.test.turkcelltest.domain.entity.ProductDetails
import com.test.turkcelltest.domain.entity.ProductItem
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Cache @Inject constructor(private val productsDAO: IProductsDAO) : DataProvider {

    override fun getProducts(): Single<List<ProductItem>> = productsDAO.getProducts()

    override fun getProduct(id: Int): Single<ProductDetails> = productsDAO.getProduct(id)

    fun cacheProducts(products: List<ProductItem>) {
        productsDAO.cacheProducts(products)
    }

    fun cacheProductDetails(productDetails: ProductDetails) {
        productsDAO.cacheProductDetails(productDetails)
    }
}