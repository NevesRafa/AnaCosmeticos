package com.rafaelneves.anacosmeticos.domain

import com.google.firebase.firestore.FirebaseFirestore
import com.rafaelneves.anacosmeticos.data.model.ProductDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class ProductRepository(private val database: FirebaseFirestore) {


    suspend fun getProducts(): List<ProductDetails> {
        return withContext(Dispatchers.IO) {
            val snapshot = database.collection("Product").get().await()
            snapshot.toObjects(ProductDetails::class.java)
        }
    }
}