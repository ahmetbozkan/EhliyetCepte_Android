package com.ahmetbozkan.ehliyetcepte.data.repository.usefultopics

import androidx.lifecycle.LiveData
import com.ahmetbozkan.ehliyetcepte.data.datasource.UsefulTopicsDataSource
import com.ahmetbozkan.ehliyetcepte.data.model.vehiclegauges.VehicleGauge
import javax.inject.Inject

class UsefulTopicsRepositoryImpl @Inject constructor(
    private val dataSource: UsefulTopicsDataSource
) : UsefulTopicsRepository {

    override fun getAllVehicleGauges(): LiveData<List<VehicleGauge>> {
        return dataSource.getAllVehicleGauges()
    }


}