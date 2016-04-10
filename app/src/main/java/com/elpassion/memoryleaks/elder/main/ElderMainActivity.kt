package com.elpassion.memoryleaks.elder.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.elpassion.memoryleaks.R
import com.elpassion.memoryleaks.common.android.BaseActivity

class ElderMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.elder_main_activity)
    }

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, ElderMainActivity::class.java)
            context.startActivity(intent)
        }
    }
}