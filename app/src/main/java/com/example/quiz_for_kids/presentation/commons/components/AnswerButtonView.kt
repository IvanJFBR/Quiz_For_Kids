package com.example.quiz_for_kids.presentation.commons.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.quiz_for_kids.databinding.AnswerButtonLayoutBinding
import com.example.quiz_for_kids.presentation.extensions.gone
import com.example.quiz_for_kids.presentation.extensions.visible

class AnswerButtonView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding: AnswerButtonLayoutBinding =
        AnswerButtonLayoutBinding.inflate(
            LayoutInflater.from(context), this, true
        )

    fun setContentImage(imageResource: Int?) = with(binding) {
        if (imageResource != null) {
            characterImage.setImageResource(imageResource)
            characterImage.visible()
        }
        characterText.gone()
    }

    fun setContentText(answerText: String?) = with(binding) {
        characterText.text = answerText ?: ""
        characterText.visible()
        characterImage.gone()
    }
}