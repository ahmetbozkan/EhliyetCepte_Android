package com.ahmetbozkan.ehliyetcepte.ui.trafficfines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ahmetbozkan.ehliyetcepte.base.BaseViewModel
import com.ahmetbozkan.ehliyetcepte.core.Status
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.TrafficFine
import com.ahmetbozkan.ehliyetcepte.domain.usecase.trafficfines.GetTrafficFinesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrafficFinesViewModel @Inject constructor(
    private val getTrafficFinesUseCase: GetTrafficFinesUseCase
) : BaseViewModel() {

    private val _trafficFines = MutableLiveData<List<TrafficFine>>()
    val trafficFines: LiveData<List<TrafficFine>> get() = _trafficFines

    init {
        getTrafficFines()
    }

    private fun getTrafficFines() =
        viewModelScope.launch(Dispatchers.IO + genericExceptionHandler) {
            enableLoading()

            val result = getTrafficFinesUseCase.invoke()

            when (result.status) {
                Status.SUCCESS -> {
                    disableLoading()
                    _trafficFines.postValue(result.data!!)
                }
                Status.ERROR -> {
                    manageException(result.error)
                }
            }
        }

}