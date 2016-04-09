package com.elpassion.memoryleaks.register.api.impl

import android.content.Context
import com.elpassion.memoryleaks.R
import com.google.android.gms.gcm.GoogleCloudMessaging
import com.google.android.gms.iid.InstanceID
import rx.Observable

class RegisterElderService(private val registerElderApiCall: (String, String) -> Observable<Unit>,
                           private val getContextCall: () -> Context) {

    val registerElderCall: (String) -> Observable<Unit> = { name ->
        val instanceID = InstanceID.getInstance(getContextCall())
        val token = instanceID.getToken(getContextCall().getString(R.string.gcm_defaultSenderId),
                GoogleCloudMessaging.INSTANCE_ID_SCOPE, null)
        registerElderApiCall(name, token)
    }
}
