package com.ahmetbozkan.ehliyetcepte.domain.usecase.vehiclegauges

import androidx.lifecycle.LiveData
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.VehicleGauge
import com.ahmetbozkan.ehliyetcepte.data.repository.usefultopics.UsefulTopicsRepository
import javax.inject.Inject

class GetAllVehicleGaugesUseCase @Inject constructor(
    private val repository: UsefulTopicsRepository
) {

    operator fun invoke(): LiveData<List<VehicleGauge>> = repository.getAllVehicleGauges()

}