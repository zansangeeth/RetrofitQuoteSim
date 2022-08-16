package com.zasa.retrofitquotesim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    val BASE_URL = "https://quotable.io/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quotes = mutableListOf<Result>()
        val adapter = QuoteAdapter(this, quotes)
        rvQuotes.adapter = adapter
        rvQuotes.layoutManager = LinearLayoutManager(this)

//        val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)
//
//        GlobalScope.launch {
//            val result = quotesApi.getQuotes()
//            if (result != null){
//                Log.i(TAG, result.body().toString())
//            }
//        }

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val quotesApi = retrofit.create(QuotesApi::class.java)
            quotesApi.getQuotes().enqueue(object : Callback<QuoteList> {
                override fun onResponse(call: Call<QuoteList>, response: Response<QuoteList>) {
                    val body = response.body()
                    if (body == null) {
                        Log.i(TAG, "did not receive valid response from the Yelp API..")
                    }
                    quotes.addAll(body!!.results)
                    Log.i(TAG, "responce $body")
                    adapter.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<QuoteList>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "failed to fetch data...", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }

}