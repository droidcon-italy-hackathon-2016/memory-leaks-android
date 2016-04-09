package com.elpassion.memoryleaks.register.elder

import com.elpassion.memoryleaks.register.visitor.view.RegisterElderView
import rx.Observable

class RegisterElderController(
        private val apiCall: (name: String, token: String) -> Observable<Unit>,
        private val view: RegisterElderView) {

    fun onRegisterClick() {
        val name = view.getUserData()
        apiCall.invoke(name, "token").subscribe(onSuccess, onError)
    }

    val onSuccess = { unit: Unit ->
        view.showConfirmationScreen()
    }

    val onError = { ex: Throwable ->
        view.showError()
    }
}
