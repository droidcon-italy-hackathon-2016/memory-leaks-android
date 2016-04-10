package com.elpassion.memoryleaks.register.api.impl

import android.content.Context
import com.elpassion.memoryleaks.R
import com.elpassion.memoryleaks.common.provider.ContextProvider
import com.elpassion.memoryleaks.model.User
import com.google.android.gms.gcm.GoogleCloudMessaging
import com.google.android.gms.iid.InstanceID
import rx.Observable
import rx.Subscriber

class RegisterElderService(private val registerElderApiCall: (String, String) -> Observable<User>,
                           private val getContext: () -> Context) {

    val registerElderCall: (String) -> Observable<User> = { name ->
        createRequestTokenObservable()
                .flatMap { token -> registerElderApiCall(name, token) }

    }

    private fun createRequestTokenObservable() = Observable.create<String> { requestToken(it) }

    private fun requestToken(subscriber: Subscriber<in String>) {
        try {
            val instanceID = InstanceID.getInstance(getContext())
            val token = instanceID.getToken(getContext().getString(R.string.gcm_defaultSenderId),
                    GoogleCloudMessaging.INSTANCE_ID_SCOPE, null)
            subscriber.onNext(token)
            subscriber.onCompleted()
        } catch(e: Exception) {
            subscriber.onError(e)
        }
    }

    companion object {
        fun getRegisterElderCall(): (String) -> Observable<User> {
            return RegisterElderService(RegisterApi.getRegisterElderApiCall(), ContextProvider.get).registerElderCall
        }
    }
}
