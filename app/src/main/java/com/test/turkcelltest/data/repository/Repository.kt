package com.test.turkcelltest.data.repository

import com.test.turkcelltest.data.repository.dataprovider.DataProviderFactory
import com.test.turkcelltest.domain.entity.ProductDetails
import com.test.turkcelltest.domain.entity.ProductItem
import com.test.turkcelltest.domain.repository.IRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val dataProviderFactory: DataProviderFactory) :
    IRepository {

    override fun getProducts(): Single<List<ProductItem>> =
        dataProviderFactory.dataProvider.getProducts()

    override fun getProduct(id: Int): Single<ProductDetails> =
        dataProviderFactory.dataProvider.getProduct(id)
}