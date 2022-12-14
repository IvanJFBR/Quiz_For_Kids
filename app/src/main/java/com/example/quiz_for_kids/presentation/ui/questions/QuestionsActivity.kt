package com.example.quiz_for_kids.presentation.ui.questions

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz_for_kids.databinding.ActivityQuestionsBinding
import com.example.quiz_for_kids.presentation.extensions.extra
import com.example.quiz_for_kids.presentation.extensions.viewBinding

class QuestionsActivity : AppCompatActivity() {
    private val characterSelected by extra<Int>(CHARACTER_SELECTED)

    private val binding by viewBinding(
        ActivityQuestionsBinding::inflate
    )

    private val layoutContainer: QuestionsLayoutContainer by lazy {
        QuestionsLayoutContainer(this@QuestionsActivity, binding, characterSelected)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        layoutContainer.initView()
    }

    companion object {
        private const val CHARACTER_SELECTED = "CHARACTER_SELECTED"

        fun newIntent(
            context: Context,
            characterSelected: Int
        ): Intent {
            return Intent(context, QuestionsActivity::class.java).apply {
                putExtra(CHARACTER_SELECTED, characterSelected)
            }
        }
    }
}