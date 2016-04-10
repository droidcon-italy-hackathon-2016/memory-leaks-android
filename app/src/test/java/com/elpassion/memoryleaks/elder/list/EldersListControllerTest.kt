package com.elpassion.memoryleaks.elder.list

import com.elpassion.memoryleaks.model.Elders
import com.elpassion.memoryleaks.usecase.elder.list.EldersListController
import com.elpassion.memoryleaks.usecase.elder.list.EldersListView
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Test
import rx.Observable
import rx.Observable.error
import rx.Observable.just

class EldersListControllerTest {

    val eldersListCall: (String) -> Observable<Elders> = mock()
    val eldersListView: EldersListView = mock()
    val eldersListController = EldersListController(eldersListCall, eldersListView, "visitorId")

    @Test
    fun shouldCallForElders() {
        mockApiToReturn(just(Elders(emptyList())))
        eldersListController.onViewResumed()
        verify(eldersListCall).invoke(any())
    }

    @Test
    fun shouldDisplayElders() {
        mockApiToReturn(just(Elders(emptyList())))
        eldersListController.onViewResumed()
        verify(eldersListView).showElders(any())
    }

    @Test
    fun shouldDisplayError() {
        mockApiToReturn(error(RuntimeException()))
        eldersListController.onViewResumed()
        verify(eldersListView).showError(any())
    }

    private fun mockApiToReturn(observable: Observable<Elders>) {
        whenever(eldersListCall.invoke(any())).thenReturn(observable)
    }
}
