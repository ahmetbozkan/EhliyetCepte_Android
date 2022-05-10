package com.ahmetbozkan.ehliyetcepte.data.model.result

import androidx.room.Embedded
import androidx.room.Relation
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Exam
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Question

data class ExamWithQuestionsAndResult(
    @Embedded val exam: Exam,
    @Relation(
        parentColumn = "exam_id",
        entityColumn = "parent_exam_id"
    )
    val questions: List<Question>,
    @Relation(
        parentColumn = "exam_id",
        entityColumn = "parent_exam_id"
    )
    val result: Result?
)