package com.elpassion.memoryleaks

import android.app.Application
import com.elpassion.memoryleaks.common.provider.ContextProvider

class MemoryLeakApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ContextProvider.overrided = applicationContext
    }
}