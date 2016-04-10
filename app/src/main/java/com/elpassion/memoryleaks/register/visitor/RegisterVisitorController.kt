package com.elpassion.memoryleaks.register.visitor

import com.elpassion.memoryleaks.model.User
import com.elpassion.memoryleaks.register.visitor.view.RegisterVisitorView
import rx.Observable

class RegisterVisitorController(
        private val registerVisitor: (name: String) -> Observable<User>,
        private val view: RegisterVisitorView) {

    fun onRegisterClick() {
        val name = view.getUserData()
        registerVisitor(name).subscribe(onSuccess, onError)
    }

    val onSuccess = { unit: User ->
        view.showConfirmationScreen()
    }

    val onError = { ex: Throwable ->
        view.showError()
    }
}
