package com.ahmetbozkan.ehliyetcepte.data.model.exam

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation

data class QuestionWithAnswers(
    @Embedded val question: Question,
    @Relation(
        parentColumn = "questionId",
        entityColumn = "answerId",
        associateBy = Junction(QuestionAnswerCrossRef::class)
    )
    val answers: List<Answer>
)

@Entity(primaryKeys = ["questionId", "answerId"])
data class QuestionAnswerCrossRef(
    val questionId: Long,
    val answerId: Long
)
