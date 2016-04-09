package com.elpassion.memoryleaks.ping

class PingController(val pingApi: PingApi, val pingView: PingView) {

    fun onSendPingClicked() {
        pingApi.call().subscribe(onSuccess, onError)
    }

    private val onSuccess = { unit: Unit ->
        pingView.showNotificationSendScreen()
    }

    private val onError = { t: Throwable ->
        pingView.showFailureScreen()
    }
}

