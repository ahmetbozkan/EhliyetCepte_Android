package com.ahmetbozkan.ehliyetcepte.data.repository.usefultopics

import androidx.lifecycle.LiveData
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.VehicleGauge

interface UsefulTopicsRepository {

    /**
     * get all the vehicle gauges
     * @return list of VehicleGauge object wrapped in livedata
     */
    fun getAllVehicleGauges(): LiveData<List<VehicleGauge>>

}