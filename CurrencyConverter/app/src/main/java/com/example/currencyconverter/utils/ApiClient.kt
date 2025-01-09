package com.example.currencyconverter.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Singleton object to provide a Retrofit instance for API communication
object ApiClient {
    // The base URL of the API we are communicating with
    private const val BASE_URL = "https://api.exchangerate.host/"

    // Creating a Retrofit instance to interact with the API
    val retrofit: Retrofit = Retrofit.Builder()
        // Setting the base URL for the API
        .baseUrl(BASE_URL)
        // Adding Gson converter to handle JSON parsing
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
