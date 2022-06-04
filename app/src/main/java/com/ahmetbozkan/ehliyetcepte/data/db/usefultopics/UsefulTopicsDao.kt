package com.ahmetbozkan.ehliyetcepte.data.db.usefultopics

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.ExamTip
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.TrafficSign
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.VehicleGauge

@Dao
interface UsefulTopicsDao {

    /**
     * VEHICLE GAUGES
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vehicleGauge: VehicleGauge)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg vehicleGauge: VehicleGauge)

    @Transaction
    @Query("SELECT * FROM vehicle_gauges")
    fun getAllVehicleGauges(): LiveData<List<VehicleGauge>>

    /**
     * TRAFFIC SIGNS
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(trafficSign: TrafficSign)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg trafficSign: TrafficSign)

    @Transaction
    @Query("SELECT * FROM traffic_signs")
    fun getAllTrafficSigns(): LiveData<List<TrafficSign>>

    /**
     * EXAM TIPS
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(examTip: ExamTip)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg examTip: ExamTip)

    @Transaction
    @Query("SELECT * FROM exam_tips WHERE _type = :type")
    suspend fun getExamTips(type: Int): List<ExamTip>
}