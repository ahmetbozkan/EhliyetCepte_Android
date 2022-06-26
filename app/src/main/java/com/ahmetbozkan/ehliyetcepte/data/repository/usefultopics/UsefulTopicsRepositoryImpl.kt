package com.ahmetbozkan.ehliyetcepte.data.repository.usefultopics

import androidx.lifecycle.LiveData
import com.ahmetbozkan.ehliyetcepte.core.Resource
import com.ahmetbozkan.ehliyetcepte.core.Status
import com.ahmetbozkan.ehliyetcepte.data.datasource.UsefulTopicsDataSource
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.*
import javax.inject.Inject

class UsefulTopicsRepositoryImpl @Inject constructor(
    private val dataSource: UsefulTopicsDataSource
) : UsefulTopicsRepository {

    override fun getAllVehicleGauges(): LiveData<List<VehicleGauge>> {
        return dataSource.getAllVehicleGauges()
    }

    override fun getAllTrafficSigns(): LiveData<List<TrafficSign>> {
        return dataSource.getAllTrafficSigns()
    }

    override suspend fun getExamTips(type: ExamTipTypes): Resource<List<ExamTip>> {
        val result = dataSource.getExamTips(type)

        return when (result.status) {
            Status.SUCCESS -> Resource.success(result.data!!)
            Status.ERROR -> Resource.error(null, result.error)
        }
    }

    override suspend fun getCityPlates(): Resource<List<CityPlate>> {
        val result = dataSource.getCityPlates()

        return when (result.status) {
            Status.SUCCESS -> Resource.success(result.data!!)
            Status.ERROR -> Resource.error(null, result.error)
        }
    }

    override suspend fun getFrequentlyAskedQuestions(): Resource<List<FAQ>> {
        val result = dataSource.getFrequentlyAskedQuestions()

        return when (result.status) {
            Status.SUCCESS -> Resource.success(result.data!!)
            Status.ERROR -> Resource.error(null, result.error)
        }
    }

    override suspend fun getTrafficFines(): Resource<List<TrafficFine>> {
        val result = dataSource.getTrafficFines()

        return when (result.status) {
            Status.SUCCESS -> Resource.success(result.data!!)
            Status.ERROR -> Resource.error(null, result.error)
        }
    }


}