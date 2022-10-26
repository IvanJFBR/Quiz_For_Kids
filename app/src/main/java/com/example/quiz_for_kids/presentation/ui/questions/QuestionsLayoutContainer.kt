package com.example.quiz_for_kids.presentation.ui.questions

import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quiz_for_kids.R
import com.example.quiz_for_kids.databinding.ActivityQuestionsBinding
import com.example.quiz_for_kids.presentation.commons.components.AnswerButtonView
import com.example.quiz_for_kids.presentation.extensions.gone
import com.example.quiz_for_kids.presentation.extensions.invisible
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

    private var currentQuestion: QuestionDataModel = QuestionsData.getQuestions()[0]

    fun initView() = with(binding) {
        _currentPosition.value = 0
        questionList = QuestionsData.getQuestions()
        questionList.setAnswers()
    }

    private fun ArrayList<QuestionDataModel>.setAnswers() = with(binding) {
        currentPosition.observe(activity) {
            currentQuestion = this@setAnswers[it]
            setCurrentQuestion()
        }

        selectedState.observe(activity) { selectedAnswer ->
            submitAnswer.apply {
                if(_selectedState.value == null) {
                    invisible()
                } else {
                    visible()
                }
                setOnClickListener {
                    if (currentQuestion.correct_ans == selectedAnswer) {
                        setAnswerColor(false, selectedAnswer)
                    } else {
                        setAnswerColor(true, selectedAnswer)
                    }
                    invisible()
                    nextQuestion.visible()
                }
            }

            nextQuestion.setOnClickListener {
                if (currentQuestion.correct_ans == selectedAnswer) {
                    QuestionsData.score++
                }
                if (_currentPosition.value!! < this@setAnswers.size - 1) {
                    _currentPosition.value = _currentPosition.value?.plus(1)
                    clearAnswersStyle()
                } else {
                    val intent = ResultActivity.newIntent(
                        activity,
                        characterSelected
                    )
                    activity.startWithTransaction(intent)
                }
            }
        }
    }

    private fun setCurrentQuestion() = with(binding) {
        binding.actQuestion.text = currentQuestion.question_text

        if (currentQuestion.question_image == null) {
            questionImage.gone()
        } else {
            currentQuestion.question_image?.let {
                questionImage.setImageResource(it)
                questionImage.visible()
            }
        }

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
                clearAnswersStyle()
                _selectedState.value = AnswerModel.ANSWER_ONE
                isSelected = true
            }
        }

        answerTwo.apply {
            setContentImage(currentQuestion.option_two_image)
            setOnClickListener {
                clearAnswersStyle()
                _selectedState.value = AnswerModel.ANSWER_TWO
                isSelected = true
            }
        }

        answerThree.apply {
            setContentImage(currentQuestion.option_three_image)
            setOnClickListener {
                clearAnswersStyle()
                _selectedState.value = AnswerModel.ANSWER_THREE
                isSelected = true
            }
        }

        answerFour.apply {
            setContentImage(currentQuestion.option_four_image)
            setOnClickListener {
                clearAnswersStyle()
                _selectedState.value = AnswerModel.ANSWER_FOUR
                isSelected = true
            }
        }
    }

    private fun setAnswersText(currentQuestion: QuestionDataModel) = with(binding) {
        answerOne.apply {
            setContentText(currentQuestion.option_one_text)
            setOnClickListener {
                clearAnswersStyle()
                _selectedState.value = AnswerModel.ANSWER_ONE
                isSelected = true
            }
        }

        answerTwo.apply {
            setContentText(currentQuestion.option_two_text)
            setOnClickListener {
                clearAnswersStyle()
                _selectedState.value = AnswerModel.ANSWER_TWO
                isSelected = true
            }
        }

        answerThree.apply {
            setContentText(currentQuestion.option_three_text)
            setOnClickListener {
                clearAnswersStyle()
                _selectedState.value = AnswerModel.ANSWER_THREE
                isSelected = true
            }
        }

        answerFour.apply {
            setContentText(currentQuestion.option_four_text)
            setOnClickListener {
                clearAnswersStyle()
                _selectedState.value = AnswerModel.ANSWER_FOUR
                isSelected = true
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
        AppCompatResources.getDrawable(context, R.drawable.answer_button_error)
    } else {
        AppCompatResources.getDrawable(context, R.drawable.answer_button_correct)
    }

    private fun clearAnswersStyle() = with(binding) {
        _selectedState.value = null
        nextQuestion.gone()

        answerOne.apply {
            background = AppCompatResources.getDrawable(context, R.drawable.answer_top_left_button_selector)
            isSelected = false
        }

        answerTwo.apply {
            background = AppCompatResources.getDrawable(context, R.drawable.answer_top_right_button_selector)
            isSelected = false
        }

        answerThree.apply {
            background = AppCompatResources.getDrawable(context, R.drawable.answer_bottom_left_button_selector)
            isSelected = false
        }

        answerFour.apply {
            background = AppCompatResources.getDrawable(context, R.drawable.answer_bottom_right_button_selector)
            isSelected = false
        }
    }
}