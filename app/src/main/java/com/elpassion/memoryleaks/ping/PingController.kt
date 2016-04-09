package com.elpassion.memoryleaks.ping

class PingController(val pingView: PingView) {

    fun onSendPingClicked() {
        pingView.showNotificationSendScreen()
    }
}
