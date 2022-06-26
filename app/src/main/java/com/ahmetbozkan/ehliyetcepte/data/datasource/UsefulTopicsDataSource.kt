package com.ahmetbozkan.ehliyetcepte.data.datasource

import androidx.lifecycle.LiveData
import com.ahmetbozkan.ehliyetcepte.base.BaseDataSource
import com.ahmetbozkan.ehliyetcepte.core.Resource
import com.ahmetbozkan.ehliyetcepte.data.db.usefultopics.UsefulTopicsDao
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.*
import javax.inject.Inject

class UsefulTopicsDataSource @Inject constructor(
    private val dao: UsefulTopicsDao
) : BaseDataSource() {

    fun getAllVehicleGauges(): LiveData<List<VehicleGauge>> = dao.getAllVehicleGauges()

    fun getAllTrafficSigns(): LiveData<List<TrafficSign>> = dao.getAllTrafficSigns()

    suspend fun getExamTips(type: ExamTipTypes): Resource<List<ExamTip>> =
        handleOperation {
            dao.getExamTips(type.value)
        }

    suspend fun getCityPlates(): Resource<List<CityPlate>> =
        handleOperation {
            dao.getCityPlates()
        }

    suspend fun getFrequentlyAskedQuestions(): Resource<List<FAQ>> =
        handleOperation {
            dao.getFrequentlyAskedQuestions()
        }


}