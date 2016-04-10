package com.elpassion.memoryleaks.ui.elder.list;

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.elpassion.memoryleaks.R
import com.elpassion.memoryleaks.common.android.BaseActivity
import com.elpassion.memoryleaks.common.android.getVisitorId
import com.elpassion.memoryleaks.common.android.showSnackBar
import com.elpassion.memoryleaks.common.android.startIfNotPlaying
import com.elpassion.memoryleaks.model.Elders
import com.elpassion.memoryleaks.usecase.elder.list.EldersListController
import com.elpassion.memoryleaks.usecase.elder.list.EldersListView
import com.elpassion.memoryleaks.usecase.elder.list.api.EldersListApiCallProvider.getEldersListApiCall
import com.elpassion.memoryleaks.usecase.ping.PingController
import com.elpassion.memoryleaks.usecase.ping.PingView
import com.elpassion.memoryleaks.usecase.ping.api.PingApiCallProvider.getPingApiCall
import kotlinx.android.synthetic.main.elders_list_activity.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class EldersListActivity : BaseActivity(), PingView, EldersListView {

    val eldersListApiCall = { userId: String ->
        getEldersListApiCall().invoke(userId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }
    val eldersListController by lazy { EldersListController(eldersListApiCall, this, getVisitorId()) }
    val mediaPlayer by lazy { MediaPlayer.create(this, R.raw.door_bell) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.elders_list_activity)
        elders_list.layoutManager = LinearLayoutManager(this)
        add_elder.setOnClickListener({ AddElderActivity.start(this) })
    }

    override fun onResume() {
        super.onResume()
        eldersListController.onViewResumed()
    }

    private val onElderClickListener: (String) -> Unit = {
        PingController(getPingApiCall(), this).onSendPingClicked(it)
        mediaPlayer.startIfNotPlaying()
    }

    override fun showElders(elders: Elders) {
        elders_list.adapter = EldersListAdapter(elders.relatives, onElderClickListener)
    }

    override fun showNotificationSendScreen() {
        elders_list_coordinator.showSnackBar(R.string.ping_was_send)
    }

    override fun showError(t: Throwable) {
        Log.e("Error", t.toString())
        elders_list_coordinator.showSnackBar(R.string.error_occurred)
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, EldersListActivity::class.java))
        }
    }
}
