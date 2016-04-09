package com.elpassion.memoryleaks.elders_list

import com.elpassion.memoryleaks.model.Elder

interface EldersListView {

    fun showElders(elders: List<Elder>)
}