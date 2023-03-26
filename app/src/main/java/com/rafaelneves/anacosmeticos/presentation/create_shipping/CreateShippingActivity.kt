package com.rafaelneves.anacosmeticos.presentation.create_shipping

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rafaelneves.anacosmeticos.data.model.Product
import com.rafaelneves.anacosmeticos.databinding.ActivityRegistrationShippingBinding
import org.koin.android.ext.android.inject

class CreateShippingActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegistrationShippingBinding
    lateinit var adapter: CreateShippingAdapter
    private val viewModel: CreateShippingViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationShippingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupLiveData()
        setupList()

        viewModel.loadData()
    }

    private fun setupLiveData() {
        viewModel.screenState.observe(this) { createShippingState ->
            when (createShippingState) {
                is CreateShippingState.Idle -> {}
                is CreateShippingState.Loading -> {}
                is CreateShippingState.Success -> onSuccess(createShippingState.response)
                is CreateShippingState.Error -> {}
            }
        }
    }

    private fun onSuccess(result: List<Product>) {
        adapter.update(result)
    }

    private fun setupList() {

        binding.recyclerViewItems.layoutManager = LinearLayoutManager(this)

        adapter = CreateShippingAdapter()

        binding.recyclerViewItems.adapter = adapter
    }
}