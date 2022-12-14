package com.example.quiz_for_kids.presentation.ui.character_select

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz_for_kids.databinding.ActivityCharacterSelectBinding
import com.example.quiz_for_kids.presentation.extensions.viewBinding

class CharacterSelectActivity : AppCompatActivity() {
    private val binding by viewBinding(
        ActivityCharacterSelectBinding::inflate
    )

    private val layoutContainer: CharacterSelectLayoutContainer by lazy {
        CharacterSelectLayoutContainer(this@CharacterSelectActivity, binding)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        layoutContainer.initView()
    }

    companion object {
        fun newIntent(
            context: Context
        ): Intent {
            return Intent(context, CharacterSelectActivity::class.java)
        }
    }
}