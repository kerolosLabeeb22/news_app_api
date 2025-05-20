package com.example.newsapp_api

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsapp_api.ui.theme.NewsAppapiTheme
import com.example.newsapp_api.ui.theme.api.ApiManager
import com.example.newsapp_api.ui.theme.api.SourcesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsAppapiTheme {
                LaunchedEffect(Unit) {
                    ApiManager.newsService.getSources()
                        .enqueue(object : Callback<SourcesResponse>{
                            override fun onResponse(
                                call: Call<SourcesResponse?>,
                                response: Response<SourcesResponse?>
                            ) {
                                Log.e("TAG", "onResponse: ${response.body()}", )
                            }

                            override fun onFailure(
                                call: Call<SourcesResponse?>,
                                t: Throwable
                            ) {
                                Log.e("TAG", "onFailure: ${t.message}", )
                            }

                        })
                }
            }
        }
    }
}
