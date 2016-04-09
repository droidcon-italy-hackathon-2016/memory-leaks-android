package com.elpassion.memoryleaks.registervisitor

import rx.Observable

class RegisterVisitorController(
        private val apiCall: () -> Observable<Unit>,
        private val view: RegisterVisitorView) {

    fun onRegisterClick() {
        apiCall.invoke().subscribe(onSuccess, onError)
    }

    val onSuccess = { unit: Unit ->
        view.showConfirmationScreen()
    }

    val onError = { ex: Throwable ->
        view.showError()
    }
}
