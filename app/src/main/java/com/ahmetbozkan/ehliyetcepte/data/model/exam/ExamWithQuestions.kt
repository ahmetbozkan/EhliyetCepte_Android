package com.ahmetbozkan.ehliyetcepte.data.model.exam

import androidx.room.Embedded
import androidx.room.Relation

data class ExamWithQuestions(
    @Embedded val exam: Exam,
    @Relation(
        parentColumn = "exam_id",
        entityColumn = "parent_exam_id"
    )
    val answers: List<Question>
)
