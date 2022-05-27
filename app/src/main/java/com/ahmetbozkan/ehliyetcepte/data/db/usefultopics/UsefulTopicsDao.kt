package com.ahmetbozkan.ehliyetcepte.data.db.usefultopics

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ahmetbozkan.ehliyetcepte.data.model.vehiclegauges.VehicleGauge

@Dao
interface UsefulTopicsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vehicleGauge: VehicleGauge)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg vehicleGauge: VehicleGauge)

    @Transaction
    @Query("SELECT * FROM vehicle_gauges")
    fun getAllVehicleGauges(): LiveData<List<VehicleGauge>>
}