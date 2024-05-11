/**
 * Author: Cabzla
 * Description: This Kotlin app serves as a client to communicate with an ESP32 device
 *              over HTTP. It provides buttons to turn the LED on and off.
 */

package com.example.androidclientesp32

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize buttons
        val btnOn = findViewById<Button>(R.id.btnOn)
        val btnOff = findViewById<Button>(R.id.btnOff)

        // Set onClickListeners for buttons
        btnOn.setOnClickListener {
            // Execute HTTP request to turn ESP32 device on
            HttpRequestTask().execute("http://192.168.137.246/on")
        }

        btnOff.setOnClickListener {
            // Execute HTTP request to turn ESP32 device off
            HttpRequestTask().execute("http://192.168.137.246/off")
        }
    }

    /**
     * Inner class responsible for executing HTTP requests asynchronously.
     */
    inner class HttpRequestTask : AsyncTask<String, Void, String>() {
        override fun doInBackground(vararg urls: String): String {
            val urlString = urls[0]
            val url = URL(urlString)
            val connection = url.openConnection() as HttpURLConnection
            try {
                val inputStream = BufferedReader(InputStreamReader(connection.inputStream))
                val response = StringBuffer()
                var inputLine = inputStream.readLine()
                while (inputLine != null) {
                    response.append(inputLine)
                    inputLine = inputStream.readLine()
                }
                inputStream.close()
                return response.toString()
            } finally {
                connection.disconnect()
            }
        }

        override fun onPostExecute(result: String?) {
            // Handle response if needed
        }
    }
}
