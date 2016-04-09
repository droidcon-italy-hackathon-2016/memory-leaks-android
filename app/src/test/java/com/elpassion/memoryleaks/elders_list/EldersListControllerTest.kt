package com.elpassion.memoryleaks.elders_list

import com.elpassion.memoryleaks.model.Elder
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Test
import rx.Observable

class EldersListControllerTest {

    val eldersListCall: () -> Observable<List<Elder>> = mock()
    val eldersListView: EldersListView = mock()
    val eldersListController = EldersListController(eldersListCall)

    @Test
    fun shouldCallForElders() {
        mockApiToReturn(Observable.just(emptyList()))
        eldersListController.onViewCreated()
        verify(eldersListCall).invoke()
    }

    @Test
    fun shouldDisplayElders() {
        mockApiToReturn(Observable.just(emptyList()))
        eldersListController.onViewCreated()
        verify(eldersListView).showElders(any())
    }

    private fun mockApiToReturn(observable: Observable<List<Elder>>) {
        whenever(eldersListCall.invoke()).thenReturn(observable)
    }
}
