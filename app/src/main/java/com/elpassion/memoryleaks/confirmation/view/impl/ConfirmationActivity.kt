package com.elpassion.memoryleaks.confirmation.view.impl

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.elpassion.memoryleaks.R
import com.elpassion.memoryleaks.common.android.BaseActivity
import com.elpassion.memoryleaks.elder.main.ElderMainActivity
import com.elpassion.memoryleaks.ui.elder.list.EldersListActivity

class ConfirmationActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.confirmation_activity)
        Handler().postDelayed(showNextScreen, 3000)
    }

    private val showNextScreen = {
        if (intent.getBooleanExtra(IS_ELDER_KEY, false)) {
            ElderMainActivity.start(this)
        } else {
            EldersListActivity.start(this)
        }
        finish()
    }

    companion object {

        private val IS_ELDER_KEY = "is_elder"

        fun start(context: Context, elder: Boolean) {
            val intent = Intent(context, ConfirmationActivity::class.java)
            intent.putExtra(IS_ELDER_KEY, elder)
            context.startActivity(intent)
        }
    }
}