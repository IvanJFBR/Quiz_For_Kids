package com.example.quiz_for_kids.presentation.ui.result

import android.content.Intent
import com.example.quiz_for_kids.R
import com.example.quiz_for_kids.databinding.ActivityResultBinding
import com.example.quiz_for_kids.presentation.extensions.startWithTransaction
import com.example.quiz_for_kids.presentation.ui.character_select.CharacterSelectActivity
import com.example.quiz_for_kids.presentation.ui.questions.QuestionsData

class ResultLayoutContainer(
    private val activity: ResultActivity,
    private val binding: ActivityResultBinding
) {
    fun initView(characterSelected: Int) = with(binding) {
        acivCharacterSelected.setImageResource(characterSelected)
        actvScore.text = String.format(
            root.context.getString(R.string.score),
            QuestionsData.score,
            QuestionsData.getQuestions().size
        )

        endQuiz.setOnClickListener {
            QuestionsData.score = 0

            val intent = CharacterSelectActivity.newIntent(activity)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            activity.startWithTransaction(intent)
        }
    }
}