package com.ahmetbozkan.ehliyetcepte.domain.exam

import com.ahmetbozkan.ehliyetcepte.data.repository.exam.ExamRepository
import javax.inject.Inject

class GetExamWithQuestionsUseCase @Inject constructor(
    private val repository: ExamRepository
) {

     suspend operator fun invoke(examId: Long) =
        repository.getExamWithQuestions(examId)

}