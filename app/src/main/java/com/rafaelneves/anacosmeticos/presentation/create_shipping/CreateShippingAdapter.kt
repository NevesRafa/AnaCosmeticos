package com.rafaelneves.anacosmeticos.presentation.create_shipping

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rafaelneves.anacosmeticos.data.model.Product
import com.rafaelneves.anacosmeticos.databinding.ItemListForShippingBinding

class CreateShippingAdapter : RecyclerView.Adapter<CreateShippingViewHolder>() {

    private val dataset = mutableListOf<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreateShippingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListForShippingBinding.inflate(inflater, parent, false)
        return CreateShippingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CreateShippingViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount() = dataset.size

    fun update(project: List<Product>) {
        this.dataset.clear()
        this.dataset.addAll(project)
        notifyDataSetChanged()
    }
}

class CreateShippingViewHolder(private val binding: ItemListForShippingBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(product: Product) {

        binding.productDescription.text = product.description
        binding.productName.text = product.name
        binding.productMaker.text = product.maker
        binding.productAmount.text = "${product.amount} Unid."
    }

}
