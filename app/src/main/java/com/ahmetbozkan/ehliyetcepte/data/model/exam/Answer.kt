package com.ahmetbozkan.ehliyetcepte.data.model.exam

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Answer(
    val option: Options,
    val optionFull: String
) : Parcelable
