package com.example.currencyconverter.model

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

// Interface to define the API endpoints for currency exchange rates
interface CurrencyApi {

    /**
     * Retrieves exchange rates for a given base currency to a target currency.
     *
     * @param baseCurrency The base currency code (e.g., "USD").
     * @param targetCurrency The target currency code (e.g., "EUR").
     * @return A Response object containing the exchange rates data.
     */
    @GET("latest")
    // The suspend keyword indicates this function is designed to be called within a coroutine
    suspend fun getExchangeRates(
        @Query("base") baseCurrency: String,  // Query parameter for the base currency (e.g., "USD")
        @Query("symbols") targetCurrency: String  // Query parameter for the target currency (e.g., "EUR")
    ): Response<ExchangeRateResponse>
}
