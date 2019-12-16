package com.test.turkcelltest.presentation.ui.products

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.turkcelltest.R
import com.test.turkcelltest.domain.entity.ProductItem
import com.test.turkcelltest.presentation.GlideRequests
import com.test.turkcelltest.presentation.ui.products.ProductsFragment.OnListFragmentInteractionListener

class ProductsAdapter(
    private val listener: OnListFragmentInteractionListener?,
    private val glideRequests: GlideRequests
) : ListAdapter<ProductItem, ProductsAdapter.ProductsViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_item_product, parent, false)
        return ProductsViewHolder(view, glideRequests).apply {
            view.setOnClickListener {
                getItem(adapterPosition).productId?.toIntOrNull()?.let { id ->
                    listener?.onListFragmentInteraction(id)
                }
            }
        }
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class ProductsViewHolder(view: View, private val glideRequests: GlideRequests) :
        RecyclerView.ViewHolder(view) {

        private val product by lazy { itemView.findViewById<ImageView>(R.id.imageViewProduct) }
        private val name by lazy { itemView.findViewById<TextView>(R.id.textViewName) }
        private val price by lazy { itemView.findViewById<TextView>(R.id.textViewPrice) }

        fun bind(productItem: ProductItem) {
            glideRequests.load(productItem.image)
                .error(android.R.drawable.stat_notify_error)
                .into(product)
            name.text = productItem.name
            price.text = productItem.price.toString()
        }
    }
}

object DiffCallback : DiffUtil.ItemCallback<ProductItem>() {
    override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean =
        oldItem == newItem
}