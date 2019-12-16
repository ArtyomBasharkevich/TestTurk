package com.test.turkcelltest.presentation.ui.productdetails

import com.test.turkcelltest.domain.entity.ProductDetails
import com.test.turkcelltest.presentation.ui.base.IBaseView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface IProductDetailsView : IBaseView {

    fun showLoading()

    fun showData(data: ProductDetails)

    fun showError()
}