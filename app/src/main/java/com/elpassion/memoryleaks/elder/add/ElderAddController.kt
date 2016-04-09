package com.elpassion.memoryleaks.elder.add

import rx.Observable

class ElderAddController(val elderAddCall: () -> Observable<Unit>,
                         val elderAddView: ElderAddView) {

    fun onAddElderClick() {
        elderAddCall.invoke().subscribe(onSuccess, onError)
    }

    private val onSuccess: (Unit) -> Unit = {
        elderAddView.showSuccess()
    }

    private val onError: (Throwable) -> Unit = {
        elderAddView.showError()
    }
}