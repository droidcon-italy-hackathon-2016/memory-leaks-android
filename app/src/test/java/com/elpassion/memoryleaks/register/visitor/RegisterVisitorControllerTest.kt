package com.elpassion.memoryleaks.register.visitor

import com.elpassion.memoryleaks.model.User
import com.elpassion.memoryleaks.register.visitor.view.RegisterVisitorView
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Test
import rx.Observable
import rx.Observable.error
import rx.Observable.just

class RegisterVisitorControllerTest {

    private val apiCall: (name: String) -> Observable<User> = mock()
    private val view: RegisterVisitorView = mock()
    private val controller = RegisterVisitorController(apiCall, view)

    @Test
    fun shouldInvokeApiCall() {
        whenever(apiCall.invoke(any())).thenReturn(just(User("")))
        whenever(view.getUserData()).thenReturn("Maciej G.")
        controller.onRegisterClick()
        verify(apiCall).invoke("Maciej G.")
    }

    @Test
    fun shouldShowConfirmationScreen() {
        whenever(apiCall.invoke(any())).thenReturn(just(User("")))
        controller.onRegisterClick()
        verify(view).showConfirmationScreen()
    }

    @Test
    fun shouldShowError() {
        whenever(apiCall.invoke(any())).thenReturn(error(RuntimeException()))
        controller.onRegisterClick()
        verify(view).showError()
    }
}
