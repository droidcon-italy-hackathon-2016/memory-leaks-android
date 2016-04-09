package com.elpassion.memoryleaks.notifications

import android.os.Bundle
import com.google.android.gms.gcm.GcmListenerService

class NotificationListenerService : GcmListenerService() {

    override fun onMessageReceived(from: String?, data: Bundle?) {
        throw NotImplementedError()
    }
}