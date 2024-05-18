package com.example.mygoapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mygoapp.view.components_button

class TopPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_top_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val menuList = findViewById<LinearLayout>(R.id.menu_list)
        val menuTitle = listOf("MyGO!!!!!公式ページ")

        menuTitle.forEach { title ->
            val button = components_button(this).apply {
                setText(title)
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                setOnClickListener {
                    openWebPage("https://bang-dream.bushimo.jp/mygo/")
                }
            }
            menuList.addView(button)
        }
    }

    private fun openWebPage(url: String) {
        val webview: WebView = findViewById(R.id.webview)
        with(webview.settings) {
            javaScriptEnabled = true

            useWideViewPort = true
            loadWithOverviewMode = true
        }
        webview.visibility = View.VISIBLE
        webview.loadUrl(url)
    }
}