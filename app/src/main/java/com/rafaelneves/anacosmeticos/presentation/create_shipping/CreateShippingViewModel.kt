package com.rafaelneves.anacosmeticos.presentation.create_shipping

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaelneves.anacosmeticos.internal.mock.productMock
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CreateShippingViewModel : ViewModel() {

    val screenState = MutableLiveData<CreateShippingState>(CreateShippingState.Idle)

    fun loadData() {
        viewModelScope.launch {
            delay(2000L)
            screenState.value = CreateShippingState.Loading
        }

        try {
            val response = productMock
            screenState.value = CreateShippingState.Success(response)
        } catch (error: Exception) {
            screenState.value = CreateShippingState.Error(error.message)
        }
    }
}
