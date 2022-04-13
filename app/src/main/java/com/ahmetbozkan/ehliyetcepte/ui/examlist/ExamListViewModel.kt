package com.ahmetbozkan.ehliyetcepte.ui.examlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ahmetbozkan.ehliyetcepte.base.BaseViewModel
import com.ahmetbozkan.ehliyetcepte.core.Status
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Exam
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamCategories
import com.ahmetbozkan.ehliyetcepte.domain.exam.GetExamsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExamListViewModel @Inject constructor(
    private val getExamsUseCase: GetExamsUseCase
) : BaseViewModel() {

    private val _exams = MutableLiveData<List<Exam>>()
    val exams: LiveData<List<Exam>> = _exams

    fun getExams(category: ExamCategories) =
        viewModelScope.launch(Dispatchers.IO + genericExceptionHandler) {
            enableLoading()
            val response = getExamsUseCase.invoke(category)

            when (response.status) {
                Status.SUCCESS -> {
                    _exams.postValue(response.data ?: listOf())
                    disableLoading()
                }
                Status.ERROR -> {
                    manageException(response.error)
                    disableLoading()
                }
            }
        }
}