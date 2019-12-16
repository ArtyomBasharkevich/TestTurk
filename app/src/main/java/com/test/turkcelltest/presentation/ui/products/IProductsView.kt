package com.test.turkcelltest.presentation.ui.products

import com.test.turkcelltest.domain.entity.ProductItem
import com.test.turkcelltest.presentation.ui.base.IBaseView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface IProductsView : IBaseView {

    fun showLoading()

    fun showData(data: List<ProductItem>)

    fun showError()
}