package com.ahmetbozkan.ehliyetcepte.data.datasource

import androidx.lifecycle.LiveData
import com.ahmetbozkan.ehliyetcepte.base.BaseDataSource
import com.ahmetbozkan.ehliyetcepte.data.db.usefultopics.UsefulTopicsDao
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.TrafficSign
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.VehicleGauge
import javax.inject.Inject

class UsefulTopicsDataSource @Inject constructor(
    private val dao: UsefulTopicsDao
) : BaseDataSource() {

    fun getAllVehicleGauges(): LiveData<List<VehicleGauge>> = dao.getAllVehicleGauges()

    fun getAllTrafficSigns(): LiveData<List<TrafficSign>> = dao.getAllTrafficSigns()

}