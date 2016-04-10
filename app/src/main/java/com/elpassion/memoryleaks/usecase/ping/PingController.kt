package com.elpassion.memoryleaks.usecase.ping

import rx.Observable

class PingController(val pingApi: (String, String) -> Observable<Unit>, val pingView: PingView) {

    fun onSendPingClicked(elderId: String, visitorId: String) {
        pingApi.invoke(elderId, visitorId).subscribe(onSuccess, onError)
    }

    private val onSuccess = { unit: Unit ->
        pingView.showNotificationSendScreen()
    }

    private val onError = { t: Throwable ->
        pingView.showError(t)
    }
}

