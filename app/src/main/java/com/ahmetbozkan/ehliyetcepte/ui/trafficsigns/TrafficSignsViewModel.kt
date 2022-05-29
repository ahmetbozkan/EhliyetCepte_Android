package com.ahmetbozkan.ehliyetcepte.ui.trafficsigns

import com.ahmetbozkan.ehliyetcepte.base.BaseViewModel
import com.ahmetbozkan.ehliyetcepte.domain.usecase.trafficsigns.GetAllTrafficSignsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TrafficSignsViewModel @Inject constructor(
    getAllTrafficSignsUseCase: GetAllTrafficSignsUseCase
) : BaseViewModel() {

    val trafficSigns = getAllTrafficSignsUseCase.invoke()

}