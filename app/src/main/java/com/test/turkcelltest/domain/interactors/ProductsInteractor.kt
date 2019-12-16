package com.test.turkcelltest.domain.interactors

import com.test.turkcelltest.domain.entity.ProductItem
import com.test.turkcelltest.domain.interactors.base.BaseInteractor
import com.test.turkcelltest.domain.usecases.GetProductsUseCase
import javax.inject.Inject

class ProductsInteractor @Inject constructor(private val getProductsUseCase: GetProductsUseCase) :
    BaseInteractor() {

    fun getProducts(onSuccess: (List<ProductItem>) -> Unit, onError: (Throwable) -> Unit) {
        execute(getProductsUseCase, Unit, onSuccess, onError)
    }
}