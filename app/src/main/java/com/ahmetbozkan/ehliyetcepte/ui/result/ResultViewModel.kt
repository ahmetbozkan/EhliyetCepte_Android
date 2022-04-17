package com.ahmetbozkan.ehliyetcepte.ui.result

import com.ahmetbozkan.ehliyetcepte.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(

) : BaseViewModel() {

    fun calculateResult(solvedExamEntity: SolvedExamEntity) {
        val questions = solvedExamEntity.examWithQuestions.questions
        val answers = solvedExamEntity.answers

        questions.forEach { question ->
            answers[question.questionId]
        }
    }

}