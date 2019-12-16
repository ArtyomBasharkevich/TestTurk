package com.test.turkcelltest.presentation.ui.productdetails.di

import com.test.turkcelltest.presentation.di.annotations.PerFragment
import com.test.turkcelltest.presentation.ui.productdetails.ProductDetailsFragment
import dagger.Subcomponent

@PerFragment(ProductDetailsFragment::class)
@Subcomponent
interface ProductDetailsComponent {

    fun inject(fragment: ProductDetailsFragment)
}