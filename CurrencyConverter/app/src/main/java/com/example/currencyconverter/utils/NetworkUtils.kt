package com.example.currencyconverter.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

// A utility object to handle network-related operations
object NetworkUtils {

    /**
     * Checks if the device has an active internet connection.
     *
     * @param context The application context, which is used to access system services.
     * @return true if the device is connected to the internet, false otherwise.
     */
    fun isNetworkAvailable(context: Context): Boolean {
        // Get the ConnectivityManager system service to access network status
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // Get the current active network. If no network is available, return false.
        val network = connectivityManager.activeNetwork ?: return false

        // Retrieve the capabilities of the active network. If unavailable, return false.
        val activeNetwork =
            connectivityManager.getNetworkCapabilities(network) ?: return false

        // Check if the active network has internet capability (i.e., can access the web)
        return activeNetwork.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}
