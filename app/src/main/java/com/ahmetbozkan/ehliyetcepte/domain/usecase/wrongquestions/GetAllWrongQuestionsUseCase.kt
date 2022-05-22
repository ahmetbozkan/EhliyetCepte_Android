package com.ahmetbozkan.ehliyetcepte.domain.usecase.wrongquestions

import com.ahmetbozkan.ehliyetcepte.data.repository.question.QuestionRepositoryImpl
import javax.inject.Inject

class GetAllWrongQuestionsUseCase @Inject constructor(
    private val repository: QuestionRepositoryImpl
) {

    suspend operator fun invoke() =
        repository.getAllWrongQuestions()

}