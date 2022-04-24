package com.ahmetbozkan.ehliyetcepte.data.model.exam

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "questions")
data class Question(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "question_id") val questionId: Long = 0,
    @ColumnInfo(name = "parent_exam_id") val parentExamId: Long,
    @ColumnInfo(name = "question") val question: String,
    @ColumnInfo(name = "image_url") val imageUrl: String,
    @ColumnInfo(name = "correct_option") val correctOption: Options,
    @ColumnInfo(name = "selected_option") var selectedOption: Options = Options.NONE,
    @ColumnInfo(name = "answers") val answers: List<Answer>
) : Parcelable