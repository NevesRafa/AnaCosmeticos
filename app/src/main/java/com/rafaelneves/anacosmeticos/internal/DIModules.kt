package com.rafaelneves.anacosmeticos.internal

import com.rafaelneves.anacosmeticos.presentation.create_shipping.CreateShippingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { CreateShippingViewModel() }

}