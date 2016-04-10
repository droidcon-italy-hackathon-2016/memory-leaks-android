package com.elpassion.memoryleaks.ui.elder.list

import android.content.Context
import android.content.Intent
import com.elpassion.memoryleaks.common.android.BaseActivity

class AddElderActivity : BaseActivity() {
    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, AddElderActivity::class.java))
        }
    }
}