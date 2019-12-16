package com.test.turkcelltest.presentation.ui.products

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.test.turkcelltest.R
import com.test.turkcelltest.domain.entity.ProductItem
import com.test.turkcelltest.presentation.GlideApp
import com.test.turkcelltest.presentation.di.Injector
import com.test.turkcelltest.presentation.ui.base.BaseFragment
import moxy.ktx.moxyPresenter


class ProductsFragment : BaseFragment<ProductsPresenter>(R.layout.fragment_products),
    IProductsView {

    private val textViewEmpty by resettableLazy { requireView().findViewById<TextView>(R.id.textViewEmpty) }
    private val recyclerView by resettableLazy { requireView().findViewById<RecyclerView>(R.id.recyclerViewProducts) }
    private val progressBar by resettableLazy { requireView().findViewById<ProgressBar>(R.id.progressBarProducts) }
    private val adapter by resettableLazy { ProductsAdapter(listener, GlideApp.with(this)) }
    private var listener: OnListFragmentInteractionListener? = null

    override val presenter: ProductsPresenter by moxyPresenter { presenterProvider.get() }

    override fun injectComponent() {
        Injector.plusProductsComponent(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("ProductsFragment", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("ProductsFragment", "onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("ProductsFragment", "onViewCreated")
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("ProductsFragment", "onAttach")
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("ProductsFragment", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("ProductsFragment", "onDestroy")
    }

    override fun onDetach() {
        listener = null
        super.onDetach()
        Log.e("ProductsFragment", "onDetach")
    }

    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(id: Int)
    }

    override fun showData(data: List<ProductItem>) {
        progressBar.isVisible = false
        adapter.submitList(data)
        if (data.isEmpty()) {
            textViewEmpty.isVisible = true
        } else {
            recyclerView.isVisible = true
        }
    }

    override fun showLoading() {
        textViewEmpty.isVisible = false
        progressBar.isVisible = true
        recyclerView.isVisible = false
    }

    override fun showError() {
        textViewEmpty.isVisible = true
        progressBar.isVisible = false
        Toast.makeText(requireContext().applicationContext, R.string.error, Toast.LENGTH_SHORT)
            .show()
    }

    companion object {
        fun newInstance() = ProductsFragment()
    }
}
