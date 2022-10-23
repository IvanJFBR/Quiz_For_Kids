package com.example.quiz_for_kids.presentation.ui.character_select

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz_for_kids.R
import com.example.quiz_for_kids.databinding.ActivityCharacterSelectBinding
import com.example.quiz_for_kids.presentation.extensions.viewBinding

class CharacterSelectActivity : AppCompatActivity() {
    private val binding by viewBinding(
        ActivityCharacterSelectBinding::inflate
    )

    private val layoutContainer: CharacterSelectLayoutContainer by lazy {
        CharacterSelectLayoutContainer(binding)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_select)
        setContentView(binding.root)

        layoutContainer.initView()
    }
}