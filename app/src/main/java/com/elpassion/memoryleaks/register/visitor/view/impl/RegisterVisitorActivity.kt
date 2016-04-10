package com.elpassion.memoryleaks.register.visitor.view.impl

import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.TextView
import com.elpassion.memoryleaks.R
import com.elpassion.memoryleaks.common.android.BaseActivity
import com.elpassion.memoryleaks.common.android.showSnackBar
import com.elpassion.memoryleaks.confirmation.view.impl.ConfirmationActivity
import com.elpassion.memoryleaks.register.api.impl.RegisterApi.Companion.getRegisterVisitorApiCall
import com.elpassion.memoryleaks.register.visitor.RegisterVisitorController
import com.elpassion.memoryleaks.register.visitor.view.RegisterVisitorView
import com.elpassion.memoryleaks.ui.elder.list.EldersListActivity
import kotlinx.android.synthetic.main.register_visitor_activity.*
import rx.android.schedulers.AndroidSchedulers.mainThread
import rx.schedulers.Schedulers.io

class RegisterVisitorActivity : BaseActivity(), RegisterVisitorView {

    private val controller = RegisterVisitorController({
        getRegisterVisitorApiCall()
                .invoke(it).subscribeOn(io()).observeOn(mainThread())
                .doOnNext { PreferenceManager.getDefaultSharedPreferences(this).edit().putString("visitor_id", it.id).apply() }
    }, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_visitor_activity)
        if (PreferenceManager.getDefaultSharedPreferences(this).getString("visitor_id", null) != null) {
            EldersListActivity.start(this)
            finish()
        }
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
