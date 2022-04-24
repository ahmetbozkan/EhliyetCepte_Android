package com.ahmetbozkan.ehliyetcepte.ui.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ahmetbozkan.ehliyetcepte.base.BaseViewModel
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Exam
import com.ahmetbozkan.ehliyetcepte.data.model.result.Result
import com.ahmetbozkan.ehliyetcepte.domain.usecase.exam.UpdateExamUseCase
import com.ahmetbozkan.ehliyetcepte.domain.usecase.result.CalculateResultUseCase
import com.ahmetbozkan.ehliyetcepte.domain.usecase.result.InsertResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    private val calculateResultUseCase: CalculateResultUseCase,
    private val updateExamUseCase: UpdateExamUseCase,
    private val insertResultUseCase: InsertResultUseCase
) : BaseViewModel() {

    private val _calculatedResult = MutableLiveData<Result>()
    val calculatedResult: LiveData<Result> get() = _calculatedResult

    fun onExamFinished(solvedExamEntity: SolvedExamEntity) {
        val result = calculateResultUseCase.invoke(solvedExamEntity)

        _calculatedResult.postValue(result)

        updateExam(solvedExamEntity.examWithQuestions.exam)
        insertResult(result)
    }

    private fun updateExam(exam: Exam) =
        viewModelScope.launch(Dispatchers.IO + genericExceptionHandler) {
            val updatedExam = exam.copy(
                isSolved = true,
                solvedDate = System.currentTimeMillis()
            )

            updateExamUseCase.invoke(updatedExam)
        }

    private fun insertResult(result: Result) =
        viewModelScope.launch(Dispatchers.IO + genericExceptionHandler) {
            insertResultUseCase.invoke(result)
        }
}