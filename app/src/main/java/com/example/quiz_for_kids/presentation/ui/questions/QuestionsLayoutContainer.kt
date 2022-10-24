package com.example.quiz_for_kids.presentation.ui.questions

import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quiz_for_kids.R
import com.example.quiz_for_kids.databinding.ActivityQuestionsBinding
import com.example.quiz_for_kids.presentation.commons.components.AnswerButtonView
import com.example.quiz_for_kids.presentation.extensions.gone
import com.example.quiz_for_kids.presentation.extensions.startWithTransaction
import com.example.quiz_for_kids.presentation.extensions.visible
import com.example.quiz_for_kids.presentation.models.AnswerModel
import com.example.quiz_for_kids.presentation.models.QuestionDataModel
import com.example.quiz_for_kids.presentation.ui.result.ResultActivity

class QuestionsLayoutContainer(
    private val activity: QuestionsActivity,
    private val binding: ActivityQuestionsBinding,
    private val characterSelected: Int
) {
    private val _selectedState = MutableLiveData<AnswerModel?>()
    private val selectedState: LiveData<AnswerModel?> get() = _selectedState

    private val _currentPosition = MutableLiveData<Int>()
    private val currentPosition: LiveData<Int> get() = _currentPosition

    private var questionList: ArrayList<QuestionDataModel> = arrayListOf()
    private val questionsData = QuestionsData

    private var currentQuestion: QuestionDataModel = questionsData.getQuestions()[0]

    fun initView() = with(binding) {
        _currentPosition.value = 0
        questionList = questionsData.getQuestions()
        questionList.setAnswers()
    }

    private fun ArrayList<QuestionDataModel>.setAnswers() = with(binding) {
        currentPosition.observe(activity) {
            currentQuestion = this@setAnswers[it]
        }

        actQuestion.text = currentQuestion.question_text

        if (currentQuestion.answersAreImage) {
            setAnswersImage(currentQuestion)
        } else {
            setAnswersText(currentQuestion)
        }

        selectedState.observe(activity) { selectedAnswer ->
            submitAnswer.apply {
                visible()
                setOnClickListener {
                    if (currentQuestion.correct_ans == selectedAnswer) {
                        setAnswerColor(false, selectedAnswer)
                        questionsData.score++
                    } else {
                        setAnswerColor(true, selectedAnswer)
                    }
                    gone()
                    nextQuestion.visible()
                }
            }

            nextQuestion.setOnClickListener {
                if (_currentPosition.value!! < this@setAnswers.size - 1) {
                    _currentPosition.value = _currentPosition.value?.plus(1)
                    clearAnswersStyle()
                } else {
                    val intent = ResultActivity.newIntent(activity, characterSelected)
                    activity.startWithTransaction(intent)
                }
            }
        }
    }

    private fun setAnswersImage(currentQuestion: QuestionDataModel) = with(binding) {
        answerOne.apply {
            setContentImage(currentQuestion.option_one_image)
            setOnClickListener {
                clearAnswersStyle()
                _selectedState.value = AnswerModel.ANSWER_ONE
                background = AppCompatResources.getDrawable(context, R.color.button_selected)
            }
        }

        answerTwo.apply {
            setContentImage(currentQuestion.option_two_image)
            setOnClickListener {
                clearAnswersStyle()
                _selectedState.value = AnswerModel.ANSWER_TWO
                background = AppCompatResources.getDrawable(context, R.color.button_selected)
            }
        }

        answerThree.apply {
            setContentImage(currentQuestion.option_three_image)
            setOnClickListener {
                clearAnswersStyle()
                _selectedState.value = AnswerModel.ANSWER_THREE
                background = AppCompatResources.getDrawable(context, R.color.button_selected)
            }
        }

        answerFour.apply {
            setContentImage(currentQuestion.option_four_image)
            setOnClickListener {
                clearAnswersStyle()
                _selectedState.value = AnswerModel.ANSWER_FOUR
                background = AppCompatResources.getDrawable(context, R.color.button_selected)
            }
        }
    }

    private fun setAnswersText(currentQuestion: QuestionDataModel) = with(binding) {
        answerOne.apply {
            setContentText(currentQuestion.option_one_text)
            setOnClickListener {
                clearAnswersStyle()
                _selectedState.value = AnswerModel.ANSWER_ONE
                background = AppCompatResources.getDrawable(context, R.color.button_selected)
            }
        }

        answerTwo.apply {
            setContentText(currentQuestion.option_two_text)
            setOnClickListener {
                clearAnswersStyle()
                _selectedState.value = AnswerModel.ANSWER_TWO
                background = AppCompatResources.getDrawable(context, R.color.button_selected)
            }
        }

        answerThree.apply {
            setContentText(currentQuestion.option_three_text)
            setOnClickListener {
                clearAnswersStyle()
                _selectedState.value = AnswerModel.ANSWER_THREE
                background = AppCompatResources.getDrawable(context, R.color.button_selected)
            }
        }

        answerFour.apply {
            setContentText(currentQuestion.option_four_text)
            setOnClickListener {
                clearAnswersStyle()
                _selectedState.value = AnswerModel.ANSWER_FOUR
                background = AppCompatResources.getDrawable(context, R.color.button_selected)
            }
        }
    }

    private fun setAnswerColor(isError: Boolean, answer: AnswerModel?) = with(binding) {
        when (answer) {
            AnswerModel.ANSWER_ONE -> answerOne.apply {
                background = getAnswerColor(isError)
            }

            AnswerModel.ANSWER_TWO -> answerTwo.apply {
                background = getAnswerColor(isError)
            }

            AnswerModel.ANSWER_THREE -> answerThree.apply {
                background = getAnswerColor(isError)
            }

            AnswerModel.ANSWER_FOUR -> answerFour.apply {
                background = getAnswerColor(isError)
            }

            else -> {}
        }
    }

    private fun AnswerButtonView.getAnswerColor(isError: Boolean) = if (isError) {
        AppCompatResources.getDrawable(context, R.color.button_error)
    } else {
        AppCompatResources.getDrawable(context, R.color.button_correct)
    }

    private fun clearAnswersStyle() = with(binding) {
        _selectedState.value = null
        nextQuestion.gone()

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