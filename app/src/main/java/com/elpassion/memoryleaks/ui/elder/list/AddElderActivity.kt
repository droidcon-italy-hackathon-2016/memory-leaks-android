package com.elpassion.memoryleaks.ui.elder.list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.elpassion.memoryleaks.R
import com.elpassion.memoryleaks.common.android.BaseActivity
import com.elpassion.memoryleaks.common.android.showSnackBar
import com.elpassion.memoryleaks.usecase.elder.add.ElderAddController
import com.elpassion.memoryleaks.usecase.elder.add.ElderAddView
import com.elpassion.memoryleaks.usecase.elder.add.api.ElderAddApiCallProvider.getElderAddApiCall
import kotlinx.android.synthetic.main.add_elder_activity.*
import rx.android.schedulers.AndroidSchedulers.mainThread
import rx.schedulers.Schedulers.io

class AddElderActivity : BaseActivity(), ElderAddView {

    val elderAddApiCall = { elderId: String, childId: String, relation: String ->
        getElderAddApiCall().invoke(elderId, childId, relation).subscribeOn(io()).observeOn(mainThread())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_elder_activity)
        send_elder_secret_token.setOnClickListener({
            ElderAddController(elderAddApiCall, this, "place_for_your_id").onAddElderClick()
        })
    }

    override fun showSuccess() {
        finish()
    }

    override fun showError() {
        add_elder_coordinator.showSnackBar(R.string.error_occurred)
    }

    override fun getRelation() = your_relation_to_elder.text.toString().trim()

    override fun getElderId() = elder_id.text.toString().trim()

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, AddElderActivity::class.java))
        }
    }
}
