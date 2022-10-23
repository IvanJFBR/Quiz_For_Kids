package com.example.quiz_for_kids.presentation.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class CharacterModel(val index: Int) : Parcelable {
    CHARACTER_ONE(0),
    CHARACTER_TWO(1),
    CHARACTER_THREE(2),
    CHARACTER_FOUR(3)
}