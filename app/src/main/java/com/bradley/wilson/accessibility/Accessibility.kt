package com.bradley.wilson.accessibility

import android.accessibilityservice.AccessibilityServiceInfo
import android.view.accessibility.AccessibilityManager

class Accessibility(private val am: AccessibilityManager) {

    fun isTalkbackEnabled() = am.isEnabled &&
            am.getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_SPOKEN)
                .isNotEmpty()

}