package com.example.quiz_for_kids.presentation.ui.character_select

import com.example.quiz_for_kids.databinding.ActivityCharacterSelectBinding
import com.example.quiz_for_kids.presentation.models.CharacterModel

class CharacterSelectLayoutContainer(
    private val binding: ActivityCharacterSelectBinding
) {
    fun initView() = with(binding) {
        characterOne.setOnClickListener {
            goToQuestionActivity(CharacterModel.CHARACTER_ONE)
        }
        characterTwo.setOnClickListener {
            goToQuestionActivity(CharacterModel.CHARACTER_TWO)
        }
        characterThree.setOnClickListener {
            goToQuestionActivity(CharacterModel.CHARACTER_THREE)
        }
        characterFour.setOnClickListener {
            goToQuestionActivity(CharacterModel.CHARACTER_FOUR)
        }
    }

    private fun goToQuestionActivity(characterOne: CharacterModel) {

    }
}