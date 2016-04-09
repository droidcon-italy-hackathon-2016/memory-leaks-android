package com.elpassion.memoryleaks.ping.view.impl;

import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.elpassion.memoryleaks.R
import com.elpassion.memoryleaks.model.Elder
import com.elpassion.memoryleaks.ping.PingController
import com.elpassion.memoryleaks.ping.api.impl.PingApi
import com.elpassion.memoryleaks.ping.view.PingView
import kotlinx.android.synthetic.main.ping_activity.*

class EldersListActivity : AppCompatActivity(), PingView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.elders_list_activity)
        elders_list.layoutManager = LinearLayoutManager(this)
        elders_list.adapter = EldersListAdapter(listOf(Elder()), onElderClickListener)
    }

    private val onElderClickListener: (String) -> Unit = {
        PingController(PingApi.getPingApiCall(), this).onSendPingClicked(it)
    }

    override fun showNotificationSendScreen() {
        elders_list_coordinator.showSnackBar(R.string.ping_was_send)
    }

    override fun showFailureScreen() {
        elders_list_coordinator.showSnackBar(R.string.error_occurred)
    }

    fun CoordinatorLayout.showSnackBar(@StringRes message: Int) {
        Snackbar.make(this, message, Snackbar.LENGTH_INDEFINITE).show()
    }
}
