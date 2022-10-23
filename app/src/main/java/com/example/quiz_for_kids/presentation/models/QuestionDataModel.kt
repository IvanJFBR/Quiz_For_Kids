package com.example.quiz_for_kids.presentation.models

import androidx.annotation.DrawableRes

data class QuestionDataModel(
    var id: Int,
    var question: String,
    var question_image: DrawableRes? = null,

    var option_one: String? = null,
    var option_one_image: DrawableRes? = null,
    var option_two: String? = null,
    var option_two_image: DrawableRes? = null,
    var option_three: String? = null,
    var option_three_image: DrawableRes? = null,
    var option_four: String? = null,
    var option_four_image: DrawableRes? = null,

    var correct_ans: Int
)