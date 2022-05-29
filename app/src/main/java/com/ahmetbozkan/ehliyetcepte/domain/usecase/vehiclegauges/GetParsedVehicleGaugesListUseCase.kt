package com.ahmetbozkan.ehliyetcepte.domain.usecase.vehiclegauges

import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.VehicleGauge
import com.ahmetbozkan.ehliyetcepte.data.repository.usefultopics.UsefulTopicsDbCallbackRepository
import javax.inject.Inject

class GetParsedVehicleGaugesListUseCase @Inject constructor(
    private val repository: UsefulTopicsDbCallbackRepository
) {

    val vehicleGauges = invoke()

    private operator fun invoke(): List<VehicleGauge> =
        repository.getVehicleGaugesEntities()
}