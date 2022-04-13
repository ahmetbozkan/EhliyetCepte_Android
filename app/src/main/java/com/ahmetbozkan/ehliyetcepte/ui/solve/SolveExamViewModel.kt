package com.ahmetbozkan.ehliyetcepte.ui.solve

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ahmetbozkan.ehliyetcepte.base.BaseViewModel
import com.ahmetbozkan.ehliyetcepte.core.Status
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamWithQuestions
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Question
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

    private val _currentQuestion = MutableLiveData<Question>()
    val currentQuestion: LiveData<Question> get() = _currentQuestion

    fun getExamWithQuestions(examId: Long) = viewModelScope.launch {
        enableLoading()
        val response = getExamWithQuestionsUseCase.invoke(examId)

        when (response.status) {
            Status.SUCCESS -> {
                _exam.postValue(response.data!!)
                setInitialQuestion(response.data)
                disableLoading()
            }
            Status.ERROR -> {
                manageException(response.error)
            }
        }
    }

    private fun setInitialQuestion(examWithQuestion: ExamWithQuestions) {
        _currentQuestion.postValue(examWithQuestion.questions[0])
    }

}