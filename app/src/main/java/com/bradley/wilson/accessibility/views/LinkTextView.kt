package com.bradley.wilson.accessibility.views

import android.content.Context
import android.text.util.Linkify
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class LinkTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AppCompatTextView(context, attrs, defStyle) {
    init {
        Linkify.addLinks(this, Linkify.ALL);
    }
}