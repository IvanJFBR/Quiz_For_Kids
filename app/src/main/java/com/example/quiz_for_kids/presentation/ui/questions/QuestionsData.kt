package com.example.quiz_for_kids.presentation.ui.questions

import android.os.Parcelable
import com.example.quiz_for_kids.R
import com.example.quiz_for_kids.presentation.models.AnswerModel
import com.example.quiz_for_kids.presentation.models.QuestionDataModel
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
object QuestionsData : Parcelable {

    @IgnoredOnParcel
    var score: Int = 0

    fun getQuestions(): ArrayList<QuestionDataModel> {
        val que: ArrayList<QuestionDataModel> = arrayListOf()

        val question1 = QuestionDataModel(
            1,
            question_text = "Escolha o nome com o maior número de letras",

            answersAreImage = false,
            option_one_text = "Paulo",
            option_two_text = "Ana",
            option_three_text = "Alexandre",
            option_four_text = "Milena",
            correct_ans = AnswerModel.ANSWER_THREE
        )
        val question2 = QuestionDataModel(
            1,
            question_text = "Selecione o nome que não tem a letra B",

            option_one_text = "Bia",
            option_two_text = "Beatriz",
            option_three_text = "Barbara",
            option_four_text = "Alice",
            correct_ans = AnswerModel.ANSWER_FOUR
        )
        val question3 = QuestionDataModel(
            1,
            question_text = "João tinha comprou 4 (quatro) maças e deu 1 (uma) para seu professor. \n\nSelecione a imagem que representa quantas maças João ficou",

            answersAreImage = true,
            option_one_image = R.drawable.three_apples,
            option_two_image = R.drawable.two_apples,
            option_three_image = R.drawable.one_apple,
            option_four_image = R.drawable.four_apples,
            correct_ans = AnswerModel.ANSWER_ONE
        )
        val question4 = QuestionDataModel(
            1,
            question_text = "Ajude Sofia a ajustar seu relógio para 5 (cinco) horas. \n\nEscolha o relógio que representa o horário que Sofia deseja ajustar",
            question_image = R.drawable.empty_clock,

            answersAreImage = true,
            option_one_image = R.drawable.clock_two_hours,
            option_two_image = R.drawable.clock_five_hours,
            option_three_image = R.drawable.clock_four_hours,
            option_four_image = R.drawable.clock_ten_hours,
            correct_ans = AnswerModel.ANSWER_TWO
        )

        val question5 = QuestionDataModel(
            1,
            question_text = "Observer as notas a baixo e escolha a opção que represente a soma delas",
            question_image = R.drawable.real_notes,

            option_one_text = "R$ 7,00",
            option_two_text = "R$ 10,00",
            option_three_text = "R$ 12,00",
            option_four_text = "R$ 15,00",
            correct_ans = AnswerModel.ANSWER_THREE
        )

        que.add(question1)
        que.add(question2)
        que.add(question3)
        que.add(question4)
        que.add(question5)
        return que
    }
}