package com.example.preferencesexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class userScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_screen)

        var intent = getIntent()

        var label = findViewById<TextView>(R.id.textView)
        label.text = intent.getStringExtra("username")

    }
}