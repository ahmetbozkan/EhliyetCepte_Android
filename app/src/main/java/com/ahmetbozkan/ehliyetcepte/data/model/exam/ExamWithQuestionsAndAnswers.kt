package com.ahmetbozkan.ehliyetcepte.data.model.exam

import androidx.room.Embedded
import androidx.room.Relation

data class ExamWithQuestionsAndAnswers(
    @Embedded val exam: Exam,
    @Relation(
        entity = Question::class,
        parentColumn = "examId",
        entityColumn = "parentExamId"
    )
    val answers: List<QuestionWithAnswers>
)
