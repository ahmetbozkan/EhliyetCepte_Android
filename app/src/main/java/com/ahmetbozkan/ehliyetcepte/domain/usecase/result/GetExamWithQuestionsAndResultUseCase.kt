package com.ahmetbozkan.ehliyetcepte.domain.usecase.result

import com.ahmetbozkan.ehliyetcepte.data.repository.result.ResultRepository
import javax.inject.Inject

class GetExamWithQuestionsAndResultUseCase @Inject constructor(
    private val repository: ResultRepository
) {

    suspend operator fun invoke(examId: Long) =
        repository.getExamWithQuestionsAndResult(examId)

}