package com.ahmetbozkan.ehliyetcepte.domain.usecase.result

import com.ahmetbozkan.ehliyetcepte.data.repository.result.ResultRepository
import com.ahmetbozkan.ehliyetcepte.ui.result.SolvedExamEntity
import javax.inject.Inject

class CalculateResultUseCase @Inject constructor(
    private val repository: ResultRepository
) {

    operator fun invoke(solvedExam: SolvedExamEntity) =
        repository.mapSolvedExam(exam = solvedExam)

}