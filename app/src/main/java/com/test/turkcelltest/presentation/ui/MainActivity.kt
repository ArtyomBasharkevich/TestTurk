package com.test.turkcelltest.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.commitNow
import com.test.turkcelltest.R
import com.test.turkcelltest.presentation.ui.productdetails.ProductDetailsFragment
import com.test.turkcelltest.presentation.ui.products.ProductsFragment

class MainActivity : AppCompatActivity(R.layout.activity_main),
    ProductsFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.commitNow {
                replace(R.id.frameLayoutMainFragmentContainer, ProductsFragment.newInstance())
            }
        }
    }

    override fun onListFragmentInteraction(id: Int) {
        val fragment = ProductDetailsFragment.getInstance(supportFragmentManager, id)
        supportFragmentManager.commit {
            replace(R.id.frameLayoutMainFragmentContainer, fragment, fragment::class.java.name)
            addToBackStack(null)
        }
    }
}
