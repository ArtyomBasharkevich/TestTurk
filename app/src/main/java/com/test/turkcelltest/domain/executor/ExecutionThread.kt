package com.test.turkcelltest.domain.executor

import io.reactivex.Scheduler

interface ExecutionThread {
    fun getScheduler(): Scheduler
}