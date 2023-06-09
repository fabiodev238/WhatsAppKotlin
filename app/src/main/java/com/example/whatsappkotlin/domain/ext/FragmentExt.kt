
package com.example.whatsappkotlin.domain.ext

import androidx.fragment.app.Fragment
import hideKeyboard

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}