package com.rafaelneves.anacosmeticos.presentation.create_shipping

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointForward
import com.google.android.material.datepicker.MaterialDatePicker
import com.rafaelneves.anacosmeticos.R
import com.rafaelneves.anacosmeticos.data.model.ProductDetails
import com.rafaelneves.anacosmeticos.databinding.ActivityRegistrationShippingBinding
import com.rafaelneves.anacosmeticos.internal.extension.FormatterDateExt
import org.koin.android.ext.android.inject

class CreateShippingActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegistrationShippingBinding
    lateinit var adapter: CreateShippingAdapter
    private val viewModel: CreateShippingViewModel by inject()

    private var initialDate = MaterialDatePicker.todayInUtcMilliseconds()
    private val initialDateInDate = FormatterDateExt.formatMilliToDate(initialDate)
    private var standardTime: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationShippingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupLiveData()
        setupList()
        showDatePicker()

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

    private fun onSuccess(result: List<ProductDetails>) {
        adapter.update(result)
    }

    private fun setupList() {

        binding.recyclerViewItems.layoutManager = LinearLayoutManager(this)

        adapter = CreateShippingAdapter()

        binding.recyclerViewItems.adapter = adapter
    }

    private fun showDatePicker() {

        binding.date.setText(initialDateInDate, TextView.BufferType.EDITABLE)

        binding.date.setOnClickListener {
            if (standardTime != null) {
                val date = FormatterDateExt.stringToDate(standardTime!!, "dd/MM/yyyy")

                if (date != null) {
                    initialDate = date.time
                }
            }

            val calendarLimit = CalendarConstraints.Builder()
                .setStart(MaterialDatePicker.todayInUtcMilliseconds())
                .setValidator(DateValidatorPointForward.now())
                .build()

            val calendar = MaterialDatePicker.Builder
                .datePicker()
                .setTitleText(R.string.selecione_data_envio)
                .setSelection(initialDate)
                .setCalendarConstraints(calendarLimit)
                .build()

            calendar.addOnPositiveButtonClickListener {
                standardTime = FormatterDateExt.formatMilliToDate(it)
                binding.date.setText(standardTime, TextView.BufferType.EDITABLE)
            }
            calendar.show(supportFragmentManager, null)
        }
    }
}