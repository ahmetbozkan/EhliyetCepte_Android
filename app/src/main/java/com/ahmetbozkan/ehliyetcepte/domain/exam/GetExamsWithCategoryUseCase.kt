package com.ahmetbozkan.ehliyetcepte.domain.exam

import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamCategories
import com.ahmetbozkan.ehliyetcepte.data.repository.exam.ExamRepository
import javax.inject.Inject

class GetExamsWithCategoryUseCase @Inject constructor(
    private val repository: ExamRepository
) {

    operator fun invoke(category: ExamCategories) =
        repository.getExamsWithCategory(category)

}