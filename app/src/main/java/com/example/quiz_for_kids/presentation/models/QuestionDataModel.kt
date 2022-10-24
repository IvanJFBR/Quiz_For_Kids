package com.example.quiz_for_kids.presentation.models

import androidx.annotation.DrawableRes

data class QuestionDataModel(
    var id: Int,
    var question_text: String,
    var question_image: DrawableRes? = null,

    var answersAreImage: Boolean = false,
    var option_one_text: String? = null,
    var option_one_image: Int? = null,
    var option_two_text: String? = null,
    var option_two_image: Int? = null,
    var option_three_text: String? = null,
    var option_three_image: Int? = null,
    var option_four_text: String? = null,
    var option_four_image: Int? = null,

    var correct_ans: AnswerModel
)