package com.ahmetbozkan.ehliyetcepte.domain.usecase.result

import com.ahmetbozkan.ehliyetcepte.data.repository.result.ResultRepository
import javax.inject.Inject

class GetAllResultsUseCase @Inject constructor(
    private val repository: ResultRepository
) {

    operator fun invoke() =
        repository.getAllResults()

}