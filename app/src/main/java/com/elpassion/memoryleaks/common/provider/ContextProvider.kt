package com.elpassion.memoryleaks.common.provider

import android.content.Context

object ContextProvider {

    var overrided: Context? = null

    private val instance: Context by lazy { throw RuntimeException("Context not set") }

    val get: () -> Context = {
        overrided ?: instance
    }
}