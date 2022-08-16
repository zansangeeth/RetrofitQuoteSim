package com.zasa.retrofitquotesim

import com.google.gson.annotations.SerializedName

/**
 **@Project -> RetrofitQuoteSim
 **@Author -> Sangeeth on 8/15/2022
 */
data class Result(
    val _id : String,
    val author : String,
    val content : String,
    val tags : List<String>,
    val authorSlug : String,
    val length : Int,
    val dateAdded : String,
    val dateModified : String
)
