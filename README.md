# Currency Converter App

## Overview

The Currency Converter App allows users to convert between different currencies by fetching live exchange rates from the ExchangeRate API. It provides a simple and user-friendly interface where users can input an amount, select a source currency and a target currency, and view the converted amount.

The app is built using Kotlin for Android and follows the Model-View-Controller (MVC) architecture, which helps in maintaining a clean separation of concerns. The app integrates with the ExchangeRate API to fetch real-time conversion rates, and it includes error handling for network failures, invalid inputs, and empty responses from the server.

## Features

- Input an amount to convert.

- Select the source and target currencies using drop-down menus.

- Displays the converted amount using real-time exchange rates.

- Error handling for invalid inputs and network issues.

## Steps to Build and Run

1. Clone the repository

To get started, clone this repository to your local machine:

```bash
git clone https://github.com/BAnK1001/TymeX.git
cd TymeX
cd CurrencyConverter
```
2. Open the project in Android Studio

- Open Android Studio.

- Select Open an Existing Project and navigate to the cloned repository directory.

- Android Studio will automatically detect the project structure and sync the necessary dependencies.

3. Set up your API Key

- In the CurrencyConverterController class, replace the existing API key with your own from the ExchangeRate API.

```kotlin
private val apiKey = "YOUR_API_KEY_HERE"
```
4. Build the app

- Press Build > Make Project in Android Studio.

- The project will compile, and you will see the APK ready to run.

5. Run the app

- Connect an Android device or start an emulator.

- Press Run (Shift + F10) to build and install the app on your device.

- Open the app and start converting currencies.

## Challenges Encountered

- First Time Working with Kotlin: This is my first time working with Kotlin, as my previous experience was with **Flutter** and **JS**. Learning Kotlin syntax and its Android-specific features required some time to get used to. I had to familiarize myself with concepts like **Coroutines**, **ViewBinding**, and **extension functions** to build a smooth and efficient application. The transition was challenging, but rewarding, as I got to better understand Kotlin’s advantages in Android development.

## Additional Notes

- The app requires an active internet connection to fetch live currency conversion rates.

- The UI design is responsive and should work well on different screen sizes.

## Future Improvements

- Add support for more currencies: Currently, only a limited number of currencies are supported. Future versions could include more currencies and the ability to fetch a full list dynamically from the API.

- User authentication: Implement user authentication to store and manage favorite currencies and recent conversions.

- Localization: Add localization support for multiple languages and currency formats."
