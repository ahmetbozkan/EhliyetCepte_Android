package com.ahmetbozkan.ehliyetcepte.domain.exam

import com.ahmetbozkan.ehliyetcepte.data.model.exam.Question
import com.ahmetbozkan.ehliyetcepte.data.repository.exam.ExamDbCallbackRepository
import javax.inject.Inject

class GetParsedQuestionListUseCase @Inject constructor(
    private val repository: ExamDbCallbackRepository
) {
    val questions = invoke()
    private operator fun invoke(): List<Question> = repository.getQuestionEntities()
}