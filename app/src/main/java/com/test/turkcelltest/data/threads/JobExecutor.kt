package com.test.turkcelltest.data.threads

import com.test.turkcelltest.domain.executor.ExecutionThread
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JobExecutor @Inject constructor() : ExecutionThread {

    override fun getScheduler() = Schedulers.io()

}