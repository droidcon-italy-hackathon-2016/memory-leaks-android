package com.elpassion.memoryleaks.register.elder

import com.elpassion.memoryleaks.model.User
import com.elpassion.memoryleaks.register.elder.view.RegisterElderView
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Test
import rx.Observable
import rx.Observable.error
import rx.Observable.just

class RegisterElderControllerTest {

    private val registerElder: (name: String) -> Observable<User> = mock()
    private val view: RegisterElderView = mock()
    private val controller = RegisterElderController(registerElder, view)

    @Test
    fun shouldInvokeApiCall() {
        whenever(registerElder(any())).thenReturn(just(User("")))
        whenever(view.getUserData()).thenReturn("Maciej T.")
        controller.onRegisterClick()
        verify(registerElder).invoke("Maciej T.")
    }

    @Test
    fun shouldShowConfirmationScreen() {
        whenever(registerElder(any())).thenReturn(just(User("")))
        controller.onRegisterClick()
        verify(view).showConfirmationScreen()
    }

    @Test
    fun shouldShowError() {
        whenever(registerElder(any())).thenReturn(error(RuntimeException()))
        controller.onRegisterClick()
        verify(view).showError()
    }
}
