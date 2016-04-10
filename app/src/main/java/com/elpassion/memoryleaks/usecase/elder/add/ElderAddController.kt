package com.elpassion.memoryleaks.usecase.elder.add

import rx.Observable

class ElderAddController(val addElder: (String, String, String) -> Observable<Unit>,
                         val elderAddView: ElderAddView) {

    fun onAddElderClick() {
        addElder(elderAddView.getElderId(), "b", elderAddView.getRelation()).subscribe(onSuccess, onError)
    }

    private val onSuccess: (Unit) -> Unit = {
        elderAddView.showSuccess()
    }

    private val onError: (Throwable) -> Unit = {
        elderAddView.showError()
    }
}