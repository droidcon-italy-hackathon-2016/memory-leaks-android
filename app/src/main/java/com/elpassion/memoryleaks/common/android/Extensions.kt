package com.elpassion.memoryleaks.common.android

import android.media.MediaPlayer
import android.support.annotation.StringRes
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.widget.ImageView
import com.bumptech.glide.Glide


fun CoordinatorLayout.showSnackBar(@StringRes message: Int) {
    Snackbar.make(this, message, Snackbar.LENGTH_INDEFINITE).show()
}

fun MediaPlayer.startIfNotPlaying() {
    if (!isPlaying) start()
}

fun ImageView.loadWithGlide(url: String) {
    Glide.with(context).load(url).into(this)
}