package com.ahmetbozkan.ehliyetcepte.data.util

import androidx.room.TypeConverter
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Answer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AnswerConverters {

    @TypeConverter
    fun fromAnswerList(answers: List<Answer>): String? {
        val type = object : TypeToken<List<Answer>>() {}.type

        return Gson().toJson(answers, type)
    }

    @TypeConverter
    fun toAnswerList(answers: String): List<Answer>? {
        val type = object : TypeToken<List<Answer>>() {}.type

        return Gson().fromJson(answers, type)
    }

}