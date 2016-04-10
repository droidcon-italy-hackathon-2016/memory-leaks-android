package com.elpassion.memoryleaks.usecase.elder.list

import com.elpassion.memoryleaks.model.Elders
import rx.Observable

class EldersListController(val eldersListCall: (String) -> Observable<Elders>,
                           val eldersListView: EldersListView,
                           val visitorId: String) {

    fun onViewResumed() {
        eldersListCall.invoke(visitorId).subscribe(onSuccess, onError)
    }

    private val onSuccess = { elders: Elders ->
        eldersListView.showElders(elders)
    }

    private val onError = { t: Throwable ->
        eldersListView.showError(t)
    }
}