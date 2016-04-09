package com.elpassion.memoryleaks.register.visitor.view

interface  RegisterVisitorView {

    fun showConfirmationScreen()

    fun showError()

    fun getUserData(): String
}
