package com.test.turkcelltest.presentation.ui.productdetails

import com.test.turkcelltest.domain.interactors.ProductDetailsInteractor
import com.test.turkcelltest.presentation.di.Injector
import com.test.turkcelltest.presentation.di.annotations.PerFragment
import com.test.turkcelltest.presentation.ui.base.BasePresenter
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
@PerFragment(ProductDetailsFragment::class)
class ProductDetailsPresenter @Inject constructor() :
    BasePresenter<IProductDetailsView, ProductDetailsInteractor>() {

    var id = 0
        set(value) {
            if (field == 0) field = value
        }

    override fun clearComponent() {
        Injector.clearProductDetailsComponent()
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showLoading()
        interactor.getProduct(id, { viewState.showData(it) }, { viewState.showError() })
    }
}