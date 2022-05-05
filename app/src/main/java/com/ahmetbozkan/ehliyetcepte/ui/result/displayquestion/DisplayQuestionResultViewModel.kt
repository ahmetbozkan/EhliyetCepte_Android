package com.ahmetbozkan.ehliyetcepte.ui.result.displayquestion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ahmetbozkan.ehliyetcepte.base.BaseViewModel
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamWithQuestions
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Question
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DisplayQuestionResultViewModel @Inject constructor() : BaseViewModel() {

    private lateinit var _examWithQuestions: ExamWithQuestions
    val examWithQuestions: ExamWithQuestions get() = _examWithQuestions

    private val _currentQuestion = MutableLiveData<Question>()
    val currentQuestion: LiveData<Question> get() = _currentQuestion

    private var _index = 0
    val index get() = _index

    fun setInitialQuestion(position: Int, examWithQuestions: ExamWithQuestions) {
        val questions = examWithQuestions.questions
        _examWithQuestions = examWithQuestions

        _index = position
        _currentQuestion.postValue(questions[index])
    }

    fun onPreviousQuestionClicked() {
        _index--
        _currentQuestion.postValue(examWithQuestions.questions[index])
    }

    fun onNextQuestionClicked() {
        _index++
        _currentQuestion.postValue(examWithQuestions.questions[index])
    }

}