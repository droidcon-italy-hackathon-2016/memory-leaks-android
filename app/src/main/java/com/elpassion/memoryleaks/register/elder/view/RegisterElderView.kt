package com.elpassion.memoryleaks.register.visitor.view

interface RegisterElderView {

    fun showConfirmationScreen()

    fun showError()

    fun getUserData(): String
}
