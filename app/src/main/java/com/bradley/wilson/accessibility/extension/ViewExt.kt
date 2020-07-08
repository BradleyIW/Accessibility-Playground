package com.bradley.wilson.accessibility.extension

import android.os.Build
import android.view.View
import androidx.core.view.AccessibilityDelegateCompat
import androidx.core.view.ViewCompat
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat

fun View.headingForAccessibility() =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        isAccessibilityHeading = true
    } else {
        ViewCompat.setAccessibilityDelegate(this, object : AccessibilityDelegateCompat() {
            override fun onInitializeAccessibilityNodeInfo(
                host: View,
                info: AccessibilityNodeInfoCompat
            ) {
                super.onInitializeAccessibilityNodeInfo(host, info)
                info.isHeading = true
            }
        })
    }