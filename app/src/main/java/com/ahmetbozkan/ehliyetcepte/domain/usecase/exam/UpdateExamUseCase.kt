package com.ahmetbozkan.ehliyetcepte.domain.usecase.exam

import com.ahmetbozkan.ehliyetcepte.data.model.exam.Exam
import com.ahmetbozkan.ehliyetcepte.data.repository.exam.ExamRepository
import javax.inject.Inject

class UpdateExamUseCase @Inject constructor(
    private val repository: ExamRepository
) {

    suspend operator fun invoke(exam: Exam) {
        repository.update(exam)
    }

}