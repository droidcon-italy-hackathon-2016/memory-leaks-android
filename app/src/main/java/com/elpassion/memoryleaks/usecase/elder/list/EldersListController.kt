package com.elpassion.memoryleaks.usecase.elder.list

import com.elpassion.memoryleaks.model.Elder
import rx.Observable

class EldersListController(val eldersListCall: () -> Observable<List<Elder>>,
                           val eldersListView: EldersListView) {

    fun onViewCreated() {
        eldersListCall.invoke().subscribe(onSuccess, onError)
    }

    private val onSuccess = { elders: List<Elder> ->
        eldersListView.showElders(elders)
    }

    private val onError = { t: Throwable ->
        eldersListView.showError()
    }
}