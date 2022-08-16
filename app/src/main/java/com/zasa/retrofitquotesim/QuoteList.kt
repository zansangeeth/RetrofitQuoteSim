package com.zasa.retrofitquotesim

/**
 **@Project -> RetrofitQuoteSim
 **@Author -> Sangeeth on 8/15/2022
 */
data class QuoteList(
    val count : Int,
    val totalCount : Int,
    val page : Int,
    val totalPages : Int,
    val lastItemIndex : Int,
    val results : List<Result>
)
