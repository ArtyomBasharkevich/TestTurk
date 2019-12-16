package com.test.turkcelltest.presentation.ui.base

import com.test.turkcelltest.domain.interactors.base.BaseInteractor
import moxy.MvpPresenter
import javax.inject.Inject

abstract class BasePresenter<V : IBaseView, I : BaseInteractor> : MvpPresenter<V>() {

    @Inject
    protected lateinit var interactor: I

    protected abstract fun clearComponent()

    override fun onDestroy() {
        interactor.clear()
        clearComponent()
        super.onDestroy()
    }
}