package com.ahmetbozkan.ehliyetcepte.domain.usecase

import com.ahmetbozkan.ehliyetcepte.data.model.exam.WrongQuestion
import com.ahmetbozkan.ehliyetcepte.data.repository.question.QuestionRepository
import javax.inject.Inject

class InsertWrongQuestionsUseCase @Inject constructor(
    private val repository: QuestionRepository
) {

    suspend operator fun invoke(question: WrongQuestion) {
        repository.insert(question)
    }

    suspend operator fun invoke(questions: List<WrongQuestion>) {
        repository.insert(questions)
    }

}