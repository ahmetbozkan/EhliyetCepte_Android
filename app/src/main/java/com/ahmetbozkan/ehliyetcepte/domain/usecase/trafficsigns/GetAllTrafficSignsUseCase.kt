package com.ahmetbozkan.ehliyetcepte.domain.usecase.trafficsigns

import androidx.lifecycle.LiveData
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.TrafficSign
import com.ahmetbozkan.ehliyetcepte.data.repository.usefultopics.UsefulTopicsRepository
import javax.inject.Inject

class GetAllTrafficSignsUseCase @Inject constructor(
    private val repository: UsefulTopicsRepository
) {

    operator fun invoke(): LiveData<List<TrafficSign>> =
        repository.getAllTrafficSigns()

}