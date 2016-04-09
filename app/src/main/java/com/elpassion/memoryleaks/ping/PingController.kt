package com.elpassion.memoryleaks.ping

class PingController(val pingApi: PingApi, val pingView: PingView) {

    fun onSendPingClicked() {
        pingApi.call()
        pingView.showNotificationSendScreen()
    }
}

