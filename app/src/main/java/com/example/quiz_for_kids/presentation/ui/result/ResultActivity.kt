package com.example.quiz_for_kids.presentation.ui.result

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz_for_kids.databinding.ActivityResultBinding
import com.example.quiz_for_kids.presentation.extensions.extra
import com.example.quiz_for_kids.presentation.extensions.putParcelableExtra
import com.example.quiz_for_kids.presentation.extensions.viewBinding
import com.example.quiz_for_kids.presentation.ui.questions.QuestionsData

class ResultActivity : AppCompatActivity() {
    private val characterSelected by extra<Int>(CHARACTER_SELECTED)
    private val questionsData by extra<QuestionsData>(QUESTIONS_DATA)

    private val binding by viewBinding(
        ActivityResultBinding::inflate
    )

    private val layoutContainer: ResultLayoutContainer by lazy {
        ResultLayoutContainer(this@ResultActivity, binding, questionsData)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        layoutContainer.initView(characterSelected)
    }

    companion object {
        private const val CHARACTER_SELECTED = "CHARACTER_SELECTED"
        private const val QUESTIONS_DATA = "QUESTIONS_DATA"

        fun newIntent(
            context: Context,
            characterSelected: Int,
            questionsData: QuestionsData
        ): Intent {
            return Intent(context, ResultActivity::class.java).apply {
                putExtra(CHARACTER_SELECTED, characterSelected)
                putParcelableExtra(QUESTIONS_DATA, questionsData)
            }
        }
    }
}