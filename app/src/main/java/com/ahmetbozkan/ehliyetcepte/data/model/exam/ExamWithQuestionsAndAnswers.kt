package com.ahmetbozkan.ehliyetcepte.data.model.exam

import androidx.room.Embedded
import androidx.room.Relation


data class ExamWithQuestionsAndAnswers(
    @Embedded val exam: Exam,
    @Relation(
        entity = Question::class,
        parentColumn = "exam_id",
        entityColumn = "parent_exam_id"
    )
    val answers: List<QuestionWithAnswers>
)
