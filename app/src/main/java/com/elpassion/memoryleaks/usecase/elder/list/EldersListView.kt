package com.elpassion.memoryleaks.usecase.elder.list

import com.elpassion.memoryleaks.model.Elders

interface EldersListView {

    fun showElders(elders: Elders)

    fun showError(t: Throwable)
}