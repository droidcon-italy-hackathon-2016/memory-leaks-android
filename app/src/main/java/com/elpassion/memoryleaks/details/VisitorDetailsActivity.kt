package com.elpassion.memoryleaks.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.elpassion.memoryleaks.R
import com.elpassion.memoryleaks.common.android.BaseActivity
import com.elpassion.memoryleaks.model.Visitor
import kotlinx.android.synthetic.main.visitor_details_screen.*

class VisitorDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.visitor_details_screen)
        val visitor: Visitor =  (intent.getSerializableExtra(VISITOR_KEY) as? Visitor) ?:Visitor("as","Asd")
        visitor_details_name.text = visitor.name
        visitor_details_relation.text = visitor.relation
        visitor_details_photo.setImageResource(R.drawable.grandpa_and_child)
    }


    companion object {
        private val VISITOR_KEY = "visitor"

        fun start(context: Context, visitor: Visitor) {
            val intent = Intent(context, VisitorDetailsActivity::class.java)
            intent.putExtra(VISITOR_KEY, visitor)
            context.startActivity(intent)
        }
    }
}