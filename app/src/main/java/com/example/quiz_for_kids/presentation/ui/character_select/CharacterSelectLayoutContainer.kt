package com.example.quiz_for_kids.presentation.ui.character_select

import com.example.quiz_for_kids.R
import com.example.quiz_for_kids.databinding.ActivityCharacterSelectBinding
import com.example.quiz_for_kids.presentation.extensions.startWithTransaction
import com.example.quiz_for_kids.presentation.models.CharacterModel
import com.example.quiz_for_kids.presentation.ui.questions.QuestionsActivity

class CharacterSelectLayoutContainer(
    private val activity: CharacterSelectActivity,
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

    private fun goToQuestionActivity(characterSelected: CharacterModel) {
        val character = when (characterSelected) {
            CharacterModel.CHARACTER_ONE -> R.drawable.boy_character_one
            CharacterModel.CHARACTER_TWO -> R.drawable.boy_character_two
            CharacterModel.CHARACTER_THREE -> R.drawable.girl_character_one
            CharacterModel.CHARACTER_FOUR -> R.drawable.girl_character_two
        }
        val intent = QuestionsActivity.newIntent(activity, character)
        activity.startWithTransaction(intent)
    }
}