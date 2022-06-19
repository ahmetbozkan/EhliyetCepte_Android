package com.ahmetbozkan.ehliyetcepte.ui.cityplates

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ahmetbozkan.ehliyetcepte.base.BaseViewModel
import com.ahmetbozkan.ehliyetcepte.core.Status
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.CityPlate
import com.ahmetbozkan.ehliyetcepte.domain.usecase.cityplates.GetAllCityPlatesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CityPlatesViewModel @Inject constructor(
    private val getAllCityPlatesUseCase: GetAllCityPlatesUseCase
) : BaseViewModel() {

    private val _cityPlates = MutableLiveData<List<CityPlate>>()
    val cityPlate: LiveData<List<CityPlate>> get() = _cityPlates

    init {
        getCityPlates()
    }

    private fun getCityPlates() = viewModelScope.launch(Dispatchers.IO + genericExceptionHandler) {
        enableLoading()

        val result = getAllCityPlatesUseCase.invoke()

        when (result.status) {
            Status.SUCCESS -> {
                _cityPlates.postValue(result.data!!)
                disableLoading()
            }
            Status.ERROR -> {
                manageException(result.error)
            }
        }
    }

}