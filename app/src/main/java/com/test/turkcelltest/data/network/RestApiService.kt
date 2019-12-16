package com.test.turkcelltest.data.network

import com.test.turkcelltest.data.cache.Cache
import com.test.turkcelltest.data.repository.dataprovider.DataProvider
import com.test.turkcelltest.domain.entity.ProductDetails
import com.test.turkcelltest.domain.entity.ProductItem
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RestApiService @Inject constructor(
    private val restApi: IRestApi,
    private val cache: Cache
) : DataProvider {

    override fun getProducts(): Single<List<ProductItem>> =
        restApi.getProducts()
            .map { it.products }
            .doOnSuccess { cache.cacheProducts(it) }  //thread can be changed for async

    override fun getProduct(id: Int): Single<ProductDetails> =
        restApi.getProduct(id)
            .doOnSuccess { cache.cacheProductDetails(it) }  //thread can be changed for async
}