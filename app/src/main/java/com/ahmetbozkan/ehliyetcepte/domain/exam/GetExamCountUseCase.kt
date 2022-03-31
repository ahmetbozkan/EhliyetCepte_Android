package com.ahmetbozkan.ehliyetcepte.domain.exam

import com.ahmetbozkan.ehliyetcepte.data.repository.exam.ExamRepository
import javax.inject.Inject

class GetExamCountUseCase @Inject constructor(
    private val repository: ExamRepository
) {

    operator fun invoke() = repository.getExamCount()

}