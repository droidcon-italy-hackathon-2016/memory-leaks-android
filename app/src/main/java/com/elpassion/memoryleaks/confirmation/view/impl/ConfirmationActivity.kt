package com.elpassion.memoryleaks.confirmation.view.impl

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.elpassion.memoryleaks.R
import com.elpassion.memoryleaks.common.android.BaseActivity
import com.elpassion.memoryleaks.ui.elder.list.EldersListActivity
import rx.Observable
import rx.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class ConfirmationActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.confirmation_activity)
        Observable.just(Unit).subscribeOn(Schedulers.newThread()).delay(3, TimeUnit.SECONDS).subscribe({
            EldersListActivity.start(this)
        })
    }

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, ConfirmationActivity::class.java)
            context.startActivity(intent)
        }
    }
}