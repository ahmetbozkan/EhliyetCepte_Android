package com.ahmetbozkan.ehliyetcepte.domain.usecase.result

import com.ahmetbozkan.ehliyetcepte.data.model.result.Result
import com.ahmetbozkan.ehliyetcepte.data.repository.exam.ExamRepository
import com.ahmetbozkan.ehliyetcepte.data.repository.result.ResultRepository
import javax.inject.Inject

class InsertResultUseCase @Inject constructor(
    private val repository: ResultRepository
) {

    suspend operator fun invoke(result: Result) {
        repository.insert(result)
    }

}