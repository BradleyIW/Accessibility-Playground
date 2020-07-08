package com.bradley.wilson.accessibility.startup

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import com.bradley.wilson.accessibility.R
import com.bradley.wilson.accessibility.core.extension.headingForAccessibility
import com.bradley.wilson.accessibility.notes.NotesActivity
import kotlinx.android.synthetic.main.activity_startup.*

class StartupActivity : AppCompatActivity(R.layout.activity_startup) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initStartupHeading()
        initAccessibilitySettingsButton()
        initCreateTemporaryNoteButton()
    }

    private fun initCreateTemporaryNoteButton() {
        startup_temporary_note_button.setOnClickListener {
            val intent = NotesActivity.newIntent(this)
            startActivity(intent)
        }
    }

    private fun initStartupHeading() {
        startup_title_text_view.headingForAccessibility()
    }

    private fun initAccessibilitySettingsButton() {
        startup_go_to_accessibility_settings.setOnClickListener {
            val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
            startActivity(intent)
        }
    }
}