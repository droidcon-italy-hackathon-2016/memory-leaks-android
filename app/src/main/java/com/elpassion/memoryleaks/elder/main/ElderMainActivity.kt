package com.elpassion.memoryleaks.elder.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import com.elpassion.memoryleaks.R
import com.elpassion.memoryleaks.common.android.BaseActivity
import kotlinx.android.synthetic.main.elder_main_activity.*

class ElderMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.elder_main_activity)
        elder_main_token.text = PreferenceManager.getDefaultSharedPreferences(this).getString("elder_id", "TODO").substring(0, 4)
    }

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, ElderMainActivity::class.java)
            context.startActivity(intent)
        }
    }
}