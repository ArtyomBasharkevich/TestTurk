package com.test.turkcelltest.data.network

import com.test.turkcelltest.data.entity.Products
import com.test.turkcelltest.domain.entity.ProductDetails
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface IRestApi {

    @GET("list")
    fun getProducts(): Single<Products>

    @GET("{id}/detail ")
    fun getProduct(@Path("id") id: Int): Single<ProductDetails>

}