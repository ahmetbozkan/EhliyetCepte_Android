package com.ahmetbozkan.ehliyetcepte.data.model.exam

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "questions")
data class Question(
    @ColumnInfo(name = "question_id")
    @PrimaryKey(autoGenerate = true)
    val questionId: Long,
    @ColumnInfo(name = "parent_exam_id")
    val examId: Long,
    val question: String,
    @ColumnInfo(name = "question_image_url")
    @SerializedName(value = "question_image_url")
    val imageUrl: String,
    @ColumnInfo(name = "correct_option")
    @SerializedName(value = "correct_option")
    val correctOption: Options
)