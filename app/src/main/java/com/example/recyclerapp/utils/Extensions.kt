package com.example.recyclerapp.utils

import android.content.res.Resources
import android.view.View

val Int.dp: Int
    get() = this * Resources.getSystem().displayMetrics.density.toInt()

val Long.dp: Long
    get() = this * Resources.getSystem().displayMetrics.density.toLong()

val Float.dp: Float
    get() = this * Resources.getSystem().displayMetrics.density

val Double.dp: Double
    get() = this * Resources.getSystem().displayMetrics.density.toDouble()


fun View.setPaddings(pad: Int) {
    this.setPadding(pad, pad, pad, pad)
}