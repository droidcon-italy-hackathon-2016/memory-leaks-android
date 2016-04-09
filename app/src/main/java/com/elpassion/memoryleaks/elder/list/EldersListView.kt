package com.elpassion.memoryleaks.elder.list

import com.elpassion.memoryleaks.model.Elder

interface EldersListView {

    fun showElders(elders: List<Elder>)

    fun showError()
}