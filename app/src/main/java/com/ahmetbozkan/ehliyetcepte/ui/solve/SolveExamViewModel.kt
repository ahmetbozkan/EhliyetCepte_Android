package com.ahmetbozkan.ehliyetcepte.ui.solve

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ahmetbozkan.ehliyetcepte.base.BaseViewModel
import com.ahmetbozkan.ehliyetcepte.core.Status
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamWithQuestions
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Options
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Question
import com.ahmetbozkan.ehliyetcepte.domain.exam.GetExamWithQuestionsUseCase
import com.ahmetbozkan.ehliyetcepte.util.extension.orZero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SolveExamViewModel @Inject constructor(
    private val getExamWithQuestionsUseCase: GetExamWithQuestionsUseCase
) : BaseViewModel() {

    private lateinit var _examWithQuestions: ExamWithQuestions
    val examWithQuestions: ExamWithQuestions get() = _examWithQuestions

    private val _currentQuestion = MutableLiveData<Question>()
    val currentQuestion: LiveData<Question> get() = _currentQuestion

    private var _index = 0
    val index: Int get() = _index

    private val _selectedOptions = HashMap<Long, Options>()
    val selectedOptions: Map<Long, Options> get() = _selectedOptions

    fun getExamWithQuestions(examId: Long) =
        viewModelScope.launch(Dispatchers.IO + genericExceptionHandler) {
            enableLoading()
            val response = getExamWithQuestionsUseCase.invoke(examId)

            when (response.status) {
                Status.SUCCESS -> {
                    setInitialQuestion(response.data!!)
                    disableLoading()
                }
                Status.ERROR -> {
                    manageException(response.error)
                }
            }
        }

    private fun setInitialQuestion(examWithQuestions: ExamWithQuestions) {
        _examWithQuestions = examWithQuestions
        _currentQuestion.postValue(examWithQuestions.questions[index])
    }

    fun onPreviousQuestionClicked() {
        _index--
        _currentQuestion.postValue(examWithQuestions.questions[index])
    }

    fun onNextQuestionClicked() {
        _index++
        _currentQuestion.postValue(examWithQuestions.questions[index])
    }

    fun onOptionSelected(selectedOption: Options, isSelectedOptionSame: Boolean) {
        val currentQuestionId = currentQuestion.value?.questionId

        if (isSelectedOptionSame)
            _selectedOptions.remove(currentQuestionId.orZero())
        else
            _selectedOptions[currentQuestionId.orZero()] = selectedOption
    }

}