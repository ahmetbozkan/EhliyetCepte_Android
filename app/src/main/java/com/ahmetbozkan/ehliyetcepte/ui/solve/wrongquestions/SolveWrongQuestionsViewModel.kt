package com.ahmetbozkan.ehliyetcepte.ui.solve.wrongquestions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ahmetbozkan.ehliyetcepte.base.BaseViewModel
import com.ahmetbozkan.ehliyetcepte.core.Status
import com.ahmetbozkan.ehliyetcepte.data.model.exam.WrongQuestion
import com.ahmetbozkan.ehliyetcepte.domain.usecase.wrongquestions.GetAllWrongQuestionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SolveWrongQuestionsViewModel @Inject constructor(
    private val getAllWrongQuestionsUseCase: GetAllWrongQuestionsUseCase
) : BaseViewModel() {

    private lateinit var _questions: List<WrongQuestion>
    val questions: List<WrongQuestion> get() = _questions

    private val _currentQuestion = MutableLiveData<WrongQuestion>()
    val currentQuestion: LiveData<WrongQuestion> get() = _currentQuestion

    private var _index = 0
    val index: Int get() = _index

    init {
        getAllWrongQuestions()
    }

    private fun getAllWrongQuestions() =
        viewModelScope.launch(Dispatchers.IO + genericExceptionHandler) {
            enableLoading()
            val result = getAllWrongQuestionsUseCase.invoke()

            when (result.status) {
                Status.SUCCESS -> {
                    setInitialQuestion(result.data!!)
                    disableLoading()
                }
                Status.ERROR -> {
                    manageException(result.error)
                }
            }
        }

    private fun setInitialQuestion(questions: List<WrongQuestion>) {
        if (questions.isEmpty())
            return

        _currentQuestion.postValue(questions[index])
        _questions = questions
    }

}