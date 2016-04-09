package com.elpassion.memoryleaks.register.api.impl

import android.content.Context
import com.elpassion.memoryleaks.R
import com.elpassion.memoryleaks.common.provider.ContextProvider
import com.google.android.gms.gcm.GoogleCloudMessaging
import com.google.android.gms.iid.InstanceID
import rx.Observable

class RegisterElderService(private val registerElderApiCall: (String, String) -> Observable<Unit>,
                           private val getContext: () -> Context) {

    val registerElderCall: (String) -> Observable<Unit> = { name ->
        val instanceID = InstanceID.getInstance(getContext())
        val token = instanceID.getToken(getContext().getString(R.string.gcm_defaultSenderId),
                GoogleCloudMessaging.INSTANCE_ID_SCOPE, null)
        registerElderApiCall(name, token)
    }

    companion object {
        fun getRegisterElderCall(): (String) -> Observable<Unit> {
            return RegisterElderService(RegisterApi.getRegisterElderApiCall(), ContextProvider.get).registerElderCall
        }
    }
}
