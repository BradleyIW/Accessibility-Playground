package com.bradley.wilson.accessibility.core.extension

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
                info.isHeading = true
                super.onInitializeAccessibilityNodeInfo(host, info)
            }
        })
    }

fun View.screenReaderFocusable() =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        isScreenReaderFocusable = true
    } else {
        ViewCompat.setAccessibilityDelegate(this, object : AccessibilityDelegateCompat() {
            override fun onInitializeAccessibilityNodeInfo(
                host: View,
                info: AccessibilityNodeInfoCompat
            ) {
                info.isScreenReaderFocusable = true
                super.onInitializeAccessibilityNodeInfo(host, info)
            }
        })
    }

fun View.paneTitleForAccessibility(title: String) =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        accessibilityPaneTitle = title
    } else {
        ViewCompat.setAccessibilityDelegate(this, object : AccessibilityDelegateCompat() {
            override fun onInitializeAccessibilityNodeInfo(
                host: View,
                info: AccessibilityNodeInfoCompat
            ) {
                info.paneTitle = title
                super.onInitializeAccessibilityNodeInfo(host, info)
            }
        })
    }