package com.rafaelneves.anacosmeticos.presentation.create_shipping

import com.rafaelneves.anacosmeticos.data.model.ProductDetails

sealed class CreateShippingState {

    object Idle : CreateShippingState()

    object Loading : CreateShippingState()

    data class Success(val response: List<ProductDetails>) : CreateShippingState()

    data class Error(val errorMessage: String?) : CreateShippingState()
}