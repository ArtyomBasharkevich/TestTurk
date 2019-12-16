package com.test.turkcelltest.presentation.ui.productdetails

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.Group
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentManager
import com.test.turkcelltest.R
import com.test.turkcelltest.domain.entity.ProductDetails
import com.test.turkcelltest.presentation.GlideApp
import com.test.turkcelltest.presentation.di.Injector
import com.test.turkcelltest.presentation.ui.base.BaseFragment
import moxy.ktx.moxyPresenter


class ProductDetailsFragment :
    BaseFragment<ProductDetailsPresenter>(R.layout.fragment_product_details),
    IProductDetailsView {

    private val progressBar by resettableLazy { requireView().findViewById<ProgressBar>(R.id.progressBarProducts) }
    private val imageView by resettableLazy { requireView().findViewById<ImageView>(R.id.imageViewDetails) }
    private val title by resettableLazy { requireView().findViewById<TextView>(R.id.textViewDetailsTitle) }
    private val description by resettableLazy { requireView().findViewById<TextView>(R.id.textViewDetailsDescription) }
    private val textViewEmpty by resettableLazy { requireView().findViewById<TextView>(R.id.textViewDetailsEmpty) }
    private val groupData by resettableLazy { requireView().findViewById<Group>(R.id.groupDetailsData) }

    override val presenter: ProductDetailsPresenter by moxyPresenter { presenterProvider.get() }

    override fun injectComponent() {
        Injector.plusProductDetailsComponent(this)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("ProductDetailsFragment", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("ProductDetailsFragment", "onCreate")
        presenter.id = requireArguments().getInt(EXTRA_ID)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("ProductDetailsFragment", "onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("ProductDetailsFragment", "onViewCreated")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("ProductDetailsFragment", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("ProductDetailsFragment", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("ProductDetailsFragment", "onDetach")
    }

    override fun showData(data: ProductDetails) {
        groupData.isVisible = true
        progressBar.isVisible = false
        title.text = data.name
        description.text = data.description
        GlideApp.with(this)
            .load(data.image)
            .error(android.R.drawable.stat_notify_error)
            .into(imageView)
    }

    override fun showLoading() {
        progressBar.isVisible = true
        textViewEmpty.isVisible = false
        groupData.isVisible = false
    }

    override fun showError() {
        progressBar.isVisible = false
        textViewEmpty.isVisible = true
        Toast.makeText(requireContext().applicationContext, R.string.error, Toast.LENGTH_SHORT)
            .show()
    }

    companion object {
        private const val EXTRA_ID = "com.test.turkcelltest.presentation.ui.productdetails.EXTRA_ID"

        fun getInstance(fragmentManager: FragmentManager, id: Int): ProductDetailsFragment {
            val fragment =
                fragmentManager.findFragmentByTag(ProductDetailsFragment::class.java.name)
            return if (fragment is ProductDetailsFragment) {
                fragment
            } else {
                ProductDetailsFragment()
            }.apply { arguments = bundleOf(EXTRA_ID to id) }
        }
    }
}
