package com.ahmetbozkan.ehliyetcepte.data.util

import com.ahmetbozkan.ehliyetcepte.data.model.result.Result
import com.ahmetbozkan.ehliyetcepte.domain.util.EntityMapper
import com.ahmetbozkan.ehliyetcepte.ui.result.SolvedExamEntity
import com.ahmetbozkan.ehliyetcepte.util.Constants.HOUR_AS_MINUTE_MILLIS
import com.ahmetbozkan.ehliyetcepte.util.Constants.MINUTE_AS_SECOND_MILLIS
import com.ahmetbozkan.ehliyetcepte.util.Constants.SECOND_AS_MILLIS
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
            score = score,
            duration = getDuration(from)
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

    private fun getDuration(from: SolvedExamEntity): String {
        val exam = from.examWithQuestions.exam

        val timeElapsed = exam.duration

        val hours = (timeElapsed / HOUR_AS_MINUTE_MILLIS).toInt()
        val minutes =
            (timeElapsed - hours * HOUR_AS_MINUTE_MILLIS).toInt() / MINUTE_AS_SECOND_MILLIS
        val seconds =
            (timeElapsed - hours * HOUR_AS_MINUTE_MILLIS - minutes * MINUTE_AS_SECOND_MILLIS).toInt() / SECOND_AS_MILLIS

        return String.format("%02d:%02d", minutes, seconds)
    }
}