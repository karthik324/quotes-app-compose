package com.example.quotesapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quotesapp.models.Quote
import com.google.gson.Gson

object DataManager {
    var data = emptyArray<Quote>()
    var isLoaded = mutableStateOf(false)
    var currPage = mutableStateOf(Pages.Listing)
    var currQuote: Quote? = null

    fun loadData(context: Context){
        val inputStream = context.assets.open("quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        isLoaded.value = data.isNotEmpty()
    }

    fun switchPage(quote: Quote?){
        if(currPage.value == Pages.Listing){
            currPage.value = Pages.Detail
            currQuote = quote
        } else {
            currPage.value = Pages.Listing
        }
    }

}

enum class Pages{
    Listing,
    Detail
}