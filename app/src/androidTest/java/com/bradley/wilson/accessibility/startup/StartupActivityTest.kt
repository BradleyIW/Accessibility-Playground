package com.bradley.wilson.accessibility.startup

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.*
import com.bradley.wilson.accessibility.R
import com.bradley.wilson.accessibility.notes.NotesActivity
import com.bradley.wilson.accessibility.core.ActivityTest
import org.junit.After
import org.junit.Before
import org.junit.Test

class StartupActivityTest : ActivityTest(StartupActivity::class.java) {

    @Before
    fun init() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun launch_uiElementsVisible() {
        onView(withText(R.string.create_a_new_temporary_note))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withText(R.string.welcome_to_the_accessibility_playground))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withText(R.string.go_to_accessibility_settings))
            .check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun createTemporaryNoteButtonClick() {
        onView(withId(R.id.startup_temporary_note_button)).perform(click())
        intended(hasComponent(NotesActivity::class.java.name))
    }
}