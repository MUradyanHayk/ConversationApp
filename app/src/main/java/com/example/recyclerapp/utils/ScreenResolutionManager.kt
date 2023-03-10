package com.example.recyclerapp.utils

import android.content.Context
import android.util.DisplayMetrics
import android.view.Display

import android.view.WindowManager




object ScreenResolutionManager {
    fun getScreenResolution(context: Context): String? {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display: Display = wm.defaultDisplay
        val metrics = DisplayMetrics()
        display.getMetrics(metrics)
        val width = metrics.widthPixels
        val height = metrics.heightPixels
        return "{$width,$height}"
    }

    fun getScreenWidth(context: Context): Int {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display: Display = wm.defaultDisplay
        val metrics = DisplayMetrics()
        display.getMetrics(metrics)
        return metrics.widthPixels
    }


    fun getScreenHeight(context: Context): Int {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display: Display = wm.defaultDisplay
        val metrics = DisplayMetrics()
        display.getMetrics(metrics)
        return metrics.heightPixels
    }
}