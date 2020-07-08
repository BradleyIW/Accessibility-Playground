package com.bradley.wilson.accessibility.core

import android.app.Activity
import androidx.test.espresso.accessibility.AccessibilityChecks
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.runner.RunWith

open class ActivityTest(clazz: Class<out Activity>) : FunctionalTest() {
    @get:Rule
    val activityRule = ActivityTestRule(clazz)
}

@LargeTest
@RunWith(AndroidJUnit4::class)
open class FunctionalTest {

    companion object {
        @BeforeClass
        @JvmStatic
        fun enableAllChecks() {
            AccessibilityChecks.enable()
                .setRunChecksFromRootView(true)
        }
    }
}