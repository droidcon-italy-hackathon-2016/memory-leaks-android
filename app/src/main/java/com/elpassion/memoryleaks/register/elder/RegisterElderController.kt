package com.elpassion.memoryleaks.register.elder

import com.elpassion.memoryleaks.model.User
import com.elpassion.memoryleaks.register.elder.view.RegisterElderView
import rx.Observable

class RegisterElderController(
        private val registerElder: (name: String) -> Observable<User>,
        private val view: RegisterElderView) {

    fun onRegisterClick() {
        val name = view.getUserData()
        registerElder(name).subscribe(onSuccess, onError)
    }

    val onSuccess = { unit: User ->
        view.showConfirmationScreen()
    }

    val onError = { ex: Throwable ->
        view.showError()
    }
}
