package com.example.quiz_for_kids.presentation.ui.questions

import com.example.quiz_for_kids.R
import com.example.quiz_for_kids.presentation.models.QuestionDataModel

object QuestionsData {

    const val name:String="name"
    const val score:String="score"

   fun getQuestions():ArrayList<QuestionDataModel>{
       val que:ArrayList<QuestionDataModel> = arrayListOf()

       val question1 = QuestionDataModel(
           1,
           question_text = "Escolha o nome com o maior número de letras",

           answersAreImage = true,
           option_one_image = R.drawable.boy_character_one,
           option_two_image = R.drawable.boy_character_one,
           option_three_image = R.drawable.boy_character_one,
           option_four_image = R.drawable.boy_character_one,
           correct_ans = 3
       )
       val question2 = QuestionDataModel(
           1,
           question_text = "Escolha o balão com o maior número de letras",

           option_one_text = "Paulo",
           option_two_text = "Ana",
           option_three_text = "Alexandre",
           option_four_text = "Milena",
           correct_ans = 3
       )
       val question3 = QuestionDataModel(
           1,
           question_text = "Escolha o balão com o maior número de letras",

           option_one_text = "Paulo",
           option_two_text = "Ana",
           option_three_text = "Alexandre",
           option_four_text = "Milena",
           correct_ans = 3
       )
       val question4 = QuestionDataModel(
           1,
           question_text = "Escolha o balão com o maior número de letras",

           option_one_text = "Paulo",
           option_two_text = "Ana",
           option_three_text = "Alexandre",
           option_four_text = "Milena",
           correct_ans = 3
       )

       val question5 = QuestionDataModel(
           1,
           question_text = "Escolha o balão com o maior número de letras",

           option_one_text = "Paulo",
           option_two_text = "Ana",
           option_three_text = "Alexandre",
           option_four_text = "Milena",
           correct_ans = 3
       )

       que.add(question1)
       que.add(question2)
       que.add(question3)
       que.add(question4)
       que.add(question5)
       return que
   }
}