package com.elpassion.memoryleaks.notifications

import android.content.Intent
import com.google.android.gms.iid.InstanceIDListenerService

class MyInstanceIdListenerService : InstanceIDListenerService() {

    override fun onTokenRefresh() {
        startService(Intent(this, RegistrationIntentService::class.java))
    }
}