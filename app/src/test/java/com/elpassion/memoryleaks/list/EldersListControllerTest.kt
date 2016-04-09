package com.elpassion.memoryleaks.list

import com.elpassion.memoryleaks.elder.list.EldersListController
import com.elpassion.memoryleaks.elder.list.EldersListView
import com.elpassion.memoryleaks.model.Elder
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Test
import rx.Observable
import rx.Observable.error
import rx.Observable.just

class EldersListControllerTest {

    val eldersListCall: () -> Observable<List<Elder>> = mock()
    val eldersListView: EldersListView = mock()
    val eldersListController = EldersListController(eldersListCall, eldersListView)

    @Test
    fun shouldCallForElders() {
        mockApiToReturn(just(emptyList()))
        eldersListController.onViewCreated()
        verify(eldersListCall).invoke()
    }

    @Test
    fun shouldDisplayElders() {
        mockApiToReturn(just(emptyList()))
        eldersListController.onViewCreated()
        verify(eldersListView).showElders(any())
    }

    @Test
    fun shouldDisplayError() {
        mockApiToReturn(error(RuntimeException()))
        eldersListController.onViewCreated()
        verify(eldersListView).showError()
    }

    private fun mockApiToReturn(observable: Observable<List<Elder>>) {
        whenever(eldersListCall.invoke()).thenReturn(observable)
    }
}
