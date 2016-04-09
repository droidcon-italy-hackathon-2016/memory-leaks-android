package com.elpassion.memoryleaks.ping

import com.elpassion.memoryleaks.ping.view.PingView
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Test
import rx.Observable
import rx.Observable.error
import rx.Observable.just

class PingControllerTest {

    val pingView: PingView = mock()
    val pingApi: () -> Observable<Unit> = mock()
    val controller = PingController(pingApi, pingView)

    @Test
    fun shouldShowNotificationSendScreen() {
        mockApiToReturn(just(Unit))
        onSendPingClick()
        verify(pingView).showNotificationSendScreen()
    }

    @Test
    fun shouldSendPingCall() {
        mockApiToReturn(just(Unit))
        onSendPingClick()
        verify(pingApi).invoke()
    }

    @Test
    fun shouldShowErrorWhenApiCallFails() {
        mockApiToReturn(error(RuntimeException()))
        onSendPingClick()
        verify(pingView).showFailureScreen()
    }

    private fun mockApiToReturn(observable: Observable<Unit>) {
        whenever(pingApi.invoke()).thenReturn(observable)
    }

    private fun onSendPingClick() {
        controller.onSendPingClicked()
    }
}