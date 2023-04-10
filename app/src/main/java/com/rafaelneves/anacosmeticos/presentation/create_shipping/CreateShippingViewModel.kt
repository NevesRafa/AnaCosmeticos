package com.rafaelneves.anacosmeticos.presentation.create_shipping

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaelneves.anacosmeticos.domain.ProductRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CreateShippingViewModel(private val repository: ProductRepository) : ViewModel() {

    val screenState = MutableLiveData<CreateShippingState>()

    fun loadData() {
        viewModelScope.launch {
            delay(2000L)
            screenState.value = CreateShippingState.Loading

            try {
                val result = repository.getProducts()
                screenState.postValue(CreateShippingState.Success(result))

            } catch (error: Exception) {
                screenState.postValue(CreateShippingState.Error(error.message))
            }
        }
    }
}

