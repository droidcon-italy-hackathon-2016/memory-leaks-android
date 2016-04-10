package com.elpassion.memoryleaks.register.visitor.view.impl

import android.os.Bundle
import android.widget.TextView
import com.elpassion.memoryleaks.R
import com.elpassion.memoryleaks.common.android.BaseActivity
import com.elpassion.memoryleaks.common.android.showSnackBar
import com.elpassion.memoryleaks.confirmation.view.impl.ConfirmationActivity
import com.elpassion.memoryleaks.register.api.impl.RegisterApi
import com.elpassion.memoryleaks.register.visitor.RegisterVisitorController
import com.elpassion.memoryleaks.register.visitor.view.RegisterVisitorView
import kotlinx.android.synthetic.main.register_visitor_activity.*

class RegisterVisitorActivity : BaseActivity(), RegisterVisitorView {

    private val controller = RegisterVisitorController(RegisterApi.getRegisterVisitorApiCall(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_visitor_activity)
        register_visitor_submit.setOnClickListener { controller.onRegisterClick() }
    }

    override fun showConfirmationScreen() {
        ConfirmationActivity.start(this, false)
    }

    override fun showError() {
        register_visitor_coordinator.showSnackBar(R.string.error_occurred)
    }

    override fun getUserData() = (findViewById(R.id.register_visitor_name) as TextView).text.toString()
}
