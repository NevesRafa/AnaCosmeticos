package com.rafaelneves.anacosmeticos.presentation.create_shipping

import com.rafaelneves.anacosmeticos.data.model.Product

sealed class CreateShippingState {

    object Idle : CreateShippingState()

    object Loading : CreateShippingState()

    data class Success(val response: List<Product>) : CreateShippingState()

    data class Error(val errorMessage: String?) : CreateShippingState()
}