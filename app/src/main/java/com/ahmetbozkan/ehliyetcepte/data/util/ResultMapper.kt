package com.ahmetbozkan.ehliyetcepte.data.util

import com.ahmetbozkan.ehliyetcepte.data.model.result.Result
import com.ahmetbozkan.ehliyetcepte.domain.util.EntityMapper
import com.ahmetbozkan.ehliyetcepte.ui.result.SolvedExamEntity
import javax.inject.Inject

class ResultMapper @Inject constructor() : EntityMapper<SolvedExamEntity, Result> {

    private var correct = 0
    private var wrong = 0
    private var score = 0

    override fun map(from: SolvedExamEntity): Result {
        val exam = from.examWithQuestions.exam
        calculateResult(from)

        return Result(
            parentExamId = exam.examId,
            correct = correct,
            wrong = wrong,
            score = score
        )
    }

    private fun calculateResult(from: SolvedExamEntity) {
        val questions = from.examWithQuestions.questions
        val answers = from.answers
        val scoreByCorrect = 100 / questions.size

        questions.forEach { question ->
            val answer = answers[question.questionId]

            if (answer != null && answer == question.correctOption) {
                correct += 1
                score += scoreByCorrect
            } else wrong += 1
        }
    }

}