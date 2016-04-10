package com.elpassion.memoryleaks.details

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.elpassion.memoryleaks.R
import com.elpassion.memoryleaks.common.android.BaseActivity
import com.elpassion.memoryleaks.common.android.loadWithGlide
import com.elpassion.memoryleaks.common.android.startIfNotPlaying
import com.elpassion.memoryleaks.model.FullVisitor
import kotlinx.android.synthetic.main.visitor_details_screen.*

class VisitorDetailsActivity : BaseActivity() {

    val mediaPlayer by lazy { MediaPlayer.create(this, R.raw.door_bell) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.visitor_details_screen)
        val visitor = intent.getSerializableExtra(VISITOR_KEY) as FullVisitor
        visitor_details_name.text = visitor.name
        visitor_details_relation.text = visitor.relation
        visitor_details_photo.loadWithGlide(visitor.photoUrls[0])
        visitor_details_photo_pager.adapter = MyViewPager(visitor.photoUrls)
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer.startIfNotPlaying()
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

class MyViewPager(val urls: List<String>) : PagerAdapter() {

    override fun getCount() = urls.size

    override fun isViewFromObject(view: View?, obj: Any?) = view == obj

    override fun instantiateItem(container: ViewGroup, position: Int): Any? {
        val view = LayoutInflater.from(container.context).inflate(R.layout.image_item, container, false) as ImageView
        view.loadWithGlide(urls[position])
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any?) {
        container.removeView(obj as View)
    }
}
