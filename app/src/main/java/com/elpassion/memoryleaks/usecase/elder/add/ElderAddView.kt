package com.elpassion.memoryleaks.usecase.elder.add

interface ElderAddView {
    fun showSuccess()

    fun showError()

    fun getRelation(): String

    fun getElderId(): String
}