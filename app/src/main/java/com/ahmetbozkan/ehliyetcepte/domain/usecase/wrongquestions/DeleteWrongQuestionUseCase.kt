package com.ahmetbozkan.ehliyetcepte.domain.usecase.wrongquestions

import com.ahmetbozkan.ehliyetcepte.data.model.exam.WrongQuestion
import com.ahmetbozkan.ehliyetcepte.data.repository.question.QuestionRepository
import javax.inject.Inject

class DeleteWrongQuestionUseCase @Inject constructor(
    private val repository: QuestionRepository
) {

    suspend operator fun invoke(question: WrongQuestion) {
        repository.delete(question)
    }

}