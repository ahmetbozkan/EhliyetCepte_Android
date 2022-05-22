package com.ahmetbozkan.ehliyetcepte.data.model.exam

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wrong_questions")
data class WrongQuestion(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "question_id") val questionId: Long = 0,
    @ColumnInfo(name = "question") val question: String,
    @ColumnInfo(name = "image_url") val imageUrl: String,
    @ColumnInfo(name = "correct_option") val correctOption: Options,
    @ColumnInfo(name = "answers") val answers: List<Answer>
)