package com.test.turkcelltest.presentation.ui.products.di

import com.test.turkcelltest.presentation.di.annotations.PerFragment
import com.test.turkcelltest.presentation.ui.products.ProductsFragment
import dagger.Subcomponent

@PerFragment(ProductsFragment::class)
@Subcomponent
interface ProductsComponent {

    fun inject(fragment: ProductsFragment)
}