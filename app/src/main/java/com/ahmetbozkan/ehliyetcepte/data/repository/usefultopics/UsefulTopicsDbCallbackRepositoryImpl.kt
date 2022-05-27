package com.ahmetbozkan.ehliyetcepte.data.repository.usefultopics

import android.content.Context
import com.ahmetbozkan.ehliyetcepte.data.model.vehiclegauges.VehicleGauge
import com.ahmetbozkan.ehliyetcepte.util.Constants
import com.ahmetbozkan.ehliyetcepte.util.extension.parseJsonDataToList
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class UsefulTopicsDbCallbackRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : UsefulTopicsDbCallbackRepository {

    override fun getVehicleGaugesEntities(): List<VehicleGauge> {
        val typeToken = object : TypeToken<List<VehicleGauge>>() {}

        return parseJsonDataToList(
            context,
            Constants.VEHICLE_GAUGES_FILE_NAME,
            typeToken
        )
    }


}