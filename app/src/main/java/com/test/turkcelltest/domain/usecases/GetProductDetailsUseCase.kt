package com.test.turkcelltest.domain.usecases

import com.test.turkcelltest.domain.entity.ProductDetails
import com.test.turkcelltest.domain.usecases.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetProductDetailsUseCase @Inject constructor() : SingleUseCase<Int, ProductDetails>() {

    override fun buildUseCase(param: Int): Single<ProductDetails> = repository.getProduct(param)
}