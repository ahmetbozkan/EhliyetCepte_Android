package com.ahmetbozkan.ehliyetcepte.domain.usecase.cityplates

import com.ahmetbozkan.ehliyetcepte.core.Resource
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.CityPlate
import com.ahmetbozkan.ehliyetcepte.data.repository.usefultopics.UsefulTopicsRepository
import javax.inject.Inject

class GetAllCityPlatesUseCase @Inject constructor(
    private val repository: UsefulTopicsRepository
) {

    suspend operator fun invoke(): Resource<List<CityPlate>> = repository.getCityPlates()
}