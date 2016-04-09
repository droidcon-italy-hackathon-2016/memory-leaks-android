package com.elpassion.memoryleaks.elder.add

import rx.Observable

class ElderAddController(val elderAddCall: () -> Observable<Unit>) {
    fun onAddElderClick() {
        elderAddCall.invoke()
    }
}