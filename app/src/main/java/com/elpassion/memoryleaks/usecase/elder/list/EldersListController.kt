package com.elpassion.memoryleaks.usecase.elder.list

import com.elpassion.memoryleaks.model.Elders
import rx.Observable

class EldersListController(val eldersListCall: () -> Observable<Elders>,
                           val eldersListView: EldersListView) {

    fun onViewResumed() {
        eldersListCall.invoke().subscribe(onSuccess, onError)
    }

    private val onSuccess = { elders: Elders ->
        eldersListView.showElders(elders)
    }

    private val onError = { t: Throwable ->
        eldersListView.showError(t)
    }
}