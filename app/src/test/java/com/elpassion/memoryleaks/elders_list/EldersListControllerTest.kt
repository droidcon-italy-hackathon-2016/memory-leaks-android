package com.elpassion.memoryleaks.elders_list

import com.elpassion.memoryleaks.model.Elder
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test
import rx.Observable

class EldersListControllerTest {

    val eldersListCall: () -> Observable<List<Elder>> = mock()
    val eldersListController = EldersListController(eldersListCall)

    @Test
    fun shouldCallForElders() {
        eldersListController.onViewCreated()

        verify(eldersListCall).invoke()
    }
}