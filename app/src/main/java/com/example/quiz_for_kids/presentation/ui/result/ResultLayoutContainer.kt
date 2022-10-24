package com.example.quiz_for_kids.presentation.ui.result

import com.example.quiz_for_kids.databinding.ActivityResultBinding
import com.example.quiz_for_kids.presentation.ui.questions.QuestionsData

class ResultLayoutContainer(
    private val activity: ResultActivity,
    private val binding: ActivityResultBinding,
    private val questionsData: QuestionsData
) {
    fun initView(characterSelected: Int) = with(binding) {
        acivCharacterSelected.setImageResource(characterSelected)
    }
}