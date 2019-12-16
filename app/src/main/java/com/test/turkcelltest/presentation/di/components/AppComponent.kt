package com.test.turkcelltest.presentation.di.components

import android.content.Context
import com.test.turkcelltest.presentation.di.modules.AppModule
import com.test.turkcelltest.presentation.di.modules.RestModule
import com.test.turkcelltest.presentation.ui.productdetails.di.ProductDetailsComponent
import com.test.turkcelltest.presentation.ui.products.di.ProductsComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RestModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun plusProductsComponent(): ProductsComponent
    fun plusProductDetailsComponent(): ProductDetailsComponent
}