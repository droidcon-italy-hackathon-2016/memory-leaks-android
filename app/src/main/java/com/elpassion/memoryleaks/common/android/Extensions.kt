package com.elpassion.memoryleaks.common.android

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.support.annotation.StringRes
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar


fun CoordinatorLayout.showSnackBar(@StringRes message: Int) {
    Snackbar.make(this, message, Snackbar.LENGTH_INDEFINITE).show()
}

fun MediaPlayer.startIfNotPlaying() {
    if (!isPlaying) start()
}
