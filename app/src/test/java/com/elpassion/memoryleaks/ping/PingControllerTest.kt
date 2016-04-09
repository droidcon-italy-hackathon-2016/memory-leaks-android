package com.elpassion.memoryleaks.ping

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Test
import rx.Observable.error
import rx.Observable.just

class PingControllerTest {

    val pingView: PingView = mock()
    val pingApi: PingApi = mock()

    @Test
    fun shouldShowNotificationSendScreen() {
        whenever(pingApi.call()).thenReturn(just(Unit))

        PingController(pingApi, pingView).onSendPingClicked()

        verify(pingView).showNotificationSendScreen()
    }

    @Test
    fun shouldSendPingCall() {
        whenever(pingApi.call()).thenReturn(just(Unit))

        PingController(pingApi, pingView).onSendPingClicked()

        verify(pingApi).call()
    }

    @Test
    fun shouldShowErrorWhenApiCallFails() {
        whenever(pingApi.call()).thenReturn(error(RuntimeException()))

        PingController(pingApi, pingView).onSendPingClicked()

        verify(pingView).showFailureScreen()
    }
}