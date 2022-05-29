package com.ahmetbozkan.ehliyetcepte.data.repository.usefultopics

import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.TrafficSign
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.VehicleGauge

interface UsefulTopicsDbCallbackRepository {

    /**
     * get VehicleGauges as entity classes from vehicle_gauges.json file to insert Room db
     */
    fun getVehicleGaugesEntities(): List<VehicleGauge>

    /**
     * get TrafficSign as entity classes from traffic_sign.json file to insert Room db
     */
    fun getTrafficSignEntities(): List<TrafficSign>

}