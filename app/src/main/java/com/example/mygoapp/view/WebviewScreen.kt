package com.example.mygoapp.view

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.mygoapp.R

class WebviewScreen: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        val webView: WebView = findViewById(R.id.webviewScreen)
        with(webView.settings) {
            javaScriptEnabled = true

            useWideViewPort = true
            loadWithOverviewMode = true
        }
        webView.webViewClient = WebViewClient()
        val url = intent.getStringExtra("url")
        webView.loadUrl(url ?: "https://bang-dream.bushimo.jp/mygo/")
    }
}