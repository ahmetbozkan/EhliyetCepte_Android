package com.ahmetbozkan.ehliyetcepte.ui.vehiclegauges

import com.ahmetbozkan.ehliyetcepte.base.BaseViewModel
import com.ahmetbozkan.ehliyetcepte.domain.usecase.vehiclegauges.GetAllVehicleGaugesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VehicleGaugesViewModel @Inject constructor(
    getAllVehicleGaugesUseCase: GetAllVehicleGaugesUseCase
) : BaseViewModel() {

    val vehicleGauges = getAllVehicleGaugesUseCase.invoke()

}