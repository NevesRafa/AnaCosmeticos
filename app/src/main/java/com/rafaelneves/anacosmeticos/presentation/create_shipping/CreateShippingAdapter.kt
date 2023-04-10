package com.rafaelneves.anacosmeticos.presentation.create_shipping

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rafaelneves.anacosmeticos.data.model.ProductDetails
import com.rafaelneves.anacosmeticos.databinding.ItemListForShippingBinding

class CreateShippingAdapter : RecyclerView.Adapter<CreateShippingViewHolder>() {

    private val dataset = mutableListOf<ProductDetails>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreateShippingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListForShippingBinding.inflate(inflater, parent, false)
        return CreateShippingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CreateShippingViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount() = dataset.size

    fun update(project: List<ProductDetails>) {
        this.dataset.clear()
        this.dataset.addAll(project)
        notifyDataSetChanged()
    }
}

class CreateShippingViewHolder(private val binding: ItemListForShippingBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(product: ProductDetails) {

        binding.productName.text = product.name
        binding.productAmount.text = "${product.amount} Unid."
    }

}
