package com.vlr.dk.yugratablet.gesture

import android.view.GestureDetector
import android.view.MotionEvent
import androidx.fragment.app.FragmentActivity
import kotlin.system.exitProcess


class CustomGestureListener(private val activity: FragmentActivity?) :
    GestureDetector.SimpleOnGestureListener() {

    override fun onDown(e: MotionEvent?): Boolean {
        return true
    }

    override fun onLongPress(e: MotionEvent?) {
        activity?.finish()
        exitProcess(0)
    }
}