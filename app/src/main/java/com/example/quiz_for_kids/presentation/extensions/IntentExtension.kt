package com.example.quiz_for_kids.presentation.extensions

import android.content.Intent
import android.os.Parcelable

fun Intent.putParcelableExtra(key: String, value: Parcelable?) {
    putExtra(key, value)
}