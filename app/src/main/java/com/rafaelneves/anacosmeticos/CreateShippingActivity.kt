package com.rafaelneves.anacosmeticos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rafaelneves.anacosmeticos.databinding.ActivityRegistrationShippingBinding

class CreateShippingActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegistrationShippingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationShippingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}