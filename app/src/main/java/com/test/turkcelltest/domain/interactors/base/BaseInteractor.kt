package com.test.turkcelltest.domain.interactors.base

import com.test.turkcelltest.domain.usecases.base.SingleUseCase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

open class BaseInteractor @Inject constructor() {

    private var disposables: CompositeDisposable = CompositeDisposable()

    protected fun <InParam, OutParam : Any> execute(
        useCase: SingleUseCase<InParam, OutParam>,
        inParam: InParam,
        onSuccess: ((OutParam) -> Unit) = {},
        onError: ((Throwable) -> Unit) = {}
    ) {
        useCase.execute(inParam).subscribeBy(onError, onSuccess).addTo(disposables)
    }

    fun clear() {
        disposables.clear()
    }
}