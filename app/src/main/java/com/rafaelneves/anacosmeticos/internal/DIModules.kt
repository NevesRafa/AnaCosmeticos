package com.rafaelneves.anacosmeticos.internal

import com.google.firebase.firestore.FirebaseFirestore
import com.rafaelneves.anacosmeticos.domain.ProductRepository
import com.rafaelneves.anacosmeticos.presentation.create_shipping.CreateShippingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { FirebaseFirestore.getInstance() }

    single { ProductRepository(get()) }

    viewModel { CreateShippingViewModel(get()) }

}