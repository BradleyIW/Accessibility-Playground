package com.bradley.wilson.accessibility.extension

import android.app.Activity
import android.view.inputmethod.InputMethodManager

fun Activity.showKeyboard() =
    (this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager).toggleSoftInput(
        InputMethodManager.SHOW_FORCED,
        InputMethodManager.HIDE_IMPLICIT_ONLY
    )


fun Activity.hideKeyboard() =
    (this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
        currentFocus?.windowToken,
        0
    )

