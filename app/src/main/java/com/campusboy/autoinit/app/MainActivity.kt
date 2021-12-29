package com.campusboy.autoinit.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.campusboy.autoinit.api.AutoInitialize

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AutoInitialize.init(this)
    }
}