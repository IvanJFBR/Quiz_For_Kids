package com.example.quiz_for_kids.presentation.ui.result

import com.example.quiz_for_kids.databinding.ActivityResultBinding

class ResultLayoutContainer(
    private val activity: ResultActivity,
    private val binding: ActivityResultBinding
) {
    fun initView(characterSelected: Int) = with(binding) {
        acivCharacterSelected.setImageResource(characterSelected)
    }
}