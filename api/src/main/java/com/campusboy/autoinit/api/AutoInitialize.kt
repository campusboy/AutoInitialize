package com.campusboy.autoinit.api

import android.content.Context

object AutoInitialize {

    @JvmStatic
    fun init(context: Context) {
        registerInitializers()
        startInit(context)
    }

    @JvmStatic
    private fun registerInitializers() {
//        InitializerRegister.register(object : IAutoInitializer {
//            override fun initialize(context: Context) {
//
//            }
//        })
    }

    @JvmStatic
    private fun startInit(context: Context) {
        InitializerRegister.getInitializers().forEach {
            it.initialize(context)
        }
    }
}