package com.example.axel.recyclertest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import android.widget.Toast
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    val url: String = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=12af1cfeedcd4858a0b01055de06f7e3"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val okhttp = OkHttpClient()
        val request = Request.Builder().url(url).build()

        okhttp.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                Toast.makeText(applicationContext, "Network error", Toast.LENGTH_SHORT).show()
                call?.cancel()
            }

            override fun onResponse(call: Call?, response: Response?) {
                val responseString = response?.body()?.string()
                val gson = GsonBuilder().create()
                val news = gson.fromJson(responseString, News::class.java)
                runOnUiThread {
                    recyclerView.adapter = CustomAdapter(news)
                }

            }

        })
    }
}
