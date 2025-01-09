package com.example.currencyconverter.model

data class ExchangeRateResponse(
    val rates: Map<String, Double>,
    val base: String,
    val date: String
)