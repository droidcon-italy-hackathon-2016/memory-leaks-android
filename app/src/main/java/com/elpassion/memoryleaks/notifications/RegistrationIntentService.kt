package com.elpassion.memoryleaks.notifications

import android.app.IntentService
import android.content.Intent
import com.elpassion.memoryleaks.R
import com.google.android.gms.gcm.GoogleCloudMessaging
import com.google.android.gms.iid.InstanceID

class RegistrationIntentService : IntentService(RegistrationIntentService::class.java.simpleName) {

    override fun onHandleIntent(intent: Intent) {
        val instanceID = InstanceID.getInstance(this)
        val token = instanceID.getToken(getString(R.string.gcm_defaultSenderId),
                GoogleCloudMessaging.INSTANCE_ID_SCOPE, null)

        sendRegistrationToServer(token)
    }

    private fun sendRegistrationToServer(token: String) {
        throw UnsupportedOperationException("not implemented")
    }
}