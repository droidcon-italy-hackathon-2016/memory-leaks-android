package com.elpassion.memoryleaks.ping

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

class PingControllerTest {

    val pingView: PingView = mock()
    val pingApi: PingApi = mock()

    @Test
    fun shouldShowNotificationSendScreen() {
        PingController(pingApi, pingView).onSendPingClicked()

        verify(pingView).showNotificationSendScreen()
    }

    @Test
    fun shouldSendPingCall() {
        PingController(pingApi, pingView).onSendPingClicked()

        verify(pingApi).call()
    }
}