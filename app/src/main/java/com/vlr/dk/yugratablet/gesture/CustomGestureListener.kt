package com.vlr.dk.yugratablet.gesture

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.fragment.app.FragmentActivity
import com.vlr.dk.yugratablet.MainActivity
import kotlin.system.exitProcess


class CustomGestureListener(private val activity: FragmentActivity?) :
    GestureDetector.SimpleOnGestureListener() {

    override fun onDown(e: MotionEvent?): Boolean {
        return true
    }

    override fun onLongPress(e: MotionEvent?) {
        activity?.let {
            resetPreferredLauncherAndOpenChooser(it as Context)
        }
        activity?.finish()
        exitProcess(0)
    }

    private fun resetPreferredLauncherAndOpenChooser(context: Context) {
        val packageManager = context.packageManager
        val componentName =
            ComponentName(context, MainActivity::class.java)
        packageManager.setComponentEnabledSetting(
            componentName,
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
        val selector = Intent(Intent.ACTION_MAIN)
        selector.addCategory(Intent.CATEGORY_HOME)
        selector.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(selector)
        packageManager.setComponentEnabledSetting(
            componentName,
            PackageManager.COMPONENT_ENABLED_STATE_DEFAULT,
            PackageManager.DONT_KILL_APP
        )
    }
}