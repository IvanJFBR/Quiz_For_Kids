package com.example.quiz_for_kids.presentation.ui.questions

import androidx.appcompat.content.res.AppCompatResources
import com.example.quiz_for_kids.R
import com.example.quiz_for_kids.databinding.ActivityQuestionsBinding
import com.example.quiz_for_kids.presentation.models.AnswerModel
import com.example.quiz_for_kids.presentation.models.CharacterModel
import com.example.quiz_for_kids.presentation.models.QuestionDataModel

class QuestionsLayoutContainer(
    private val binding: ActivityQuestionsBinding
) {
    private var questionList: ArrayList<QuestionDataModel> = arrayListOf()
    private var currentPosition: Int = 0
    private var selectedOption: Int? = null

    fun initView(characterSelected: CharacterModel) = with(binding) {
        questionList = QuestionsData.getQuestions()
        questionList.setAnswers()
    }

    private fun ArrayList<QuestionDataModel>.setAnswers() {
        val currentQuestion = this@setAnswers[currentPosition]

        binding.actQuestion.text = currentQuestion.question_text

        if (currentQuestion.answersAreImage) {
            setAnswersImage(currentQuestion)
        } else {
            setAnswersText(currentQuestion)
        }
    }

    private fun setAnswersImage(currentQuestion: QuestionDataModel) = with(binding) {
        answerOne.apply {
            setContentImage(currentQuestion.option_one_image)
            setOnClickListener {
                selectedOption = AnswerModel.ANSWER_ONE.index
                clearAnswersStyle()
                background = AppCompatResources.getDrawable(context, R.color.button_selected)
            }
        }

        answerTwo.apply {
            setContentImage(currentQuestion.option_two_image)
            setOnClickListener {
                selectedOption = AnswerModel.ANSWER_TWO.index
                clearAnswersStyle()
                background = AppCompatResources.getDrawable(context, R.color.button_selected)
            }
        }

        answerThree.apply {
            setContentImage(currentQuestion.option_three_image)
            setOnClickListener {
                selectedOption = AnswerModel.ANSWER_THREE.index
                clearAnswersStyle()
                background = AppCompatResources.getDrawable(context, R.color.button_selected)
            }
        }

        answerFour.apply {
            setContentImage(currentQuestion.option_four_image)
            setOnClickListener {
                selectedOption = AnswerModel.ANSWER_FOUR.index
                clearAnswersStyle()
                background = AppCompatResources.getDrawable(context, R.color.button_selected)
            }
        }
    }

    private fun setAnswersText(currentQuestion: QuestionDataModel) = with(binding) {
        answerOne.apply {
            setContentText(currentQuestion.option_one_text)
            setOnClickListener {
                selectedOption = AnswerModel.ANSWER_ONE.index
                clearAnswersStyle()
                background = AppCompatResources.getDrawable(context, R.color.button_selected)
            }
        }

        answerTwo.apply {
            setContentText(currentQuestion.option_two_text)
            setOnClickListener {
                selectedOption = AnswerModel.ANSWER_TWO.index
                clearAnswersStyle()
                background = AppCompatResources.getDrawable(context, R.color.button_selected)
            }
        }

        answerThree.apply {
            setContentText(currentQuestion.option_three_text)
            setOnClickListener {
                selectedOption = AnswerModel.ANSWER_THREE.index
                clearAnswersStyle()
                background = AppCompatResources.getDrawable(context, R.color.button_selected)
            }
        }

        answerFour.apply {
            setContentText(currentQuestion.option_four_text)
            setOnClickListener {
                selectedOption = AnswerModel.ANSWER_FOUR.index
                clearAnswersStyle()
                background = AppCompatResources.getDrawable(context, R.color.button_selected)
            }
        }
    }

    private fun clearAnswersStyle() = with(binding) {
        answerOne.apply {
            background = AppCompatResources.getDrawable(context, R.color.button_default)
        }

        answerTwo.apply {
            background = AppCompatResources.getDrawable(context, R.color.button_default)
        }

        answerThree.apply {
            background = AppCompatResources.getDrawable(context, R.color.button_default)
        }

        answerFour.apply {
            background = AppCompatResources.getDrawable(context, R.color.button_default)
        }
    }
}