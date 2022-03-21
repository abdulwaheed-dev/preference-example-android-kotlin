package com.example.preferencesexample

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var prefs : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefs = getSharedPreferences("userprefs", MODE_PRIVATE)

        var label = findViewById<TextView>(R.id.text)

        var btnSubmit = findViewById<Button>(R.id.button)

        val str = prefs.getString("username","Guest")
        label.text = "Hello, "+str

    }

    fun clickMe(view : View){
        var usernameBox = findViewById<EditText>(R.id.editTextTextPersonName)
        val username : String = usernameBox.text.toString()

        val editor : SharedPreferences.Editor = prefs.edit()

        editor.putString("username",username)
        editor.commit()
    }
}