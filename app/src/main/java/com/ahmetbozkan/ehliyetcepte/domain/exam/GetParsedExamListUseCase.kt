package com.ahmetbozkan.ehliyetcepte.domain.exam

import com.ahmetbozkan.ehliyetcepte.data.model.exam.Exam
import com.ahmetbozkan.ehliyetcepte.data.repository.exam.ExamDbCallbackRepository
import javax.inject.Inject

class GetParsedExamListUseCase @Inject constructor(
    private val repository: ExamDbCallbackRepository
) {
    val exams = invoke()
    private operator fun invoke(): List<Exam> = repository.getExamEntities()
}