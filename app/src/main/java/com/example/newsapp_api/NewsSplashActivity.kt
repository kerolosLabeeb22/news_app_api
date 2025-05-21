package com.example.newsapp_api

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsapp_api.ui.theme.NewsAppapiTheme
import com.example.newsapp_api.ui.theme.black


class NewsSplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsAppapiTheme {
                SplashScreenContent()
                LaunchedEffect(Unit) {
                    Handler(Looper.getMainLooper()).postDelayed({
                        val intent= Intent(this@NewsSplashActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    },2500)
                }
            }
        }
    }
}

@Composable
fun SplashScreenContent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(color = black)
            .fillMaxSize()
            .navigationBarsPadding(), contentAlignment = Alignment.Center
    ) {

        Image(
            painterResource(id = R.drawable.news_app_logo),
            contentDescription = "news app logo",
            modifier = Modifier.fillMaxHeight(0.25F),
            contentScale = ContentScale.Crop

        )

        Image(
            painterResource(id = R.drawable.news_app_signature),
            contentScale = ContentScale.Crop,
            contentDescription = "news app signature ",
            modifier = modifier
                .fillMaxWidth(0.4F)
                .align(Alignment.BottomCenter)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun SplashScreenContentPrev() {
    SplashScreenContent()
}


//Box(
//modifier = modifier
//.background(color = black)
//.fillMaxSize()
//.navigationBarsPadding(), contentAlignment = Alignment.Center
//) {
//
//    Image(
//        painterResource(id = R.drawable.news_app_logo),
//        contentDescription = "app logo",
//        modifier = modifier.fillMaxHeight(0.25F),
//        contentScale = ContentScale.Crop
//    )
//
//    Image(
//        painterResource(id = R.drawable.news_app_signature),
//        contentDescription = "signature of app",
//        contentScale = ContentScale.Crop,
//        modifier = modifier
//            .fillMaxWidth(0.4F)
//            .align(Alignment.BottomCenter)
//    )
//
//}