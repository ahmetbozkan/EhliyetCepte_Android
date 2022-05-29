package com.ahmetbozkan.ehliyetcepte.domain.usecase.trafficsigns

import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.TrafficSign
import com.ahmetbozkan.ehliyetcepte.data.repository.usefultopics.UsefulTopicsDbCallbackRepository
import javax.inject.Inject

class GetParsedTrafficSignListUseCase @Inject constructor(
    private val repository: UsefulTopicsDbCallbackRepository
) {

    val trafficSigns = invoke()

    private operator fun invoke(): List<TrafficSign> =
        repository.getTrafficSignEntities()

}