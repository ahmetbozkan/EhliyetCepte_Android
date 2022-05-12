package com.ahmetbozkan.ehliyetcepte.ui.scoreboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ahmetbozkan.ehliyetcepte.base.BaseViewModel
import com.ahmetbozkan.ehliyetcepte.core.Status
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamWithQuestions
import com.ahmetbozkan.ehliyetcepte.domain.usecase.exam.GetExamWithQuestionsUseCase
import com.ahmetbozkan.ehliyetcepte.domain.usecase.result.GetAllResultsUseCase
import com.ahmetbozkan.ehliyetcepte.domain.usecase.result.GetExamWithQuestionsAndResultUseCase
import com.ahmetbozkan.ehliyetcepte.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScoreboardViewModel @Inject constructor(
    private val getExamWithQuestionsUseCase: GetExamWithQuestionsUseCase,
    getAllResultsUseCase: GetAllResultsUseCase
) : BaseViewModel() {

    val results = getAllResultsUseCase.invoke()

    private val _examWithQuestions = MutableLiveData<Event<ExamWithQuestions>>()
    val examWithQuestions: LiveData<Event<ExamWithQuestions>> get() = _examWithQuestions

    fun onScoreClicked(examId: Long) = viewModelScope.launch(Dispatchers.IO + genericExceptionHandler) {
        enableLoading()
        val result = getExamWithQuestionsUseCase.invoke(examId)

        when(result.status) {
            Status.SUCCESS -> {
                disableLoading()
                _examWithQuestions.postValue(Event(result.data!!))
            }
            Status.ERROR -> {
                manageException(result.error)
            }
        }
    }

}