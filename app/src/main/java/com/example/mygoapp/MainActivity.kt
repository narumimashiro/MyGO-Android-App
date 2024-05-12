package com.example.mygoapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.animation.AnimationUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // enable to set fullscreen what can switch next page by tapping
        var fullScreenLayout = findViewById<ConstraintLayout>(R.id.main)
        fullScreenLayout.setOnClickListener {
            startActivity(Intent(this, TopPage::class.java))
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var tapText = findViewById<TextView>(R.id.tapText)
        var blinkAnimation = AnimationUtils.loadAnimation(this, R.anim.blink)
        tapText.startAnimation(blinkAnimation)
    }
}