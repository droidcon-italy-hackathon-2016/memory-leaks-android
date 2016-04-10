package com.elpassion.memoryleaks.ping

import com.elpassion.memoryleaks.usecase.ping.PingView
import com.elpassion.memoryleaks.usecase.ping.PingController
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Test
import rx.Observable
import rx.Observable.error
import rx.Observable.just

class PingControllerTest {

    val pingView: PingView = mock()
    val pingCall: (String) -> Observable<Unit> = mock()
    val controller = PingController(pingCall, pingView)

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
        verify(pingCall).invoke(any())
    }

    @Test
    fun shouldShowErrorWhenApiCallFails() {
        mockApiToReturn(error(RuntimeException()))
        onSendPingClick()
        verify(pingView).showError(any())
    }

    private fun mockApiToReturn(observable: Observable<Unit>) {
        whenever(pingCall.invoke(any())).thenReturn(observable)
    }

    private fun onSendPingClick() {
        controller.onSendPingClicked("grandma-id")
    }
}