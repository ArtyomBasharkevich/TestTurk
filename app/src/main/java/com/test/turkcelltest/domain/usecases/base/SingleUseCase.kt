package com.test.turkcelltest.domain.usecases.base

import com.test.turkcelltest.domain.executor.ExecutionThread
import com.test.turkcelltest.domain.executor.PostExecutionThread
import com.test.turkcelltest.domain.repository.IRepository
import io.reactivex.Single
import javax.inject.Inject

abstract class SingleUseCase<InParam, OutParam> {
    @Inject
    protected lateinit var repository: IRepository
    @Inject
    lateinit var executionThread: ExecutionThread
    @Inject
    lateinit var postExecutionThread: PostExecutionThread

    protected abstract fun buildUseCase(param: InParam): Single<OutParam>

    fun execute(param: InParam): Single<OutParam> {
        return buildUseCase(param)
            .subscribeOn(executionThread.getScheduler())
            .observeOn(postExecutionThread.getScheduler())
    }
}