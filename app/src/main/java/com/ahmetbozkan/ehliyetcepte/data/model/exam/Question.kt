package com.ahmetbozkan.ehliyetcepte.data.model.exam

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "questions")
data class Question(
    @PrimaryKey(autoGenerate = true)
    val questionId: Long,
    val parentExamId: Long,
    val question: String,
    @SerializedName(value = "question_image_url")
    val imageUrl: String,
    @SerializedName(value = "correct_option")
    val correctOption: Options
)