package com.vlr.dk.yugratablet

import android.app.ActivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val am = getSystemService(
            ACTIVITY_SERVICE
        ) as ActivityManager
        if (am.lockTaskModeState ==
            ActivityManager.LOCK_TASK_MODE_NONE
        ) {
            startLockTask()
        }

        setContentView(R.layout.activity_main)
    }
}