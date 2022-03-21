package com.example.preferencesexample

import android.Manifest
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat


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

    @RequiresApi(Build.VERSION_CODES.M)
    fun clickMe(view : View){
//        var usernameBox = findViewById<EditText>(R.id.editTextTextPersonName)
//        val username : String = usernameBox.text.toString()
//
//        val editor : SharedPreferences.Editor = prefs.edit()
//
//        editor.putString("username",username)
//        editor.commit()
//        //editor.apply()
//
//        //Starting Main Activity
//        //Explicit Intent - Steps
//
//        //1- Object of Intent
//        val intent : Intent = Intent(this, userScreen::class.java)
//
//        intent.putExtra("username","Abdul Waheed")
//        //intent.putExtra("id",)
//
//        //2- start activity
//        startActivity(intent)

        //=================================

        //code to check if permission granted
        if(ContextCompat.checkSelfPermission(
                this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
            //Do Something
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
        else{
            requestPermissions(
                arrayOf(Manifest.permission.CAMERA),
                123
            )
        }

        //camera starting on this button click
        //steps..
        //1 object of inent
        //var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        //2 start
        //startActivity(intent)
    }
}