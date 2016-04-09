package com.elpassion.memoryleaks.confirmation.view.impl

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.elpassion.memoryleaks.R
import com.elpassion.memoryleaks.common.android.BaseActivity

class ConfirmationActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.confirmation_activity)
    }

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, ConfirmationActivity::class.java)
            context.startActivity(intent)
        }
    }
}