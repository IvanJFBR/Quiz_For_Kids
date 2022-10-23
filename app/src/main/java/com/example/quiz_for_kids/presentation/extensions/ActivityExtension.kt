package com.example.quiz_for_kids.presentation.extensions

import android.app.Activity
import android.content.Intent
import com.example.quiz_for_kids.R

inline fun <reified T> Activity.extra(key: String): Lazy<T> = lazy {
    val value = intent.extras?.get(key)
    if (value is T) value else throw IllegalArgumentException("didn't find extra with key $key")
}

fun Activity.startWithTransaction(intent: Intent) {
    startActivity(intent)
    overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left)
}