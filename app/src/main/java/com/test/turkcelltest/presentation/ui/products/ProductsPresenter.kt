package com.test.turkcelltest.presentation.ui.products

import com.test.turkcelltest.domain.interactors.ProductsInteractor
import com.test.turkcelltest.presentation.di.Injector
import com.test.turkcelltest.presentation.di.annotations.PerFragment
import com.test.turkcelltest.presentation.ui.base.BasePresenter
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
@PerFragment(ProductsFragment::class)
class ProductsPresenter @Inject constructor() : BasePresenter<IProductsView, ProductsInteractor>() {

    override fun clearComponent() {
        Injector.clearProductsComponent()
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showLoading()
        interactor.getProducts({ viewState.showData(it) }, { viewState.showError() })
    }
}