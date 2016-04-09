package com.elpassion.memoryleaks.registervisitor

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Test
import rx.Observable
import rx.Observable.just

class RegisterVisitorControllerTest {

    private val apiCall: () -> Observable<Unit> = mock()
    private val view: RegistrationVisitorView = mock()
    private val controller = RegisterVisitorController(apiCall, view)

    @Test
    fun shouldInvokeApiCall() {
        whenever(apiCall.invoke()).thenReturn(just(Unit))
        controller.onRegisterClick()
        verify(apiCall).invoke()
    }

    @Test
    fun shouldShowConfirmationScreen() {
        whenever(apiCall.invoke()).thenReturn(just(Unit))
        controller.onRegisterClick()
        verify(view).showConfirmationScreen()
    }
}

interface  RegistrationVisitorView {

    fun showConfirmationScreen()
}

class RegisterVisitorController(
        private val apiCall: () -> Observable<Unit>,
        private val view: RegistrationVisitorView) {

    fun onRegisterClick() {
        apiCall.invoke().subscribe {
            view.showConfirmationScreen()
        }
    }
}
