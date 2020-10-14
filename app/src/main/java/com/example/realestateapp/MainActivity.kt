package com.example.realestateapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchJson()
    }

    fun fetchJson(){
        val url = "https://api.domain.com.au/v1/agencies/22473"
        val KEY = "key_cf03eaeb84f542e0d306b52a6d11eb75"

        val clientid = "client_16a3c2753262662d4e7dc23253eb3ef2"
        val secretid = "secret_3c67b9f4913a162cda453c65acfceca5"

        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        println(request)
        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                val body = response?.body?.string()
                println(body)
            }
        })

    }
}