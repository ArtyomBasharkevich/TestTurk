package com.test.turkcelltest.presentation

import android.app.Application
import com.test.turkcelltest.presentation.di.Injector

class TestApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Injector.initializeAppComponent(this)
    }
}