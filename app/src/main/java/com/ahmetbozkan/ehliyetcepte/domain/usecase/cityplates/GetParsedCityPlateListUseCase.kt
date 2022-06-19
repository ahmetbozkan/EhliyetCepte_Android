package com.ahmetbozkan.ehliyetcepte.domain.usecase.cityplates

import com.ahmetbozkan.ehliyetcepte.data.repository.usefultopics.UsefulTopicsDbCallbackRepository
import javax.inject.Inject

class GetParsedCityPlateListUseCase @Inject constructor(
    private val repository: UsefulTopicsDbCallbackRepository
) {

    val cityPlates = invoke()

    private operator fun invoke() = repository.getCityPlateEntities()

}