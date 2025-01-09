# Currency Converter App

## Overview

The Currency Converter App allows users to convert between different currencies by fetching live exchange rates from the [ExchangeRate API](https://app.exchangerate-api.com/). It provides a simple and user-friendly interface where users can input an amount, select a source currency and a target currency, and view the converted amount.

The app is built using Kotlin for Android and follows the **Model-View-Controller (MVC)** architecture, which helps in maintaining a clean separation of concerns. The app integrates with the ExchangeRate API to fetch real-time conversion rates, and it includes error handling for network failures, invalid inputs, and empty responses from the server.

## Features

- Input an amount to convert.
- Select the source and target currencies using drop-down menus.
- Displays the converted amount using real-time exchange rates.
- Error handling for invalid inputs and network issues.
- Basic unit tests for core functionality.

## Installation
1. Clone the repository

To get started, clone this repository to your local machine:

git clone https://github.com/yourusername/currency-converter.git 
cd currency-converter

2. Open the project in Android Studio

Open Android Studio.
Select Open an Existing Project and navigate to the cloned repository directory.
Android Studio will automatically detect the project structure and sync the necessary dependencies.

3. Set up your API Key

In the CurrencyConverterController class, replace the existing API key with your own from the ExchangeRate API.
private val apiKey = "YOUR_API_KEY_HERE"

4. Build the app

Press Build > Make Project in Android Studio.
The project will compile, and you will see the APK ready to run.

5. Run the app

Connect an Android device or start an emulator.
Press Run (Shift + F10) to build and install the app on your device.
Open the app and start converting currencies.
