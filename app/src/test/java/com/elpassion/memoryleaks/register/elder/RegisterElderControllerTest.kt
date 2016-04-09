package com.elpassion.memoryleaks.register.elder

import com.elpassion.memoryleaks.register.visitor.view.RegisterElderView
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Test
import rx.Observable
import rx.Observable.error
import rx.Observable.just

class RegisterElderControllerTest {

    private val apiCall: (name: String, token: String) -> Observable<Unit> = mock()
    private val view: RegisterElderView = mock()
    private val controller = RegisterElderController(apiCall, view)

    @Test
    fun shouldInvokeApiCall() {
        whenever(apiCall.invoke(any(), any())).thenReturn(just(Unit))
        whenever(view.getUserData()).thenReturn("Maciej T.")
        controller.onRegisterClick()
        verify(apiCall).invoke("Maciej T.", any())
    }

    @Test
    fun shouldShowConfirmationScreen() {
        whenever(apiCall.invoke(any(), any())).thenReturn(just(Unit))
        controller.onRegisterClick()
        verify(view).showConfirmationScreen()
    }

    @Test
    fun shouldShowError() {
        whenever(apiCall.invoke(any(), any())).thenReturn(error(RuntimeException()))
        controller.onRegisterClick()
        verify(view).showError()
    }
}
