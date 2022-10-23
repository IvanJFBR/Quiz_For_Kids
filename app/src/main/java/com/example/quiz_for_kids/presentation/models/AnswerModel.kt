package com.example.quiz_for_kids.presentation.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class AnswerModel(val index: Int) : Parcelable {
    ANSWER_ONE(0),
    ANSWER_TWO(1),
    ANSWER_THREE(2),
    ANSWER_FOUR(3)
}