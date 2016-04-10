package com.elpassion.memoryleaks.notifications

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.elpassion.memoryleaks.details.VisitorDetailsActivity
import com.elpassion.memoryleaks.model.FullVisitor
import com.elpassion.memoryleaks.model.Visitor
import com.google.android.gms.gcm.GcmListenerService
import com.google.gson.Gson

class NotificationListenerService : GcmListenerService() {

    override fun onMessageReceived(from: String?, data: Bundle) {
        Log.e("MEMORYLEAK", data.toString())
        val payload = data.getString(CHILD_KEY)
        val visitor = Gson().fromJson(payload, FullVisitor::class.java)
        startVisitorDetailsActivity(visitor)
    }

    private fun startVisitorDetailsActivity(visitor: FullVisitor) {
        val intent = VisitorDetailsActivity.getStartingIntent(this, visitor)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

    companion object {
        private val CHILD_KEY = "child"
    }
}