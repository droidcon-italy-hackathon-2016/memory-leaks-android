package com.elpassion.memoryleaks.registervisitor

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

class RegisterVisitorControllerTest {

    private val apiCall: () -> Unit = mock()

    @Test
    fun shouldInvokeApiCall() {
        RegisterVisitorController(apiCall).onRegisterClick()
        verify(apiCall).invoke()
    }
}

class RegisterVisitorController(private val apiCall: () -> Unit) {

    fun onRegisterClick() {
        apiCall.invoke()
    }
}
