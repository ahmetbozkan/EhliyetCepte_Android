package com.ahmetbozkan.ehliyetcepte.data.model.exam

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation

data class QuestionWithAnswers(
    @Embedded val question: Question,
    @Relation(
        parentColumn = "question_id",
        entityColumn = "answer_id",
        associateBy = Junction(QuestionAnswerCrossRef::class)
    )
    val answers: List<Answer>
)

@Entity(primaryKeys = ["question_id", "answer_id"])
data class QuestionAnswerCrossRef(
    val questionId: Long,
    val answerId: Long
)
