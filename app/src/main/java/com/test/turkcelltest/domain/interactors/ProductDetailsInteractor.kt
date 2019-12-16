package com.test.turkcelltest.domain.interactors

import com.test.turkcelltest.domain.entity.ProductDetails
import com.test.turkcelltest.domain.interactors.base.BaseInteractor
import com.test.turkcelltest.domain.usecases.GetProductDetailsUseCase
import javax.inject.Inject

class ProductDetailsInteractor @Inject constructor(private val getProductDetailsUseCase: GetProductDetailsUseCase) :
    BaseInteractor() {

    fun getProduct(id: Int, onSuccess: (ProductDetails) -> Unit, onError: (Throwable) -> Unit) {
        execute(getProductDetailsUseCase, id, onSuccess, onError)
    }
}