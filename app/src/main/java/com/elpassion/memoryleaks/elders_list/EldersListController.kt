package com.elpassion.memoryleaks.elders_list

import com.elpassion.memoryleaks.model.Elder
import rx.Observable

class EldersListController(val eldersListCall: () -> Observable<List<Elder>>) {

    fun onViewCreated() {
        eldersListCall.invoke()
    }
}