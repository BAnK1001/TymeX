package com.example.currencyconverter.controller

import android.content.Context
import com.example.currencyconverter.utils.NetworkUtils
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

// Controller class to handle currency conversion logic and API interaction
class CurrencyConverterController(private val context: Context) {

    // OkHttp client for making HTTP requests
    private val client = OkHttpClient()

    // API key for ExchangeRate API (You should store this securely in production, not hardcode it)
    private val apiKey = "35d3100af89e21ebbedc3605"

    // Base URL for the ExchangeRate API to get exchange rates
    private val baseUrl = "https://v6.exchangerate-api.com/v6/$apiKey/latest/"

    /**
     * Converts a given amount from one currency to another by fetching live exchange rates.
     *
     * @param amount The amount to be converted.
     * @param fromCurrency The source currency code (e.g., "USD").
     * @param toCurrency The target currency code (e.g., "EUR").
     * @param onSuccess Callback for successful conversion, returns the converted amount.
     * @param onError Callback for handling errors, returns an error message.
     */
    fun convertCurrency(
        amount: Double,
        fromCurrency: String,
        toCurrency: String,
        onSuccess: (Double) -> Unit,
        onError: (String) -> Unit
    ) {
        // Check for internet connectivity before making the API request
        if (!NetworkUtils.isNetworkAvailable(context)) {
            onError("No internet connection. Please check your network.")
            return
        }

        // Build the URL for the API request using the source currency
        val url = "$baseUrl$fromCurrency"

        // Create an HTTP GET request
        val request = Request.Builder().url(url).build()

        // Execute the API request asynchronously
        client.newCall(request).enqueue(object : Callback {
            // Handle network failure (e.g., no response or timeout)
            override fun onFailure(call: Call, e: IOException) {
                onError("Unable to connect to the server. Please try again.")
            }

            // Handle the server's response
            override fun onResponse(call: Call, response: Response) {
                response.use { res ->
                    if (!res.isSuccessful) {
                        // If the response is unsuccessful, return an error message
                        onError("Server error: $res")
                        return
                    }

                    // Safely read the response body as a string
                    val responseBody = res.peekBody(Long.MAX_VALUE).string()
                    if (responseBody.isNotEmpty()) {
                        try {
                            // Parse the JSON response to extract the conversion rates
                            val jsonObject = JSONObject(responseBody)
                            val rates = jsonObject.getJSONObject("conversion_rates")

                            // Retrieve the exchange rate for the target currency
                            val rate = rates.getDouble(toCurrency)

                            // Calculate the converted amount
                            val convertedAmount = amount * rate
                            onSuccess(convertedAmount)
                        } catch (e: Exception) {
                            // If there's an error parsing the JSON, return an error message
                            onError("Invalid response data: ${e.message}")
                        }
                    } else {
                        // Handle the case when the response body is empty
                        onError("Empty response from the server.")
                    }
                }
            }
        })
    }
}
