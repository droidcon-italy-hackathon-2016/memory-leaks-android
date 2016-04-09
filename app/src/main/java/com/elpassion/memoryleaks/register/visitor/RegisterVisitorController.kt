package com.elpassion.memoryleaks.register.visitor

import com.elpassion.memoryleaks.register.visitor.view.RegisterVisitorView
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
