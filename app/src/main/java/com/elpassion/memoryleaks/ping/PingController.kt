package com.elpassion.memoryleaks.ping

import rx.Observable

class PingController(val pingApi: () -> Observable<Unit>, val pingView: PingView) {

    fun onSendPingClicked() {
        pingApi.invoke().subscribe(onSuccess, onError)
    }

    private val onSuccess = { unit: Unit ->
        pingView.showNotificationSendScreen()
    }

    private val onError = { t: Throwable ->
        pingView.showFailureScreen()
    }
}

