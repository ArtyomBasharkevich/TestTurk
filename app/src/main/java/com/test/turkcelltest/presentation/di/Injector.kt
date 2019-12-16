package com.test.turkcelltest.presentation.di

import com.test.turkcelltest.presentation.TestApp
import com.test.turkcelltest.presentation.di.components.AppComponent
import com.test.turkcelltest.presentation.di.components.DaggerAppComponent
import com.test.turkcelltest.presentation.ui.productdetails.ProductDetailsFragment
import com.test.turkcelltest.presentation.ui.productdetails.di.ProductDetailsComponent
import com.test.turkcelltest.presentation.ui.products.ProductsFragment
import com.test.turkcelltest.presentation.ui.products.di.ProductsComponent

object Injector {
    private lateinit var appComponent: AppComponent
    private var productsComponent: ProductsComponent? = null
    private var productDetailsComponent: ProductDetailsComponent? = null

    fun initializeAppComponent(application: TestApp) {
        appComponent = DaggerAppComponent
            .factory()
            .create(application)
    }


    fun plusProductsComponent(fragment: ProductsFragment) =
        (productsComponent ?: appComponent.plusProductsComponent().also { productsComponent = it })
            .inject(fragment)

    fun clearProductsComponent() {
        productsComponent = null
    }


    fun plusProductDetailsComponent(fragment: ProductDetailsFragment) =
        (productDetailsComponent
            ?: appComponent.plusProductDetailsComponent().also { productDetailsComponent = it })
            .inject(fragment)

    fun clearProductDetailsComponent() {
        productDetailsComponent = null
    }
}