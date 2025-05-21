package com.example.newsapp_api.api.model

import com.example.newsapp_api.api.NewsService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiManager {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val newsService = retrofit.create(NewsService::class.java)

}