package com.ahmetbozkan.ehliyetcepte.data.repository.usefultopics

import com.ahmetbozkan.ehliyetcepte.data.model.vehiclegauges.VehicleGauge

interface UsefulTopicsDbCallbackRepository {

    /**
     * get VehicleGauges as entity classes from vehicle_gauges.json file to insert Room db
     */
    fun getVehicleGaugesEntities(): List<VehicleGauge>

}