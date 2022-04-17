package com.ahmetbozkan.ehliyetcepte.domain.usecase.exam

import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamCategories
import com.ahmetbozkan.ehliyetcepte.data.repository.exam.ExamRepository
import javax.inject.Inject

class GetExamsUseCase @Inject constructor(
    private val repository: ExamRepository
) {

    suspend operator fun invoke(category: ExamCategories) =
        repository.getExams(category)

}