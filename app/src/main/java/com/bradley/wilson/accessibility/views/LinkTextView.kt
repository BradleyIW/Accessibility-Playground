package com.bradley.wilson.accessibility.views

import android.content.Context
import android.text.util.Linkify
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.bradley.wilson.accessibility.R

class LinkTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AppCompatTextView(context, attrs, defStyle) {
    init {
        minWidth = context.resources.getDimension(R.dimen.min_touchable_width).toInt()
        minHeight = context.resources.getDimension(R.dimen.min_touchable_height).toInt()
        Linkify.addLinks(this, Linkify.ALL)
    }
}