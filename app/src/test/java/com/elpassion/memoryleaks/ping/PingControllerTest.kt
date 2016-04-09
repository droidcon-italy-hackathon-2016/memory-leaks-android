package com.elpassion.memoryleaks.ping

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

class PingControllerTest {

    val pingView: PingView = mock()

    @Test
    fun shouldShowNotificationSendScreen() {
        PingController(pingView).onSendPingClicked()

        verify(pingView).showNotificationSendScreen()
    }
}