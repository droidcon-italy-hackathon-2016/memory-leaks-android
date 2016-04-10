package com.elpassion.memoryleaks.usecase.elder.list

import com.elpassion.memoryleaks.model.Elders
import rx.Observable

class EldersListController(val eldersListCall: (String) -> Observable<Elders>,
                           val eldersListView: EldersListView) {

    fun onViewResumed() {
        eldersListCall.invoke("db9f8eb6-2e40-4862-a4ef-9381b6310f5c").subscribe(onSuccess, onError)
    }

    private val onSuccess = { elders: Elders ->
        eldersListView.showElders(elders)
    }

    private val onError = { t: Throwable ->
        eldersListView.showError(t)
    }
}