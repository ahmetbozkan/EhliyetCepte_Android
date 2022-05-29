package com.ahmetbozkan.ehliyetcepte.data.repository.usefultopics

import androidx.lifecycle.LiveData
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.TrafficSign
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.VehicleGauge

interface UsefulTopicsRepository {

    /**
     * get all the vehicle gauges
     * @return list of VehicleGauge object wrapped in livedata
     */
    fun getAllVehicleGauges(): LiveData<List<VehicleGauge>>

    /**
     * get all the traffic signs from the UsefulTopicsDb
     * @return list of TrafficSign object wrapped in livedata
     */
    fun getAllTrafficSigns(): LiveData<List<TrafficSign>>

}