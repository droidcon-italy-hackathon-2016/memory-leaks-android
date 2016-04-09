package com.elpassion.memoryleaks.elder.add

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test
import rx.Observable

class ElderAddControllerTest {

    val elderAddCall: () -> Observable<Unit> = mock()
    val elderAddController = ElderAddController(elderAddCall)

    @Test
    fun shouldMakeCall() {
        elderAddController.onAddElderClick()
        verify(elderAddCall).invoke()
    }
}