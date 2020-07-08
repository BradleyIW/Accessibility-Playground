package com.bradley.wilson.accessibility.notes

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.bradley.wilson.accessibility.R
import com.bradley.wilson.accessibility.core.ActivityTest
import org.hamcrest.CoreMatchers.containsString
import org.junit.Test

class NotesActivityTest : ActivityTest(NotesActivity::class.java) {

    @Test
    fun launch_uiElementsVisible() {
        onView(withId(R.id.notes_link_text_view))
            .check(matches(isDisplayed()))
        onView(withText(R.string.enter_a_temporary_note_below))
            .check(matches(isDisplayed()))
        onView(withHint(R.string.create_a_new_temporary_note))
            .check(matches(isDisplayed()))
        onView(withText(R.string.long_press_to_remove_note))
            .check(matches(isDisplayed()))
    }

    @Test
    fun inputText_sendToDisplayNote() {
        onView(withId(R.id.note_input_edit_text))
            .perform(replaceText(TEST_INPUT))
            .perform(pressImeActionButton())

        onView(withId(R.id.final_note_text_view))
            .check(matches(withText(containsString(TEST_INPUT))))

    }

    @Test
    fun inputText_sendToDisplayNote_longPressToRemote() {
        inputText_sendToDisplayNote()

        onView(withId(R.id.final_note_text_view))
            .perform(longClick())

        onView(withId(R.id.final_note_text_view))
            .check(matches(withText(containsString(""))))

    }

    @Test
    fun clickLink_navigateToUrl() {
        onView(withId(R.id.notes_link_text_view))
            .perform(openLinkWithText("www.google.com"))
    }

    companion object {
        const val TEST_INPUT = "This is a note"
    }
}