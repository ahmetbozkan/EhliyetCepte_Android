package com.ahmetbozkan.ehliyetcepte.domain.usecase.trafficfines

import com.ahmetbozkan.ehliyetcepte.core.Resource
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.TrafficFine
import com.ahmetbozkan.ehliyetcepte.data.repository.usefultopics.UsefulTopicsRepository
import javax.inject.Inject

class GetTrafficFinesUseCase @Inject constructor(
    private val repository: UsefulTopicsRepository
) {

    suspend operator fun invoke(): Resource<List<TrafficFine>> =
        repository.getTrafficFines()

}