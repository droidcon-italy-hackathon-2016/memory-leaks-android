package com.elpassion.memoryleaks.elder.add

import com.elpassion.memoryleaks.usecase.elder.add.ElderAddController
import com.elpassion.memoryleaks.usecase.elder.add.ElderAddView
import com.nhaarman.mockito_kotlin.*
import org.junit.Test
import rx.Observable
import rx.Observable.error
import rx.Observable.just

class ElderAddControllerTest {

    val elderAddCall: (String, String, String) -> Observable<Unit> = mock()
    val elderAddView: ElderAddView = mock()
    val visitor_id = "visitor_id"
    val elderAddController = ElderAddController(elderAddCall, elderAddView, visitor_id)

    @Test
    fun shouldMakeCall() {
        mockApiToReturn(just(Unit))
        elderAddController.onAddElderClick()
        verify(elderAddCall).invoke(any(), eq(visitor_id), any())
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
        whenever(elderAddCall.invoke(any(), any(), any())).thenReturn(observable)
    }
}