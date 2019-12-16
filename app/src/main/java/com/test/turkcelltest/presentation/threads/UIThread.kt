package com.test.turkcelltest.presentation.threads

import com.test.turkcelltest.domain.executor.PostExecutionThread
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UIThread @Inject constructor() : PostExecutionThread {

    override fun getScheduler() = AndroidSchedulers.mainThread()!!
}