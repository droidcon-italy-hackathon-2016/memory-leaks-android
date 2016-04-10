package com.elpassion.memoryleaks.register.elder.view.impl

import android.os.Bundle
import com.elpassion.memoryleaks.R
import com.elpassion.memoryleaks.common.android.BaseActivity
import com.elpassion.memoryleaks.confirmation.view.impl.ConfirmationActivity
import com.elpassion.memoryleaks.register.api.impl.RegisterElderService
import com.elpassion.memoryleaks.register.elder.RegisterElderController
import com.elpassion.memoryleaks.register.elder.view.RegisterElderView
import kotlinx.android.synthetic.main.register_elder_activity.*
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class RegisterElderActivity : BaseActivity(), RegisterElderView {

    private val controller = RegisterElderController(
            RegisterElderService.getRegisterElderCall().applySchedulers(),
            this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_elder_activity)
        register_elder_submit.setOnClickListener { controller.onRegisterClick() }
    }

    override fun showConfirmationScreen() {
        ConfirmationActivity.start(this, true)
    }

    override fun showError() {

    }

    override fun getUserData() = register_elder_name.text.toString()
}


//TODO: think about different approach
fun <P, R> ((P) -> Observable<R>).applySchedulers(): (P) -> Observable<R> {
    return { arg: P ->
        this(arg).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}
