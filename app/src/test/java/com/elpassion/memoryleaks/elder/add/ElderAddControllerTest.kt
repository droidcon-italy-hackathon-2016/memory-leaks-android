package com.elpassion.memoryleaks.elder.add

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Test
import rx.Observable
import rx.Observable.error
import rx.Observable.just

class ElderAddControllerTest {

    val elderAddCall: () -> Observable<Unit> = mock()
    val elderAddView: ElderAddView = mock()
    val elderAddController = ElderAddController(elderAddCall, elderAddView)

    @Test
    fun shouldMakeCall() {
        mockApiToReturn(just(Unit))
        elderAddController.onAddElderClick()
        verify(elderAddCall).invoke()
    }

    @Test
    fun shouldShowSuccess() {
        mockApiToReturn(just(Unit))
        elderAddController.onAddElderClick()
        verify(elderAddView).showSuccess()
    }

    @Test
    fun shouldShowError() {
        mockApiToReturn(error(RuntimeException()))
        elderAddController.onAddElderClick()
        verify(elderAddView).showError()
    }

    private fun mockApiToReturn(observable: Observable<Unit>) {
        whenever(elderAddCall.invoke()).thenReturn(observable)
    }
}