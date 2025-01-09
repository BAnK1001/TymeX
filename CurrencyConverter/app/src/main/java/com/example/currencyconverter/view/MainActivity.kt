package com.example.currencyconverter.view

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.currencyconverter.controller.CurrencyConverterController
import com.example.currencyconverter.databinding.ActivityMainBinding
import com.example.currencyconverter.utils.NetworkUtils

class MainActivity : AppCompatActivity() {

    // Declare ViewBinding and Controller variables
    private lateinit var binding: ActivityMainBinding
    private lateinit var controller: CurrencyConverterController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the CurrencyConverterController
        controller = CurrencyConverterController(this)

        // Setup the Spinner for currency selection (Assuming you already have a list of currency codes)
        val currencies = listOf("USD", "EUR", "GBP", "JPY", "VND")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, currencies)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Bind the spinner adapters to the from and to currency spinners
        binding.spinnerFromCurrency.adapter = adapter
        binding.spinnerToCurrency.adapter = adapter

        // Set up the Convert button click listener
        binding.btnConvert.setOnClickListener {
            val amount = binding.etAmount.text.toString().toDoubleOrNull()
            val fromCurrency = binding.spinnerFromCurrency.selectedItem.toString()
            val toCurrency = binding.spinnerToCurrency.selectedItem.toString()

            // Validate the user input
            if (!isValidInput(amount, fromCurrency, toCurrency)) {
                return@setOnClickListener
            }

            // Check if there's an internet connection before proceeding
            if (!NetworkUtils.isNetworkAvailable(this)) {
                showError("No internet connection. Please check your connection.")
                return@setOnClickListener
            }

            // Proceed with the currency conversion
            controller.convertCurrency(amount!!, fromCurrency, toCurrency, { result ->
                // Display the conversion result
                binding.tvResult.text = "Result: $result $toCurrency"
            }, { error ->
                // Display any error that occurs
                showError(error)
            })
        }
    }

    /**
     * Validates the user's input.
     * - Checks if the amount is a valid number and greater than 0.
     * - Ensures that the selected currencies are not the same.
     */
    private fun isValidInput(amount: Double?, fromCurrency: String, toCurrency: String): Boolean {
        // Validate the amount: it must be a valid number and greater than 0
        if (amount == null || amount <= 0) {
            showError("Please enter a valid amount (greater than 0).")
            return false
        }

        // Ensure the user doesn't select the same currency for both from and to
        if (fromCurrency == toCurrency) {
            showError("The currencies for conversion cannot be the same.")
            return false
        }

        return true
    }

    /**
     * Displays an error message to the user.
     * @param message The error message to be shown.
     */
    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
