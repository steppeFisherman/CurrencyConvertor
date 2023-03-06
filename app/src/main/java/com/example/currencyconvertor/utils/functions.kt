package com.example.currencyconvertor.utils

import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.StringRes
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

fun View.snackLong(@StringRes message: Int) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG)
        .show()
    this.textAlignment = View.TEXT_ALIGNMENT_CENTER
}

fun View.snackLongCenter(@StringRes message: Int) {
    val snackBar = Snackbar.make(this, message, Snackbar.LENGTH_LONG)
    val layoutParams = FrameLayout.LayoutParams(snackBar.view.layoutParams)

    layoutParams.gravity = Gravity.CENTER
    layoutParams.marginStart = 40
    layoutParams.marginEnd = 40
    snackBar.view.setPadding(0, 0, 0, 8)
    snackBar.view.layoutParams = layoutParams
    snackBar.animationMode = BaseTransientBottomBar.ANIMATION_MODE_FADE
    snackBar.show()
}

fun View.visible(show: Boolean) =
    if (show) this.visibility = View.VISIBLE else this.visibility = View.INVISIBLE