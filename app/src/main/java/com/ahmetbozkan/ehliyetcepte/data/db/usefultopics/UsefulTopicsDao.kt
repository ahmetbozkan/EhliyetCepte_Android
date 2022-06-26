package com.ahmetbozkan.ehliyetcepte.data.db.usefultopics

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.*

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

    /**
     * CITY PLATES
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(cityPlate: CityPlate)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg cityPlate: CityPlate)

    @Transaction
    @Query("SELECT * FROM city_plates")
    suspend fun getCityPlates(): List<CityPlate>

    /**
     * FREQUENTLY ASKED QUESTIONS
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(faq: FAQ)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg faq: FAQ)

    @Transaction
    @Query("SELECT * FROM frequently_asked_questions")
    suspend fun getFrequentlyAskedQuestions(): List<FAQ>

    /**
     * TRAFFIC FINES (Trafik Cezaları)
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(trafficFine: TrafficFine)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg trafficFine: TrafficFine)

    @Transaction
    @Query("SELECT * FROM traffic_fines")
    suspend fun getTrafficFines(): List<TrafficFine>
}