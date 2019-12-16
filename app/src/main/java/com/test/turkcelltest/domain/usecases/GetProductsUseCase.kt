package com.test.turkcelltest.domain.usecases

import com.test.turkcelltest.domain.entity.ProductItem
import com.test.turkcelltest.domain.usecases.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetProductsUseCase @Inject constructor() : SingleUseCase<Unit, List<ProductItem>>() {

    override fun buildUseCase(param: Unit): Single<List<ProductItem>> = repository.getProducts()
}