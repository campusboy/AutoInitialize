package com.campusboy.autoinit.initializer

import android.content.Context
import android.widget.Toast
import com.campusboy.autoinit.interfaces.IAutoInitializer

class AppInitializer : IAutoInitializer {
    override fun initialize(context: Context) {
        Toast.makeText(context, "调用 AppInitializer", Toast.LENGTH_LONG).show()
    }
}