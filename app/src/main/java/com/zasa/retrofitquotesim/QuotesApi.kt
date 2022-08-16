package com.zasa.retrofitquotesim

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

/**
 **@Project -> RetrofitQuoteSim
 **@Author -> Sangeeth on 8/15/2022
 */
interface QuotesApi {
    @GET("/quotes")
    fun getQuotes() : Call<QuoteList>
}