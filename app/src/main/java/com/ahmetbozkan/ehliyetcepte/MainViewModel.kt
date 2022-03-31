package com.ahmetbozkan.ehliyetcepte

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.ahmetbozkan.ehliyetcepte.base.BaseViewModel
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamCategories
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamWithQuestionsAndAnswers
import com.ahmetbozkan.ehliyetcepte.domain.exam.GetExamCountUseCase
import com.ahmetbozkan.ehliyetcepte.domain.exam.GetExamsWithCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getExamsWithCategoryUseCase: GetExamsWithCategoryUseCase,
    private val getExamCountUseCase: GetExamCountUseCase
) : BaseViewModel() {

    val examCount = getExamCountUseCase.invoke()

    fun getExams(category: ExamCategories) =
        liveData(Dispatchers.IO + genericExceptionHandler) {
            emit(getExamsWithCategoryUseCase.invoke(category))
        }

}