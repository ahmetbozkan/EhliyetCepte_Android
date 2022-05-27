package com.ahmetbozkan.ehliyetcepte.data.db.usefultopics

import androidx.room.Insert
import com.ahmetbozkan.ehliyetcepte.data.model.vehiclegauges.VehicleGauge

interface UsefulTopicsDao {

    @Insert
    suspend fun insert(vehicleGauge: VehicleGauge)

    @Insert
    suspend fun insert(vararg vehicleGauge: VehicleGauge)
}