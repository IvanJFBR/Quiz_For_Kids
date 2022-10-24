package com.example.quiz_for_kids.presentation.ui.result

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz_for_kids.databinding.ActivityResultBinding
import com.example.quiz_for_kids.presentation.extensions.extra
import com.example.quiz_for_kids.presentation.extensions.viewBinding

class ResultActivity : AppCompatActivity() {
    private val characterSelected by extra<Int>(CHARACTER_SELECTED)

    private val binding by viewBinding(
        ActivityResultBinding::inflate
    )

    private val layoutContainer: ResultLayoutContainer by lazy {
        ResultLayoutContainer(this@ResultActivity, binding)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        layoutContainer.initView(characterSelected)
    }

    companion object {
        private const val CHARACTER_SELECTED = "CHARACTER_SELECTED"

        fun newIntent(
            context: Context,
            characterSelected: Int
        ): Intent {
            return Intent(context, ResultActivity::class.java).apply {
                putExtra(CHARACTER_SELECTED, characterSelected)
            }
        }
    }
}