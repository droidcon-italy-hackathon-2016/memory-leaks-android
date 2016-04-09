package com.elpassion.memoryleaks.ping.view.impl;

import android.media.MediaPlayer
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.elpassion.memoryleaks.R
import com.elpassion.memoryleaks.elder.list.EldersListController
import com.elpassion.memoryleaks.elder.list.EldersListView
import com.elpassion.memoryleaks.elder.list.api.impl.EldersListApi.Companion.getEldersListApiCall
import com.elpassion.memoryleaks.model.Elder
import com.elpassion.memoryleaks.ping.PingController
import com.elpassion.memoryleaks.ping.api.impl.PingApi.Companion.getPingApiCall
import com.elpassion.memoryleaks.ping.view.PingView
import kotlinx.android.synthetic.main.elders_list_activity.*

class EldersListActivity : AppCompatActivity(), PingView, EldersListView {

    val eldersListController by lazy { EldersListController(getEldersListApiCall(), this) }
    val mediaPlayer by lazy { MediaPlayer.create(this, R.raw.door_bell) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.elders_list_activity)
        elders_list.layoutManager = LinearLayoutManager(this)
        eldersListController.onViewCreated()
    }

    private val onElderClickListener: (String) -> Unit = {
        PingController(getPingApiCall(), this).onSendPingClicked(it)
        mediaPlayer.startIfNotPlaying()
    }

    override fun showElders(elders: List<Elder>) {
        elders_list.adapter = EldersListAdapter(elders, onElderClickListener)
    }

    override fun showNotificationSendScreen() {
        elders_list_coordinator.showSnackBar(R.string.ping_was_send)
    }

    override fun showError() {
        elders_list_coordinator.showSnackBar(R.string.error_occurred)
    }

    fun CoordinatorLayout.showSnackBar(@StringRes message: Int) {
        Snackbar.make(this, message, Snackbar.LENGTH_INDEFINITE).show()
    }

    fun MediaPlayer.startIfNotPlaying() {
        if (!isPlaying) start()
    }
}
