package com.ahmetbozkan.ehliyetcepte.domain.usecase.exam

import com.ahmetbozkan.ehliyetcepte.data.model.exam.Question
import com.ahmetbozkan.ehliyetcepte.data.repository.exam.ExamRepository
import javax.inject.Inject

class UpdateQuestionUseCase @Inject constructor(
    private val repository: ExamRepository
) {

    suspend operator fun invoke(question: Question) {
        repository.update(question)
    }

}