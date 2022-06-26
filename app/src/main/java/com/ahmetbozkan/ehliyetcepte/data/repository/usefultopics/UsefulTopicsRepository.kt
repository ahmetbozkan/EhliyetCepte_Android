package com.ahmetbozkan.ehliyetcepte.data.repository.usefultopics

import androidx.lifecycle.LiveData
import com.ahmetbozkan.ehliyetcepte.core.Resource
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.*

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

    /**
     * get all the exam tips from the UsefulTopicsDb
     * @param type of the tip
     * @return list of ExamTips object wrapped in resource
     */
    suspend fun getExamTips(type: ExamTipTypes): Resource<List<ExamTip>>

    /**
     * get all the city plates from the UsefulTopicsDb
     * @return list of CityPlate object wrapped in resource
     */
    suspend fun getCityPlates(): Resource<List<CityPlate>>

    /**
     * get all the frequently asked questions from the UsefulTopicsDb
     * @return list of FAQ object wrapped in resource
     */
    suspend fun getFrequentlyAskedQuestions(): Resource<List<FAQ>>

}