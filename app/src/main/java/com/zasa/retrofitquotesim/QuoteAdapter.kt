package com.zasa.retrofitquotesim

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 **@Project -> RetrofitQuoteSim
 **@Author -> Sangeeth on 8/15/2022
 */
class QuoteAdapter(val context : Context, private var quoteList: List<Result>) : RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_quote, parent,false)
        return QuoteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val quote = quoteList[position]
        holder.bind(quote)
    }

    override fun getItemCount() = quoteList.size

    inner class QuoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(quoteList:Result){
            itemView.findViewById<TextView>(R.id.tvAuthor).text = quoteList.author
        }

    }
}