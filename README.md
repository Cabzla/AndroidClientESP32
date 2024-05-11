# ESP32 Kotlin App

## Overview
This Kotlin app serves as a simple client to communicate with an ESP32 device over HTTP. It provides basic functionality to turn the device on and off via HTTP requests. 
However, it's important to note that HTTP communication is inherently insecure, and this app is designed for educational or testing purposes only. It should not be used in sensitive projects or environments where security is a concern.

## Related
- [ESP32 Simple Communication for Android](https://github.com/Cabzla/ESP32-Simple-Com-for-Android): Counterpart ESP32 project for this Android app.

## Prerequisites
- Android Studio
- Android device or emulator
- ESP32 device connected to the same network

## Installation
1. Clone the repository: `git clone https://github.com/your-username/esp32-kotlin-app.git`
2. Open the project in Android Studio.
3. Modify the `MainActivity.kt` file to replace the ESP32 IP address with your device's IP address.
4. Modify the `network_security_config.xml` file to include your ESP32 device's IP address.

## Usage
1. Run the app on your Android device or emulator.
2. Press the "ON" button to turn on the connected ESP32 device.
3. Press the "OFF" button to turn off the connected ESP32 device.

## Configuration
In the `MainActivity.kt` file, locate the following lines:
```kotlin
// Set onClickListeners for buttons
btnOn.setOnClickListener {
    // Execute HTTP request to turn ESP32 device on
    HttpRequestTask().execute("http://192.168.137.246/on") // Replace IP with your ESP32 IP
}

btnOff.setOnClickListener {
    // Execute HTTP request to turn ESP32 device off
    HttpRequestTask().execute("http://192.168.137.246/off") // Replace IP with your ESP32 IP
}
```
Replace `"http://192.168.137.246"` with the IP address of your ESP32 device.

In the `network_security_config.xml` file, replace:
```xml
<domain includeSubdomains="true">192.168.137.246</domain>
```
with the IP address of your ESP32 device.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
