package com.elpassion.memoryleaks.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.elpassion.memoryleaks.R
import com.elpassion.memoryleaks.common.android.BaseActivity
import com.elpassion.memoryleaks.common.android.loadWithGlide
import com.elpassion.memoryleaks.model.FullVisitor
import kotlinx.android.synthetic.main.visitor_details_screen.*

class VisitorDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.visitor_details_screen)
        val visitor = (intent.getSerializableExtra(VISITOR_KEY) as? FullVisitor) ?: FullVisitor("as", "Asd", "a")
        visitor_details_name.text = visitor.name
        visitor_details_relation.text = visitor.relation
        visitor_details_photo.loadWithGlide(visitor.photoUrl)
    }


    companion object {
        private val VISITOR_KEY = "visitor"

        fun getStartingIntent(context: Context, visitor: FullVisitor): Intent {
            val intent = Intent(context, VisitorDetailsActivity::class.java)
            intent.putExtra(VISITOR_KEY, visitor)
            return intent
        }
    }
}