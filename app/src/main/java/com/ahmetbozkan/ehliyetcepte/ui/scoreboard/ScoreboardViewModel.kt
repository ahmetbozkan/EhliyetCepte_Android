package com.ahmetbozkan.ehliyetcepte.ui.scoreboard

import androidx.lifecycle.*
import com.ahmetbozkan.ehliyetcepte.base.BaseViewModel
import com.ahmetbozkan.ehliyetcepte.core.Status
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamCategories
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamWithQuestions
import com.ahmetbozkan.ehliyetcepte.data.model.result.ExamWithQuestionsAndResult
import com.ahmetbozkan.ehliyetcepte.domain.usecase.exam.GetExamWithQuestionsUseCase
import com.ahmetbozkan.ehliyetcepte.domain.usecase.result.GetAllResultsUseCase
import com.ahmetbozkan.ehliyetcepte.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScoreboardViewModel @Inject constructor(
    private val getExamWithQuestionsUseCase: GetExamWithQuestionsUseCase,
    private val getAllResultsUseCase: GetAllResultsUseCase
) : BaseViewModel() {

    private val allResults = getAllResultsUseCase.invoke()

    private val _category = MutableLiveData(ExamCategories.ALL)
    val category: LiveData<ExamCategories> get() = _category

    private val _examWithQuestions = MutableLiveData<Event<ExamWithQuestions>>()
    val examWithQuestions: LiveData<Event<ExamWithQuestions>> get() = _examWithQuestions

    val results: LiveData<List<ExamWithQuestionsAndResult>> = _category.switchMap {
        liveData {
            when (it) {
                ExamCategories.ALL -> emitSource(allResults)
                else -> emitSource(getResultsWithCategory(it))
            }
        }
    }

    fun onScoreClicked(examId: Long) =
        viewModelScope.launch(Dispatchers.IO + genericExceptionHandler) {
            enableLoading()
            val result = getExamWithQuestionsUseCase.invoke(examId)

            when (result.status) {
                Status.SUCCESS -> {
                    disableLoading()
                    _examWithQuestions.postValue(Event(result.data!!))
                }
                Status.ERROR -> {
                    manageException(result.error)
                }
            }
        }

    fun onCategorySelected(category: ExamCategories) {
        _category.postValue(category)
    }

    private fun getResultsWithCategory(category: ExamCategories) =
        getAllResultsUseCase.invoke(category)

}