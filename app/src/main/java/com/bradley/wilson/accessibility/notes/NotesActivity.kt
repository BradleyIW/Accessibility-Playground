package com.bradley.wilson.accessibility.notes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.accessibility.AccessibilityManager
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener
import androidx.appcompat.app.AppCompatActivity
import com.bradley.wilson.accessibility.R
import com.bradley.wilson.accessibility.core.accessibility.Accessibility
import com.bradley.wilson.accessibility.core.extension.headingForAccessibility
import com.bradley.wilson.accessibility.core.extension.hideKeyboard
import com.bradley.wilson.accessibility.core.extension.showKeyboard
import kotlinx.android.synthetic.main.activity_notes.*

class NotesActivity : AppCompatActivity(R.layout.activity_notes) {

    private val accessibility by lazy {
        Accessibility(
            getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager
        )
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
                        final_note_text_view.contentDescription = "$it"
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
        final_note_text_view.setOnLongClickListener { p0 ->
            p0?.let {
                (it as TextView).text = ""
            }
            true
        }
    }

    private fun initTitleTextView() {
        note_screen_title.headingForAccessibility()
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, NotesActivity::class.java)
    }
}