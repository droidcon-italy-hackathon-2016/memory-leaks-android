package com.elpassion.memoryleaks.register.elder.view.impl

import android.os.Bundle
import android.widget.TextView
import com.elpassion.memoryleaks.R
import com.elpassion.memoryleaks.common.android.BaseActivity
import com.elpassion.memoryleaks.confirmation.view.impl.ConfirmationActivity
import com.elpassion.memoryleaks.register.api.impl.RegisterApi
import com.elpassion.memoryleaks.register.elder.RegisterElderController
import com.elpassion.memoryleaks.register.elder.view.RegisterElderView

class RegisterElderActivity : BaseActivity(), RegisterElderView {

    private val controller = RegisterElderController(RegisterApi.getRegisterElderApiCall(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_elder_activity)
        val submit = findViewById(R.id.register_elder_submit)!!
        submit.setOnClickListener { controller.onRegisterClick() }
    }

    override fun showConfirmationScreen() {
        ConfirmationActivity.start(this)
    }

    override fun showError() {

    }

    override fun getUserData() = (findViewById(R.id.register_elder_name) as TextView).text.toString()
}
