package com.ahmetbozkan.ehliyetcepte.domain.usecase.trafficfines

import com.ahmetbozkan.ehliyetcepte.data.repository.usefultopics.UsefulTopicsDbCallbackRepository
import javax.inject.Inject

class GetParsedTrafficFineListUseCase @Inject constructor(
    private val repository: UsefulTopicsDbCallbackRepository
) {

    val trafficFines = invoke()

    private operator fun invoke() = repository.getTrafficFines()

}