package com.ahmetbozkan.ehliyetcepte.data.model.exam

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Relation
import kotlinx.parcelize.Parcelize

@Parcelize
data class ExamWithQuestions(
    @Embedded val exam: Exam,
    @Relation(
        parentColumn = "exam_id",
        entityColumn = "parent_exam_id"
    )
    val questions: List<Question>
): Parcelable
