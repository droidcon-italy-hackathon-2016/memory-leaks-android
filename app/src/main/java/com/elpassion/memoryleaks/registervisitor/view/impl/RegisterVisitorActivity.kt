package com.elpassion.memoryleaks.registervisitor.view.impl

import android.os.Bundle
import android.widget.TextView
import com.elpassion.memoryleaks.R
import com.elpassion.memoryleaks.common.android.BaseActivity
import com.elpassion.memoryleaks.confirmation.view.impl.ConfirmationActivity
import com.elpassion.memoryleaks.registervisitor.RegisterVisitorController
import com.elpassion.memoryleaks.registervisitor.RegisterVisitorView
import rx.Observable.just

class RegisterVisitorActivity : BaseActivity(), RegisterVisitorView {

    private val controller = RegisterVisitorController({ just(Unit) }, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_visitor_activity)
        val submit = findViewById(R.id.register_visitor_submit)!!
        submit.setOnClickListener { controller.onRegisterClick() }
    }

    override fun showConfirmationScreen() {
        ConfirmationActivity.start(this)
    }

    override fun showError() {

    }

    override fun getUserData() = (findViewById(R.id.register_visitor_name) as TextView).text.toString()
}
