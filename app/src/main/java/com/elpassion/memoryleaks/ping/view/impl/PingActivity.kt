package com.elpassion.memoryleaks.ping.view.impl;

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View.GONE
import android.view.View.VISIBLE
import com.elpassion.memoryleaks.R
import com.elpassion.memoryleaks.ping.PingController
import com.elpassion.memoryleaks.ping.view.PingView
import rx.Observable

class PingActivity : AppCompatActivity(), PingView {

    val pingCall = { Observable.just(Unit) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ping_activity)
        findViewById(R.id.send_ping)!!.setOnClickListener {
            PingController(pingCall, this).onSendPingClicked()
        }
    }

    override fun showNotificationSendScreen() {
        findViewById(R.id.send_ping)!!.visibility = GONE
        findViewById(R.id.ping_sent_screen)!!.visibility = VISIBLE
        findViewById(R.id.error_occurred)!!.visibility = GONE
    }

    override fun showFailureScreen() {
        findViewById(R.id.send_ping)!!.visibility = GONE
        findViewById(R.id.ping_sent_screen)!!.visibility = GONE
        findViewById(R.id.error_occurred)!!.visibility = VISIBLE
    }
}
