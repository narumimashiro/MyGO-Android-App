package com.example.mygoapp.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

class components_button(context: Context, attrs: AttributeSet? = null) : AppCompatButton(context, attrs) {
//    init {}

    fun setText(text: String) {
        this.text = text
    }
}