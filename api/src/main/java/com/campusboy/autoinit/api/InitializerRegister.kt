package com.campusboy.autoinit.api

import com.campusboy.autoinit.interfaces.IAutoInitializer


object InitializerRegister {

    @JvmStatic
    private val initializers = ArrayList<IAutoInitializer>()

    @JvmStatic
    fun register(initializer: IAutoInitializer) {
        initializers.add(initializer)
    }

    @JvmStatic
    fun getInitializers(): Iterator<IAutoInitializer> {
        return initializers.iterator()
    }
}