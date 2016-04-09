package com.elpassion.memoryleaks.registervisitor

import rx.Observable

class RegisterVisitorController(
        private val apiCall: (name: String) -> Observable<Unit>,
        private val view: RegisterVisitorView) {

    fun onRegisterClick() {
        val name = view.getUserData()
        apiCall.invoke(name).subscribe(onSuccess, onError)
    }

    val onSuccess = { unit: Unit ->
        view.showConfirmationScreen()
    }

    val onError = { ex: Throwable ->
        view.showError()
    }
}
