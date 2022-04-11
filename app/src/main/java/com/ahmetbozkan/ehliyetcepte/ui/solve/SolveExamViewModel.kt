package com.ahmetbozkan.ehliyetcepte.ui.solve

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ahmetbozkan.ehliyetcepte.base.BaseViewModel
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamWithQuestions
import com.ahmetbozkan.ehliyetcepte.domain.exam.GetExamWithQuestionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SolveExamViewModel @Inject constructor(
    private val getExamWithQuestionsUseCase: GetExamWithQuestionsUseCase
) : BaseViewModel() {

    private val _exam = MutableLiveData<ExamWithQuestions>()
    val exam: LiveData<ExamWithQuestions> get() = _exam

    fun getExamWithQuestions(examId: Long) = viewModelScope.launch {
        val exam = getExamWithQuestionsUseCase.invoke(examId)
        _exam.postValue(exam)
    }

}