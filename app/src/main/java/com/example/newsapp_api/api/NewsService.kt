package com.example.newsapp_api.api

import com.example.newsapp_api.api.model.SourcesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("top-headlines/sources")
    fun getSources(@Query("apiKey") apikey: String ="a7121b602b324625987412c439a51923") : Call<SourcesResponse>
}