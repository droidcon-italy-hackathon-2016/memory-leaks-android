package com.elpassion.memoryleaks.usecase.ping

import com.elpassion.memoryleaks.usecase.ping.PingView
import rx.Observable

class PingController(val pingApi: (String) -> Observable<Unit>, val pingView: PingView) {

    fun onSendPingClicked(elderId: String) {
        pingApi.invoke(elderId).subscribe(onSuccess, onError)
    }

    private val onSuccess = { unit: Unit ->
        pingView.showNotificationSendScreen()
    }

    private val onError = { t: Throwable ->
        pingView.showError()
    }
}

