package com.rafaelneves.anacosmeticos.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rafaelneves.anacosmeticos.databinding.ActivityHomeScreenBinding
import com.rafaelneves.anacosmeticos.presentation.create_shipping.CreateShippingActivity

class HomeScreenActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabLogin.setOnClickListener {
            val intent = Intent(this, CreateShippingActivity::class.java)
            startActivity(intent)
        }
    }
}