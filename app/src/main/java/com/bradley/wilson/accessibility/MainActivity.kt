package com.bradley.wilson.accessibility

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.accessibility.AccessibilityManager
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import androidx.appcompat.app.AppCompatActivity
import com.bradley.wilson.accessibility.extension.headingForAccessibility
import com.bradley.wilson.accessibility.extension.hideKeyboard
import com.bradley.wilson.accessibility.extension.showKeyboard
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val accessibility by lazy {
        Accessibility(getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initTitleTextView()
        initNoteInput()
        initNoteDisplayTextView()
    }

    override fun onResume() {
        super.onResume()
        requestFocusAndShowKeyboard(note_input_edit_text)
    }

    private fun initNoteInput() {
        note_input_edit_text.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEND) {
                note_input_edit_text.text?.let {
                    if (it.isNotEmpty()) {
                        final_note_text_view.text = "$it"
                    }
                }
                note_input_edit_text.setText("")
                clearFocusAndHideKeyboard(v)
                return@OnEditorActionListener true
            }
            false
        })
    }

    private fun requestFocusAndShowKeyboard(view: View) {
        if (!accessibility.isTalkbackEnabled()) {
            view.requestFocus()
            showKeyboard()
        }
    }

    private fun clearFocusAndHideKeyboard(view: View) {
        hideKeyboard()
        view.clearFocus()
    }

    private fun initNoteDisplayTextView() {
        note_input_edit_text.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEND) {
                note_input_edit_text.text?.let {
                    if (it.isNotEmpty()) {
                        final_note_text_view.text = it.toString()
                    }
                }
                note_input_edit_text.setText("")
                hideKeyboard()
                note_input_edit_text.clearFocus()
                return@OnEditorActionListener true
            }
            false
        })
    }

    private fun initTitleTextView() {
        note_screen_title.headingForAccessibility()
    }
}