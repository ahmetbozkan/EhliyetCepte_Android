package com.ahmetbozkan.ehliyetcepte.ui.examtips

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ahmetbozkan.ehliyetcepte.base.BaseViewModel
import com.ahmetbozkan.ehliyetcepte.core.Status
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.ExamTip
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.ExamTipTypes
import com.ahmetbozkan.ehliyetcepte.domain.usecase.examtips.GetExamTipsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExamTipsViewModel @Inject constructor(
    private val getExamTipsUseCase: GetExamTipsUseCase
) : BaseViewModel() {

    private lateinit var _tips: List<ExamTip>
    val tips: List<ExamTip> get() = _tips

    private val _currentTip = MutableLiveData<ExamTip>()
    val currentTip: LiveData<ExamTip> get() = _currentTip

    private var _index = 0
    val index: Int get() = _index

    fun getExamTips(type: ExamTipTypes) =
        viewModelScope.launch(Dispatchers.IO + genericExceptionHandler) {
            enableLoading()

            val result = getExamTipsUseCase.invoke(type)

            when (result.status) {
                Status.SUCCESS -> {
                    disableLoading()
                    setInitialTip(result.data!!)
                }
                Status.ERROR -> {
                    manageException(result.error)
                }
            }
        }

    private fun setInitialTip(tips: List<ExamTip>) {
        _tips = tips
        _currentTip.postValue(tips[index])
    }

    fun onPreviousTipClicked() {
        _index--
        _currentTip.postValue(tips[index])
    }

    fun onNextTipClicked() {
        _index++
        _currentTip.postValue(tips[index])
    }

}